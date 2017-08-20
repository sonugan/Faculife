package faculife

import grails.test.mixin.TestFor
import grails.test.hibernate.HibernateSpec

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Cuatrimestre)
class CuatrimestreSpec extends HibernateSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "test cuatrimestre valido"() {
        when:
            Cuatrimestre cuatrimestre = new Cuatrimestre(anio: 2015, numero: Cuatrimestre.Numero.PRIMERO)
            cuatrimestre.save()
        then:
            Cuatrimestre.count() == 1
    }

    void "test sin anio"() {
        when:
            Cuatrimestre cuatrimestre = new Cuatrimestre(numero: Cuatrimestre.Numero.PRIMERO)
            cuatrimestre.save()
        then:
            cuatrimestre.hasErrors()
            cuatrimestre.errors.getFieldErrors('anio')
            Cuatrimestre.count() == 0
    }

    void "test sin numero"() {
        when:
            Cuatrimestre cuatrimestre = new Cuatrimestre(anio: 2015)
            cuatrimestre.save()
        then:
            cuatrimestre.hasErrors()
            cuatrimestre.errors.getFieldErrors('numero')
            Cuatrimestre.count() == 0
    }
}
