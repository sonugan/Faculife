package faculife

import grails.test.mixin.TestFor
import grails.test.hibernate.HibernateSpec

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(AlumnoService)
class AlumnoServiceSpec extends HibernateSpec {

    Carrera carrera
    Alumno alumno
    Materia analisis1
    Materia algoritmos1
    def setup() {
        analisis1 = new Materia(codigo: '7112', nombre: 'Analisis')
        analisis1.save()

        algoritmos1 = new Materia(codigo: '7115', nombre: 'Algoritmos')
        algoritmos1.save()


        Cuatrimestre cuatrimestre12017 = new Cuatrimestre(anio: 2017, numero: Cuatrimestre.Numero.PRIMERO)
        cuatrimestre12017.save()

        Curso analisis112017 = new Curso(cuatrimestre: cuatrimestre12017, materia: analisis1)
        analisis112017.save()

        Curso algoritmos112017 = new Curso(cuatrimestre: cuatrimestre12017, materia: algoritmos1)
        algoritmos112017.save()

        carrera = new Carrera(codigo: "9", nombre: "Sistemas")
        carrera.addToMaterias(analisis1)
        carrera.addToMaterias(algoritmos1)
        carrera.save()

        alumno = new Alumno(nombres: 'gaston'
            , apellidos: 'Perez'
            , numeroDocumento: '34114043'
            , fechaNacimiento: new Date())

        //alumno.aprobarMateria(algoritmos1, 5)
        Nota nota = new Nota(nota: 10)
        nota.save()
        Nota nota1 = new Nota(nota: 7)
        nota1.save()
        Nota nota2 = new Nota(nota: 7)
        nota2.save()
        Nota nota3 = new Nota(nota: 2)
        nota3.save()
        Nota nota4 = new Nota(nota: 2)
        nota4.save()

        alumno.addToNotas(nota)
        alumno.addToNotas(nota1)
        alumno.addToNotas(nota2)
        alumno.addToNotas(nota3)
        alumno.addToNotas(nota4)
        alumno.save()
    }

    def cleanup() {
    }

    void "prueba"() {
        when:
            //def coso = service.planificarCursada(alumno, carrera)
            def coso = service.getMateriasAprobadas(alumno)//alumno.getMateriasAprobadas()
        then:
            //alumno.notas.size() == 1
            coso.size() == 3
    }
}
