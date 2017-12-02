package faculife

class Calendario {

    static belongsTo = [curso: Curso]

    static hasMany = [eventos: Evento]

    static constraints = {
    }
}
