package faculife

class Parcial {   
    static belongsTo=[materia:Materia]
    Date fecha
    static constraints = {
        fech required: true, nullable: false
    }
}
