package faculife

class Nota {
    Materia materia
    static belongsTo = [Alumno]
    int nota

    static constraints = {
        nota required: true
    }
}
