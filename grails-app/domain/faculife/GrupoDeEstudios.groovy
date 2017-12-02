package faculife

class GrupoDeEstudios {

    String nombre

    static belongsTo = Alumno

    static hasMany = [alumnos:Alumno]

    static constraints = {
    }
}
