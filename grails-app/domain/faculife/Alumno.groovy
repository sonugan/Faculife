package faculife

class Alumno {
    String nombres
    String apellidos
    int numeroDocumento
    Date fechaNacimiento
    String padron
    Carrera carrera

    //puede pertenecer a varios grupos de estudio??
    static belongsTo = GrupoDeEstudios

    static hasMany = [cursos: Curso]

    static constraints = {
        nombres required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        apellidos required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        numeroDocumento required: true
        fechaNacimiento required: true
        padron required: true, nullable: false, blank: false
    }

    Alumno() {
      this.carrera = null
    }

    def asignarCarrera(Carrera unaCarrera) {
      this.carrera = unaCarrera
    }

    def getCarrera() {
      return this.carrera.name
    }
}
