package faculife

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Curso)
class CursoSpec extends Specification {
    Materia proba
    Curso proba_2018_1c
    Docente jemina
    Horario turnoNoche
    Alumno gaston
    Cuatrimestre primerCuatrimestre2018

    def setup() {
      gaston = new Alumno(
        padron: '123456'
      , nombres: 'Gaston'
      , apellidos: 'Perez'
      , numeroDocumento: '34114043'
      , fechaNacimiento: new Date())
      gaston.save()

      proba = new Materia(codigo: "81.04", nombre: "Probabilidad y estadistica B")
      proba.save()
      primerCuatrimestre2018 = new Cuatrimestre(anio: 2018, numero: 1)
      primerCuatrimestre2018.save()
      proba_2018_1c = new Curso(cuatrimestre: primerCuatrimestre2018, materia: proba)
      proba_2018_1c.save()
      jemina = new Docente(legajo: 9898, nombres: "Jemina"
      , apellidos: "Garcia", fechaNacimiento: new Date())
      jemina.save()
      turnoNoche = new Horario(dia: LUNES
        , horarioDesde: new Date(), horarioHasta: new Date())
        //solucionar los horarios
      turnoNoche.save()
    }

    def cleanup() {
    }

}
