package faculife

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Materia)
class MateriaSpec extends Specification {
    Materia proba
    Materia analisis2
    Materia algebra2
    Alumno gaston
    Curso analisis2_a
    Curso algebra2_b

    def setup() {
      gaston = new Alumno(
        padron: '123456'
      , nombres: 'Gaston'
      , apellidos: 'Perez'
      , numeroDocumento: '34114043'
      , fechaNacimiento: new Date())

      Cuatrimestre primerCuatri2017 = new Cuatrimestre(anio: 2017, numero: 1)
      //primerCuatri2017.save()

      analisis2 = new Materia(codigo: "81.01", nombre: "Analisis Matematico II")
      algebra2 = new Materia(codigo: "81.02", nombre: "Algebra II")
      proba = new Materia(codigo: "81.04", nombre: "Probabilidad y estadistica B")

      analisis2_a = new Curso(cuatrimestre: primerCuatri2017, materia: analisis2)
      algebra2_b = new Curso(cuatrimestre: primerCuatri2017, materia: algebra2)

      proba.save()
      //analisis2.save()
      //algebra2.save()

    }

    def cleanup() {
    }

    def 'el alumno puede cursar la materia porque aprobo las correlatividades' () {
      when:
          proba.addToCorrelativas(analisis2)
          proba.addToCorrelativas(algebra2)

          gaston.save()
          gaston.addToCursos(analisis2_a)
          gaston.addToCursos(algebra2_b)

          //agrego notas del alumno
          gaston.addToNotas(new Nota(nota: 8, materia: analisis2))//analisis2
          gaston.addToNotas(new Nota(nota: 7, materia: algebra2))//algebra2
          //como vinculo cada nota con la materia*/

      then:
          proba.correlativas.size() == 2
          gaston.notas.size() == 2
          gaston.puedeCursar(proba) == true
    }
}
