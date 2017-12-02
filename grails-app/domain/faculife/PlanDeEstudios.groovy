package faculife

class PlanDeEstudios {
    String nombre

    static hasOne = [carrera: Carrera]
    static constraints = {
    }
}
