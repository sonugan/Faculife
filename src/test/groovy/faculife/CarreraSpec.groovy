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

    def 'asignarle una carrera a un alumno' () {
      when:
          Carrera carrera = new Carrera(codigo: '8989'
              , nombre: 'Analisis de Sistemas')
          Materia analisis = new Materia(nombre: 'analisis matematico II'
              , codigo: '81.01')
          Curso curso = new Curso(description: '1B Acero')
          Alumno alumno = new Alumno(padron: '123456'
              , nombres: 'Gaston'
              , apellidos: 'Perez'
              , numeroDocumento: '34114043'
              , fechaNacimiento: new Date())

          carrera.save()
          alumno.save()
          analisis.addToCursos(curso)
          carrera.adToMaterias(analisis)
          alumno.addToCursos(curso)

      //then:

    }
}
