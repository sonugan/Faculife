package faculife

import grails.test.mixin.TestFor
import grails.test.hibernate.HibernateSpec

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Carrera)
class CarreraSpec extends HibernateSpec {

    def setup() {
    }

    def cleanup() {
    }

    def 'crear carrera valida'() {
        when:
            Carrera sistemas = new Carrera(codigo: "9", nombre: "Sistemas")
            sistemas.save()
        then:
            Carrera.count() == 1
    }

    def 'crear carrera sin codigo'() {
        when:
            Carrera sistemas = new Carrera(nombre: "Sistemas")
            sistemas.save()
        then:
            sistemas.hasErrors()
            sistemas.errors.getFieldErrors('codigo')
            Carrera.count() == 0
    }

    def 'crear carrera con codigo nulo'() {
        when:
            Carrera sistemas = new Carrera(codigo: null, nombre: "Sistemas")
            sistemas.save()
        then:
            sistemas.hasErrors()
            sistemas.errors.getFieldErrors('codigo')
            Carrera.count() == 0
    }

    def 'crear carrera sin nombre'() {
        when:
            Carrera sistemas = new Carrera(codigo: '9')
            sistemas.save()
        then:
            sistemas.hasErrors()
            sistemas.errors.getFieldErrors('nombre')
            Carrera.count() == 0
    }

    def 'crear carrera con nombre nulo'() {
        when:
            Carrera sistemas = new Carrera(codigo: '9', nombre: null)
            sistemas.save()
        then:
            sistemas.hasErrors()
            sistemas.errors.getFieldErrors('nombre')
            Carrera.count() == 0
    }
}
