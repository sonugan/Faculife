package faculife

class Alumno {
    String nombres
    String apellidos
    int numeroDocumento
    Date fechaNacimiento
    String padron
    Carrera carrera

    static belongsTo = GrupoDeEstudios

    static hasMany = [cursos: Curso]

    //quiero tener una carrera como atributo,
    //pero no se como modelarlo, con un hasOne o
    //con un atributo en si
    //static hasOne = [carrera: Carrera]

    static constraints = {
        nombres required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        apellidos required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        numeroDocumento required: true
        fechaNacimiento required: true
        padron required: true, nullable: false, blank: false
        carrera required: false, nullable: true //esta bien?
    }

    //constructor
    Alumno() {
      this.carrera = null
    }

    //def agregarMateria(Materia unaMateria) {
    //  materias.add(unaMateria)
    //}

    def asignarCarrera(Carrera unaCarrera) {
      //carrera.add(unaCarrera)
      this.carrera = unaCarrera
    }

    def String getCarrera() {
      return this.carrera.nombre
    }
}
