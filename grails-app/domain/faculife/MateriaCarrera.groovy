package faculife

class MateriaCarrera {

    static belongsTo=[materia: Materia]
    Set correlativas = []
    static hasMany = [correlativas: Materia]

    static constraints = {
    }
}
