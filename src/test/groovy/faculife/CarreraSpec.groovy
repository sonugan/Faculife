package faculife

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Carrera)
class CarreraSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def 'crear carrera con valores validos'() {
      when:
          Carrera unaCarrera = new Carrera(nombre: 'sistemas'
          , codigo: '8989')
          unaCarrera.save()

      then:
          unaCarrera.nombre == 'sistemas'
          unaCarrera.codigo == '8989'
    }
}
