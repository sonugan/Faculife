package faculife

class Nota {
<<<<<<< HEAD
    static belongsTo = [ Alumno]
=======
    Materia materia
    static belongsTo = [Alumno]
>>>>>>> 97860390898b264deb7ffd89225d925f98220816
    int nota

    static constraints = {
        nota required: true
    }
}
