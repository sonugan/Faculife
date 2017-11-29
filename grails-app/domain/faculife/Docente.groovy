package faculife

class Docente {
    int legajo
    String nombres
    String apellidos
    Date fechaNacimiento
    static belongsTo = Curso
    static constraints = {
        legajo required: true, nullable: false, unique: true
        nombres required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        apellidos required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        fechaNacimiento required: true
    }
}
