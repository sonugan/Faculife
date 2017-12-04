package faculife

class Horario {
    enum DiasSemana { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO }

    DiasSemana dia
    Date horarioDesde
    Date horarioHasta

    static constraints = {
        dia required: true
        horarioDesde required: true
        horarioHasta required: true
    }
}
