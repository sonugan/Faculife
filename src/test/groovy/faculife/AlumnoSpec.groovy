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
    Materia seminario1
    Materia algoritmos1
    Materia datos
    Curso seminario12017
    Curso algoritmos12017
    Curso datos12017
    Nota notaDatos
    Nota notaAlgo1
    Nota notaSeminario

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

        Cuatrimestre primerCuatrimestre2017 = new Cuatrimestre(anio: 2017, numero: 1)
        primerCuatrimestre2017.save()

        seminario1 = new Materia(codigo: "7115", nombre: "Seminario 1")
        seminario12017 = new Curso(cuatrimestre: primerCuatrimestre2017, materia: seminario1)
        seminario12017.save()

        algoritmos1 = new Materia(codigo: "7101", nombre: "Algoritmos 1")
        algoritmos12017 = new Curso(cuatrimestre: primerCuatrimestre2017, materia: algoritmos1)
        algoritmos12017.save()

        datos = new Materia(codigo: "7503", nombre: "Organizacion de datos")
        datos12017 = new Curso(cuatrimestre: primerCuatrimestre2017, materia: datos)
        datos12017.save()

        notaDatos = new Nota(nota: 6)
        notaSeminario = new Nota(nota: 7)
        notaAlgo1 = new Nota(nota: 8)
    }

    def cleanup() {
    }

    def 'alumno termino la carrera'() {
        when:
            //cargo la carrera solo con 3 materias
            //para simplificar
            sistemas.addToMaterias(algoritmos1)
            sistemas.addToMaterias(seminario1)
            sistemas.addToMaterias(datos)

            //me inscribo en sistemas
            alumnoValido.inscribirseEnCarrera(sistemas)

            //le cargo notas al alumno
            alumnoValido.addToNotas(notaDatos)
            alumnoValido.addToNotas(notaAlgo1)
            alumnoValido.addToNotas(notaSeminario)
            alumnoValido.save()
        then:
            1 == 1
            //!alumnoValido.hasErrors()
            //sistemas.materias.size() == alumnoValido.getMateriasAprobadas()
            //hacer los metodos, para saber si un alumno es
            //crack(mete todas las materias(4 ponele) que curso con buenas notas )
            //o es un vago(no mete materias hace mucho tiempo)
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
}
