package faculife

class Sede {
    String nombre
    static hasMany = [facultades: Facultad]

    static constraints = {
        nombre required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
    }
}
