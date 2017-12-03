package faculife

class BootStrap {

    def init = { servletContext ->


      PlanDeEstudios plan = new PlanDeEstudios(nombre: 'desconocido')
      Carrera carrera = new Carrera(codigo: "2", nombre: "Industrial")

      plan.carrera = carrera
      plan.save(flush: true, failOnError: true)

      Materia algebra2 = new Materia(codigo: "6108", nombre: "ALGEBRA II A")

      carrera.addToMaterias(algebra2)

      algebra2.save(flush: true, failOnError: true)

      Docente prelat = new Docente(legajo: 1, nombres: "Prelat", apellidos: "Prelat", fechaNacimiento: new Date());
      prelat.save(flush: true, failOnError: true)
      
      Docente prelatJr = new Docente(legajo: 2, nombres: "prelatJr", apellidos: "Prelat", fechaNacimiento: new Date());
      prelat.save(flush: true, failOnError: true)
      
      Alumno gaston = new Alumno(nombres: "Gaston Nicolas", apellidos: "Perez", numeroDocumento: 1, fechaNacimiento: new Date(), padron: "123")
      gaston.save(flush: true, failOnError: true)
      
      Curso cursoPrelat = new Curso(materia: algebra2, docentes: [prelat, prelatJr], alumnos: [gaston])
      cursoPrelat.save(flush: true, failOnError: true)

      /*Curso cursoPrelat = new Curso()

      Docente docente = new Docente(legajo: 3, nombres: "Prelat",
                                    apellidos: "Prelat",
                                    fechaNacimiento: new Date(1980, 2, 3))
      cursoPrelat.addToDocentes(docente)

      algebra2.addToCursos(cursoPrelat)

      algebra2.save(flush: true, failOnError: true)

      algebra2.addToCursos(cursoPrelat)

      algebra2.save(flush: true, failOnError: true)

      // no se como pasar un enum. Lo harcodie a un entero
      Cuatrimestre cuatrimestre =  new Cuatrimestre(anio:2018,numero: 1)

      cuatrimestre.addToCursos(cursoPrelat)

      cuatrimestre.save(flush: true, failOnError: true)


      // Inscripcion de un alumno a una carrera.
      Alumno alumno = new Alumno(padron: '123456',
                          nombres: 'Gaston',
                          apellidos: 'Perez',
                          numeroDocumento: '34114043',
                          fechaNacimiento: new Date())

      alumno.addToCarreras(carrera)

      // Inscripcion de un alumno a un curso.
      alumno.addToCarreras(cursoPrelat)
      alumno.save(flush: true, failOnError: true)


      //*/

    }
    def destroy = {
    }
}
