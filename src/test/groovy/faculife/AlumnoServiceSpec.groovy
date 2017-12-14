package faculife

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AlumnoService)
class AlumnoServiceSpec extends Specification {

    Carrera carrera
    Alumno alumno
    //Materia analisis1
    Materia algoritmos1
    def setup() {
        // algoritmos1 = new Materia(codigo: '7115', nombre: 'Algoritmos')
        // algoritmos1.save()

        Cuatrimestre cuatrimestre12017 = new Cuatrimestre(anio: 2017, numero: Cuatrimestre.Numero.PRIMERO)
        cuatrimestre12017.save()

        // Curso analisis112017 = new Curso(cuatrimestre: cuatrimestre12017, materia: analisis1)
        // analisis112017.save()

        // Curso algoritmos112017 = new Curso(cuatrimestre: cuatrimestre12017, materia: algoritmos1)
        // algoritmos112017.save()

        // carrera = new Carrera(codigo: "9", nombre: "Sistemas")
        // carrera.addToMaterias(analisis112017)
        // carrera.addToMaterias(algoritmos112017)
        // carrera.save()

        // alumno = new Alumno(nombres: 'gaston'
        //     , apellidos: 'Perez'
        //     , numeroDocumento: '34114043'
        //     , fechaNacimiento: new Date())
        // alumno.save()
        // alumno.aprobarMateria(analisis1)
        
    }

    def cleanup() {
    }

    void "prueba"() {
        when:
            def coso = service.planificarCursada(alumno, carrera)
        then:
            coso == [analisis1]
    }
}
