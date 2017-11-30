package faculife

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Materia)
class MateriaSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def 'creo una materia y le defino correlativas' () {
      when:
          Materia proba = new Materia(nombre: 'probabilidad y estadistica'
          , codigo: '81.04')
          Materia analisis = new Materia(nombre: 'analisis matematico II'
          , codigo: '81.01')
          Materia algebra = new Materia(nombre: 'algebra II'
          , codigo: '81.02')

          proba.asignarCorrelativa(analisis)
          proba.asignarCorrelativa(algebra)
      then:
          proba.getSizeCorrelativas() == 2
    }

}
