package faculife

class Alumno {
    String nombres
    String apellidos
    int numeroDocumento
    Date fechaNacimiento
    String padron
    Carrera carrera
    
    static hasMany = [cursos : Curso, materiasAprobadas: Materia]
    
    static constraints = {
        nombres required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        apellidos required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        numeroDocumento required: true
        fechaNacimiento required: true
        padron required: true, nullable: false, blank: false
        carrera required: false, nullable: true
    }

    def inscribirseEnCarrera(nuevaCarrera){
        if(!nuevaCarrera){
            errors.rejectValue("carrera", "La carrera a inscribirse no puede ser nula")
            return
        }
        if(carrera && carrera.codigo == nuevaCarrera.codigo){
            errors.rejectValue("carrera", "Solo puede inscribirse una vez a la carrera")
        }else{
            carrera = nuevaCarrera
        }
    }

    def desinscribirseDeCarrera(){
        if(!carrera){
            errors.rejectValue("carrera", "El alumno no se encuenntra inscripto en ninguna carrera")
        }else{
            carrera = null
        }
    }

    def inscribirseEnCurso(curso){
        if(curso){
            def yaEstoyInscripto = cursos.find { it.id == curso.id }
            if(yaEstoyInscripto){
                errors.rejectValue("cursos", "Solo puede inscribirse una vez a cada curso")
            }else {
                addToCursos(curso)
            }
        }else{
            errors.rejectValue("cursos", "El curso a inscribirse no puede ser nulo")
        }
    }

    def getCursosQueEstoyCursando(){
        return cursos
    }

    def aprobarMateria(materia){
        if(!materia){
            errors.rejectValue("materiasAprobadas", "No puede aprobar una materia nula")
        }else{
            def estoyInscripto = cursos.find { it.materia.id == materia.id }
            if(!estoyInscripto){
                errors.rejectValue("materiasAprobadas", "Debe inscribirse en una materia antes de aprobarla")
            }else{
                def yaAproboMateria = materiasAprobadas.find { it.id == materia.id }
                if(yaAproboMateria){
                    errors.rejectValue("materiasAprobadas", "No puede aprobar dos veces la misma materia")
                }else{
                    addToMateriasAprobadas(materia)
                }
            }
        }
    }
}