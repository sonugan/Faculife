package faculife

class Ejercicio {

    String nombre
    static belongsTo=[materia:Materia]
    String enunciado
    Date fechaInicio
    Date fechaVencimiento
    Date fechaFinalizacion

    static constraints = {
        nombre required: true, nullable: false, minSize: 3, maxSize: 100
        enunciado required: true, nullable: false, minSize: 3, maxSize: 100
        fechaInicio required: true, nullable: false
    }
}
