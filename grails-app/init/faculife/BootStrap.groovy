package faculife

class BootStrap {

    def init = { servletContext ->


      // PlanDeEstudios plan = new PlanDeEstudios(nombre: 'desconocido')
      // Carrera carrera = new Carrera(codigo: "2", nombre: "Industrial")

      // plan.carrera = carrera
      // plan.save(flush: true, failOnError: true)

      // Materia algebra2 = new Materia(codigo: "6108", nombre: "ALGEBRA II A")

      // carrera.addToMaterias(algebra2)

      // algebra2.save(flush: true, failOnError: true)

      // Docente prelat = new Docente(legajo: 1, nombres: "Prelat", apellidos: "Prelat", fechaNacimiento: new Date());
      // prelat.save(flush: true, failOnError: true)

      // Docente prelatJr = new Docente(legajo: 2, nombres: "prelatJr", apellidos: "Prelat", fechaNacimiento: new Date());
      // prelat.save(flush: true, failOnError: true)

      // Alumno gaston = new Alumno(nombres: "Gaston Nicolas", apellidos: "Perez", numeroDocumento: 1, fechaNacimiento: new Date(), padron: "123")
      // gaston.addToCarreras(carrera) // cargo al alumno a una carrera.
      // gaston.save(flush: true, failOnError: true)

      // Curso cursoPrelat = new Curso()

      // cursoPrelat.addToDocentes(prelat )
      // cursoPrelat.addToDocentes(prelatJr)
      // cursoPrelat.addToAlumnos(gaston)// cargo al alumno a un curso.

      // // falta pasarle un enum en vez de un entero en numero
      // Cuatrimestre cuatri = new Cuatrimestre(anio:2018, numero: Cuatrimestre.Numero.PRIMERO)
      // cuatri.addToCursos(cursoPrelat)
      // cuatri.save(flush: true, failOnError: true)


      // algebra2.addToCursos(cursoPrelat)
      // algebra2.save(flush: true, failOnError: true)

    }
    def destroy = {
    }
}
