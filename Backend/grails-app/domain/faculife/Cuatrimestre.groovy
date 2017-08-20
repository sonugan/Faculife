package faculife

class Cuatrimestre {
    enum Numero {PRIMERO, SEGUNDO}

    int anio
    Numero numero

    static constraints = {
        anio min: 1800
        numero nullable: false
    }
}
