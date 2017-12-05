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
    Curso proba_2018_1b
    Curso proba_2018_1a
    Docente jemina
    Docente grynberg
    Docente acero
    Horario turnoNoche
    Horario turnoTarde
    Horario turnoManiana
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
      proba_2018_1b = new Curso(cuatrimestre: primerCuatrimestre2018, materia: proba)
      proba_2018_1b.save()
      proba_2018_1a = new Curso(cuatrimestre: primerCuatrimestre2018, materia: proba)
      proba_2018_1a.save()

      jemina = new Docente(legajo: 9898, nombres: "Jemina"
      , apellidos: "Garcia", fechaNacimiento: new Date())
      jemina.save()
      grynberg = new Docente(legajo: 9899, nombres: "Sebastian"
      , apellidos: "Gryunberg", fechaNacimiento: new Date())
      grynberg.save()
      acero = new Docente(legajo: 9897, nombres: "Fernando"
      , apellidos: "Acero", fechaNacimiento: new Date())
      acero.save()

      turnoNoche = new Horario(dia: LUNES
        , horarioDesde: new Date(), horarioHasta: new Date())
        //solucionar los horarios
      turnoNoche.save()
      turnoTarde = new Horario(dia: MIERCOLES
        , horarioDesde: new Date(), horarioHasta: new Date())
      turnoTarde.save()
      turnoManiana = new Horario(dia: VIERNES
        , horarioDesde: new Date(), horarioHasta: new Date())
      turnoManiana.save()
    }

    def cleanup() {
    }

    def "curso queda habilitado, porque cumple con los requisitos"() {
        when:
            proba_2018_1c.addToAlumnos(gaston)
            proba_2018_1c.addToDocentes(jemina)
            proba_2018_1c.addToHorarios(turnoNoche)

        then:
            assert proba_2018_1c.estaHabilitado() == true
    }

    def "curso no se puede habilitar porque no cumple con los requisitos minimos"() {
        assert proba_2018_1c.estaHabilitado() == false

        proba_2018_1c.addToAlumnos(gaston)
        assert proba_2018_1c.estaHabilitado() == false

        proba_2018_1c.addToDocentes(jemina)
        assert proba_2018_1c.estaHabilitado() == false
    }

    def "materia tiene al menos un curso habilitado, por ende la materiia se puede cursar"() {
        when:

    }

}
