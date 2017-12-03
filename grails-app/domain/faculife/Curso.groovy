package faculife

class Curso {
    String description
    static belongsTo = Alumno

    static hasMany = [alumnos: Alumno]

    static constraints = {
      description nullable: false, blank: false
    }
}
