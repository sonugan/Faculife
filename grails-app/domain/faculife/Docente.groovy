package faculife

class Docente {
    String nombres
    String apellidos
    int numeroDocumento
    Date fechaNacimiento

    //un alumno puede estar inscripto en varias facultades de diferente universidad
    //static hasMany = [identificaciones: Identificacion]

    static constraints = {
        nombres required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        apellidos required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        numeroDocumento required: true
        fechaNacimiento required: true
    }
}
