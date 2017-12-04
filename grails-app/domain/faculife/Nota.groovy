package faculife

class Nota {
    static belongsTo = [Materia, Alumno]
    int nota

    static constraints = {
        nota required: true
    }
}
