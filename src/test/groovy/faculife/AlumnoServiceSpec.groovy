package faculife

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AlumnoService)
class AlumnoServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "prueba"() {
        when:
            Carrera carrera = new Carrera(codigo: "9", nombre: "Sistemas")
        
            Alumno alumno = new Alumno(nombres: 'gaston'
                , apellidos: 'Perez'
                , numeroDocumento: '34114043'
                , fechaNacimiento: new Date())
     
            def coso = service.planificarCursada(alumno, carrera)
        then:
            coso == null
    }
}
