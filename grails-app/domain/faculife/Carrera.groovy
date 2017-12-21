package faculife

class Carrera {

    String codigo
    String nombre

    // static belongsTo = [planDeEstudios: PlanDeEstudios]

    // static hasMany = [materias: Materia]

    static constraints = {
        codigo required: true, nullable: false, unique: true
        nombre required: true, nullable: false, unique: true
    }
}
