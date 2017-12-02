package faculife

class Cuatrimestre {
    //enum Numero {PRIMERO, SEGUNDO}

    int anio
    //Numero numero
    int numero

    static hasMany = [cursos: Curso]

    static constraints = {
        anio min: 1800
        numero nullable: false
    }

}
