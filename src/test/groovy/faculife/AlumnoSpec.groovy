package faculife

import grails.test.mixin.TestFor
import grails.test.hibernate.HibernateSpec

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Alumno)
class AlumnoSpec extends HibernateSpec {

    Alumno alumnoValido
    Carrera industrial
    Carrera sistemas
    def setup() {
        alumnoValido = new Alumno(
              padron: '123456'
            , nombres: 'Gaston'
            , apellidos: 'Perez'
            , numeroDocumento: '34114043'
            , fechaNacimiento: new Date())

        industrial = new Carrera(codigo: "2", nombre: "Industrial")
        industrial.save()

        sistemas = new Carrera(codigo: "9", nombre: "Sistemas")
        sistemas.save()
    }

    def cleanup() {
    }

    def 'crear alumno valido'() {
        when:
            Alumno alumno = new Alumno(padron: '123456'
                , nombres: 'Gaston'
                , apellidos: 'Perez'
                , numeroDocumento: '34114043'
                , fechaNacimiento: new Date())
            alumno.save()
        then:
            Alumno.count() == 1
    }

    def 'crear alumno sin fecha de nacimiento'() {
        when:
            Alumno alumno = new Alumno(padron: '123456'
                , nombres: 'Gaston'
                , apellidos: 'Perez'
                , numeroDocumento: '34114043')
            alumno.save()
        then:
            alumno.hasErrors()
            alumno.errors.getFieldErrors('fechaNacimiento')
            Alumno.count() == 0
    }

    def 'crear alumno sin padron'() {
        when:
            Alumno alumno = new Alumno(nombres: 'Gaston'
                , apellidos: 'Perez'
                , numeroDocumento: '34114043'
                , fechaNacimiento: new Date())
            alumno.save()
        then:
            alumno.hasErrors()
            alumno.errors.getFieldErrors('padron')
            Alumno.count() == 0
    }

    def 'crear alumno con padron vacio'() {
        when:
            Alumno alumno = new Alumno(padron: ''
                , nombres: 'Gaston'
                , apellidos: 'Perez'
                , numeroDocumento: '34114043'
                , fechaNacimiento: new Date())
            alumno.save()
        then:
            alumno.hasErrors()
            alumno.errors.getFieldErrors('padron')
            Alumno.count() == 0
    }

    def 'crear alumno sin nombre'() {
        when:
            Alumno alumno = new Alumno(
                 apellidos: 'Perez'
                , numeroDocumento: '34114043'
                , fechaNacimiento: new Date())
            alumno.save()
        then:
            alumno.hasErrors()
            alumno.errors.getFieldErrors('nombres')
            Alumno.count() == 0
    }

    def 'crear alumno con nombre vacio'() {
        when:
        Alumno alumno = new Alumno(nombres: ''
            , apellidos: 'Perez'
            , numeroDocumento: '34114043'
            , fechaNacimiento: new Date())
            alumno.save()
        then:
            alumno.hasErrors()
            alumno.errors.getFieldErrors('nombres')
            Alumno.count() == 0
    }

    def 'crear alumno con nombre con menos de 3 caracteres'() {
        when:
        Alumno alumno = new Alumno(nombres: 'al'
            , apellidos: 'Perez'
            , numeroDocumento: '34114043'
            , fechaNacimiento: new Date())
            alumno.save()
        then:
            alumno.hasErrors()
            alumno.errors.getFieldErrors('nombres')
            Alumno.count() == 0
    }

    def 'crear alumno con nombre con mas de 60 caracteres'() {
        when:
        Alumno alumno = new Alumno(nombres: '0123456789012345678901234567890123456789012345678901234567891'
            , apellidos: 'Perez'
            , numeroDocumento: '34114043'
            , fechaNacimiento: new Date())
            alumno.save()
        then:
            alumno.hasErrors()
            alumno.errors.getFieldErrors('nombres')
            Alumno.count() == 0
    }

    def 'alumno se inscribe en una carrera'() {
        when:
            alumnoValido.save()
            alumnoValido.inscribirseEnCarrera(industrial)
        then:
            !alumnoValido.hasErrors()
            alumnoValido.carreras.size() == 1
            alumnoValido.carreras.first().codigo == industrial.codigo
    }

    def 'alumno se inscribe en dos carreras'() {
        when:
            alumnoValido.save()
            alumnoValido.inscribirseEnCarrera(industrial)
            alumnoValido.inscribirseEnCarrera(sistemas)
        then:
            !alumnoValido.hasErrors()
            alumnoValido.carreras.size() == 2
    }

    def 'alumno se inscribe en dos veces a la misma carrera'() {
        when:
            alumnoValido.save()
            alumnoValido.inscribirseEnCarrera(industrial)
            alumnoValido.inscribirseEnCarrera(industrial)
        then:
            alumnoValido.hasErrors()
            alumnoValido.errors.getFieldErrors('carreras')
            alumnoValido.carreras.size() == 1
    }

    def 'alumno se inscribe en una carrera nula'() {
        when:
            alumnoValido.save()
            alumnoValido.inscribirseEnCarrera(null)
        then:
            alumnoValido.hasErrors()
            alumnoValido.errors.getFieldErrors('carreras')
            alumnoValido.carreras == null
    }

    def 'alumno se desinscribe de una carrera'() {
        when:
            alumnoValido.save()
            
            alumnoValido.inscribirseEnCarrera(industrial)
            alumnoValido.desinscribirseDeCarrera(industrial)
        then:
            !alumnoValido.hasErrors()
            alumnoValido.carreras.size() == 0
    }

    def 'alumno se desinscribe de una carrera en la que no esta inscripto'() {
        when:
            alumnoValido.save()
            alumnoValido.desinscribirseDeCarrera(industrial)
        then:
            alumnoValido.hasErrors()
            alumnoValido.errors.getFieldErrors('carreras')
    }

    def 'alumno se desinscribe dos veces de una carrera'() {
        when:
            alumnoValido.save()
            alumnoValido.inscribirseEnCarrera(industrial)
            alumnoValido.desinscribirseDeCarrera(industrial)
            alumnoValido.desinscribirseDeCarrera(industrial)
        then:
            alumnoValido.hasErrors()
            alumnoValido.errors.getFieldErrors('carreras')
            alumnoValido.carreras.size() == 0
    }

    def 'alumno se desinscribe de una carrera nula'() {
        when:
            alumnoValido.save()
            alumnoValido.desinscribirseDeCarrera(null)
        then:
            alumnoValido.hasErrors()
            alumnoValido.errors.getFieldErrors('carreras')
            alumnoValido.carreras == null
    }

    def 'alumno se inscribe en dos carreras y se desinscribe de una'() {
        when:
            alumnoValido.save()
            alumnoValido.inscribirseEnCarrera(industrial)
            alumnoValido.inscribirseEnCarrera(sistemas)
            alumnoValido.desinscribirseDeCarrera(industrial)
        then:
            !alumnoValido.hasErrors()
            alumnoValido.carreras.size() == 1
            alumnoValido.carreras.first().codigo == sistemas.codigo
    }
}