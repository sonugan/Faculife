package faculife

class Departamento {
    String codigo
    String nombre

    static hasMany = [materias: Materia]

    static constraints = {
        codigo required: true, nullable: false, blank: false
        nombre required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
    }
}
