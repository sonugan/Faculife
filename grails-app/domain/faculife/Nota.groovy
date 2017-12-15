package faculife

class Nota {
    static belongsTo = [ Alumno]
    int nota

    static constraints = {
        nota required: true
    }
}
