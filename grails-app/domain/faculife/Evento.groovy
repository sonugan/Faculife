package faculife

class Evento {

    Date fecha
    String nombre
    String descripcion

    static constraints = {
        fecha nullable:false, required: true
        nombre nullable: false, required: true, minSize: 3, maxSize: 100
        descripcion nullable: false, required: true, minSize: 3, maxSize: 500
    }
}
