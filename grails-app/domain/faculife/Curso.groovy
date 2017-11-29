package faculife

class Curso {
    static belongsTo = Alumno

    static hasMany = [alumnos: Alumno]

    static constraints = {
    }
}
