package faculife

class Universidad {
    String nombre
    String abreviatura

    static hasMany = [facultades: Facultad]

    static constraints = {
        nombre required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        abreviatura required: true, nullable: false, blank: false, minSize: 3, maxSize: 10
    }
}
