package faculife

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.hibernate.HibernateSpec

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Materia)
class MateriaSpec extends HibernateSpec {

    Departamento departamento
    def setup() {
        departamento = new Departamento(codigo: '71', nombre:'Gestion')
        departamento.save()

    }

    def cleanup() {
    }

    def 'crear materia valida'() {
        when:
            Materia materia = new Materia(departamento: departamento
                , codigo:'7116'
                , nombre:'Analisis de proyectos')
            materia.save()
        then:
            Materia.count() == 1
            materia.codigo == '7116'
            materia.nombre == 'Analisis de proyectos'
            materia.departamento.codigo == '71'
            materia.departamento.nombre == 'Gestion'
            Materia.get(1).correlativas.count() == 0
    }

    def 'crear materia valida con correlativas'() {
        when:
            Materia materia = new Materia(departamento: departamento
                , codigo:'7116'
                , nombre:'Analisis de proyectos')
            Materia correlativa1 = new Materia(departamento: departamento
                , codigo:'7110'
                , nombre:'Información de las organizaciones')
            correlativa1.save()

            Materia correlativa2 = new Materia(departamento: departamento
                , codigo:'7113'
                , nombre:'Modelos y optimizacion I')
            correlativa2.save()

            materia.addToCorrelativas(correlativa1)
            materia.addToCorrelativas(correlativa2)
            materia.save()
        then:
            Materia.count() == 3
            materia.codigo == '7116'
            materia.nombre == 'Analisis de proyectos'
            materia.departamento.codigo == '71'
            materia.departamento.nombre == 'Gestion'
            (Materia.where { codigo == '7116' }).find().correlativas.size() == 2
    }

    def 'crear materia sin codigo'() {
        when:
        Materia materia = new Materia(departamento: departamento
            , nombre:'Analisis de proyectos')
            materia.save()
        then:
            materia.hasErrors()
            materia.errors.getFieldErrors('codigo')
            Materia.count() == 0
    }

    def 'crear materia con codigo vacio'() {
        when:
        Materia materia = new Materia(departamento: departamento
            , codigo:''
            , nombre:'Analisis de proyectos')
            materia.save()
        then:
            materia.hasErrors()
            materia.errors.getFieldErrors('codigo')
            Materia.count() == 0
    }

    def 'crear materia sin nombre'() {
        when:
        Materia materia = new Materia(departamento: departamento
            , codigo:'16')
            materia.save()
        then:
            materia.hasErrors()
            materia.errors.getFieldErrors('nombre')
            Materia.count() == 0
    }

    def 'crear materia con nombre vacio'() {
        when:
        Materia materia = new Materia(departamento: departamento
            , codigo:'16'
            , nombre:'')
            materia.save()
        then:
            materia.hasErrors()
            materia.errors.getFieldErrors('nombre')
            Materia.count() == 0
    }

    def 'crear materia con nombre de menos de 3 caracteres'() {
        when:
        Materia materia = new Materia(departamento: departamento
            , codigo:'16'
            , nombre:'An')
            materia.save()
        then:
            materia.hasErrors()
            materia.errors.getFieldErrors('nombre')
            Materia.count() == 0
    }

    def 'crear materia con nombre de mas de 60 caracteres'() {
        when:
        Materia materia = new Materia(departamento: departamento
            , codigo:'16'
            , nombre:'0123456789012345678901234567890123456789012345678901234567891')
            materia.save()
        then:
            materia.hasErrors()
            materia.errors.getFieldErrors('nombre')
            Materia.count() == 0
    }

    def 'crear materia sin departamento'() {
        when:
        Materia materia = new Materia(codigo:'16'
            , nombre:'Analisis de proyectos')
            materia.save()
        then:
            materia.hasErrors()
            materia.errors.getFieldErrors('departamento')
            Materia.count() == 0
    }
}
