package faculife

import grails.test.mixin.TestFor
import grails.test.hibernate.HibernateSpec

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Alumno)
class AlumnoSpec extends HibernateSpec {

    Alumno gaston
    Carrera sistemas
    // Carrera sistemas
    // Materia seminario1
    // Materia algoritmos1
    // Curso seminario12017
    // Curso algoritmos12017
    def setup() {
        sistemas = new Carrera(codigo: "9", nombre: "Sistemas")
        sistemas.save()

        gaston = new Alumno(
              padron: '123456'
            , nombres: 'Gaston'
            , apellidos: 'Perez'
            , numeroDocumento: '34114043'
            , fechaNacimiento: new Date())
        // alumnoValido.save()

        // sistemas = new Carrera(codigo: "9", nombre: "Sistemas")
        // sistemas.save()

        // Cuatrimestre primerCuatrimestre2017 = new Cuatrimestre(anio: 2017, numero: 1)
        // primerCuatrimestre2017.save()
        // seminario1 = new Materia(codigo: "7115", nombre: "Seminario 1")
        // seminario12017 = new Curso(cuatrimestre: primerCuatrimestre2017, materia: seminario1)
        // seminario12017.save()

        // algoritmos1 = new Materia(codigo: "7101", nombre: "Algoritmos 1")
        // algoritmos12017 = new Curso(cuatrimestre: primerCuatrimestre2017, materia: algoritmos1)
        // algoritmos12017.save()
    }

    def cleanup() {
    }

    def 'crear alumno valido'() {
        when:
            Alumno alumno = new Alumno(padron: '123456'
                , nombres: 'Gaston'
                , apellidos: 'Perez'
                , numeroDocumento: '34114043'
                , fechaNacimiento: new Date()
                , carrera: sistemas)
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
            gaston.save()
            gaston.inscribirseEnCarrera(sistemas)
        then:
            !gaston.hasErrors()
            gaston.carrera.codigo == sistemas.codigo
    }

    def 'alumno se inscribe en dos veces a la misma carrera'() {
        when:
            gaston.save()
            gaston.inscribirseEnCarrera(sistemas)
            gaston.inscribirseEnCarrera(sistemas)
        then:
            gaston.hasErrors()
            gaston.errors.getFieldErrors('carrera')
            gaston.carrera.codigo == sistemas.codigo
    }

    def 'alumno se inscribe en una carrera nula'() {
        when:
            gaston.save()
            gaston.inscribirseEnCarrera(null)
        then:
            gaston.hasErrors()
            gaston.errors.getFieldErrors('carrera')
            gaston.carrera == null
    }

    def 'alumno se desinscribe de una carrera'() {
        when:
            gaston.save()
            
            gaston.inscribirseEnCarrera(sistemas)
            gaston.desinscribirseDeCarrera()
        then:
            !gaston.hasErrors()
            gaston.carrera == null
    }

    def 'alumno se desinscribe de una carrera sin estar inscripto'() {
        when:
            gaston.save()
            gaston.desinscribirseDeCarrera()
        then:
            gaston.hasErrors()
            gaston.errors.getFieldErrors('carrera')
    }

    def 'alumno se desinscribe dos veces de una carrera'() {
        when:
            gaston.save()
            gaston.inscribirseEnCarrera(sistemas)
            gaston.desinscribirseDeCarrera()
            gaston.desinscribirseDeCarrera()
        then:
            gaston.hasErrors()
            gaston.errors.getFieldErrors('carrera')
            gaston.carrera == null
    }

    // def 'alumno se inscribe en un curso'() {
    //     when:
    //         alumnoValido.save()
    //         alumnoValido.inscribirseEnCurso(seminario12017)
    //     then:
    //         !alumnoValido.hasErrors()
    //         alumnoValido.getCursosQueEstoyCursando().size() == 1
    // }

    // def 'alumno se inscribe en dos cursos distintos'() {
    //     when:
    //         alumnoValido.save()
    //         alumnoValido.inscribirseEnCurso(seminario12017)
    //         alumnoValido.inscribirseEnCurso(algoritmos12017)
    //     then:
    //         !alumnoValido.hasErrors()
    //         alumnoValido.getCursosQueEstoyCursando().size() == 2
    // }

    // def 'alumno se inscribe en dos veces al mismo curso'() {
    //     when:
    //         alumnoValido.save()
    //         alumnoValido.inscribirseEnCurso(seminario12017)
    //         alumnoValido.inscribirseEnCurso(seminario12017)
    //     then:
    //         alumnoValido.hasErrors()
    //         alumnoValido.getCursosQueEstoyCursando().size() == 1
    //         alumnoValido.errors.getFieldErrors('cursos')
    // }

    // def 'alumno se inscribe en curso nulo'() {
    //     when:
    //         alumnoValido.save()
    //         alumnoValido.inscribirseEnCurso(null)
    //     then:
    //         alumnoValido.hasErrors()
    //         alumnoValido.errors.getFieldErrors('cursos')
    // }
}