package faculife

import grails.transaction.Transactional

@Transactional
class AlumnoService {

    def planificarCursada(Alumno alumno, Carrera carrera) {
        def materiasAprobadas = getMateriasAprobadas(alumno)
        // def todasMateriasCarrera = carrera.getMaterias()
        // if(materiasAprobadas && todasMateriasCarrera){
        //     def materiasRestantes = todasMateriasCarrera.where { !materiasAprobadas.find { it.codigo == codigo } }
        // }
        return materiasAprobadas
    }

    def getMateriasAprobadas(Alumno alumno){
      /*def query = alumno.where {
          notas { nota > 4}
      }*/

      return alumno.notas.findAll{(it.nota >= 4)}
      //return query.list()
    }
}
