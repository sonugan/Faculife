package faculife

import grails.transaction.Transactional

@Transactional
class AlumnoService {

    def planificarCursada(Alumno alumno, Carrera carrera) {
        def materiasAprobadas = alumno.getMateriasAprobadas()
        def todasMateriasCarrera = carrera.getMaterias()
        if(materiasAprobadas && todasMateriasCarrera){
            def materiasRestantes = todasMateriasCarrera.where { !materiasAprobadas.find { it.codigo == codigo } }
        }
    }
}
