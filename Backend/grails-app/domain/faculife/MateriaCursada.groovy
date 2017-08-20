package faculife

class MateriaCursada {
    Alumno alumno
    Materia materia
    Cuatrimestre cuatrimestre

    static constraints = {
        alumno nullable: false
        materia nullable: false
        cuatrimestre nullable: false
    }
}
