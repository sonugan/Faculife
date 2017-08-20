package faculife

/*Modeliza la inscripcion una facultad*/
class Identificacion {
    String padron
    Facultad facultad
    Date fechaInscripcion

    static constraints = {
        padron required: true, nullable: false, blank: false //unico por cada facultad
        facultad required: true, nullable: false
        fechaInscripcion required: true
    }
}
