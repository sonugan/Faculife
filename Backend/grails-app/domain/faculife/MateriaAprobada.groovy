package faculife

class MateriaAprobada {
    Alumno alumno
    Materia materia
    Cuatrimestre cuatrimestre
    float nota

    static constraints = {
        alumno nullable: false
        materia nullable: false
        cuatrimestre nullable: false
        nota min: 4, max: 10
    }
}
