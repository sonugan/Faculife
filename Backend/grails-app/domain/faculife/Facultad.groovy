package faculife

class Facultad {
    String nombre
    String abreviatura

    static belongsTo = [universidad: Universidad]

    static constraints = {
        nombre required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        abreviatura required: true, nullable: false, blank: false, minSize: 3, maxSize: 10
        universidad required: true, nullable: false
    }
}
