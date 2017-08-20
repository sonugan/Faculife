package faculife

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.hibernate.HibernateSpec

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Departamento)
class DepartamentoSpec extends HibernateSpec {

    def setup() {
    }

    def cleanup() {
    }

    def 'crear departamento valido'() {
        when:
            Departamento departamento = new Departamento(codigo:'75', nombre:'Computación')
            departamento.save()
        then:
            Departamento.count() == 1
    }

    def 'crear departamento sin codigo'() {
        when:
            Departamento departamento = new Departamento(nombre:'Computación')
            departamento.save()
        then:
            departamento.hasErrors()
            departamento.errors.getFieldErrors('codigo')
            Departamento.count() == 0
    }

    def 'crear departamento con codigo vacio'() {
        when:
            Departamento departamento = new Departamento(codigo:'', nombre:'Computación')
            departamento.save()
        then:
            departamento.hasErrors()
            departamento.errors.getFieldErrors('codigo')
            Departamento.count() == 0
    }

    def 'crear departamento sin nombre'() {
        when:
            Departamento departamento = new Departamento(codigo:'75')
            departamento.save()
        then:
            departamento.hasErrors()
            departamento.errors.getFieldErrors('nombre')
            Departamento.count() == 0
    }

    def 'crear departamento con nombre vacio'() {
        when:
            Departamento departamento = new Departamento(codigo:'75', nombre:'')
            departamento.save()
        then:
            departamento.hasErrors()
            departamento.errors.getFieldErrors('nombre')
            Departamento.count() == 0
    }

    def 'crear departamento con nombre con menos de 3 caracteres'() {
        when:
            Departamento departamento = new Departamento(codigo:'75', nombre:'Co')
            departamento.save()
        then:
            departamento.hasErrors()
            departamento.errors.getFieldErrors('nombre')
            Departamento.count() == 0
    }

    def 'crear departamento con nombre de mas de 60 caracteres'() {
        when:
            Departamento departamento = new Departamento(codigo:'75', nombre:'0123456789012345678901234567890123456789012345678901234567891')
            departamento.save()
        then:
            departamento.hasErrors()
            departamento.errors.getFieldErrors('nombre')
            Departamento.count() == 0
    }
}
