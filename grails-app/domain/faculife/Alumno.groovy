package faculife

class Alumno {
    String nombres
    String apellidos
    int numeroDocumento
    Date fechaNacimiento
    String padron

    static hasMany = [
        cursos: Curso, 
        grupoDeEstudios: GrupoDeEstudios, 
        carreras: Carrera,
        materiasAprobadas: Materia]

    static constraints = {
        nombres required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        apellidos required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        numeroDocumento required: true
        fechaNacimiento required: true
        padron required: true, nullable: false, blank: false
    }

    def inscribirseEnCarrera(carrera){
        if(carrera){
            def carreraYaInscripta = carreras.find { it.codigo == carrera.codigo }
            if(carreraYaInscripta){
                errors.rejectValue("carreras", "Solo puede inscribirse una vez a la carrera")
            }else{
                addToCarreras(carrera)   
            }
        }else{
            errors.rejectValue("carreras", "La carrera a inscribirse no puede ser nula")
        }
    }

    def desinscribirseDeCarrera(carrera){
        if(carrera){
            def carreraARemover = carreras.find { it.codigo == carrera.codigo }
            if(carreraARemover){
                removeFromCarreras(carreraARemover)
            }else{
                errors.rejectValue("carreras", "No se encuentra inscripto en la carrera")
            }
        }else{
            errors.rejectValue("carreras", "La carrera a desinscribirse no puede ser nula")
        }
    }

    def inscribirseEnCurso(curso){
        def yaEstoyInscripto = cursos.find { it.id == curso.id }
        if(yaEstoyInscripto){
            errors.rejectValue("cursos", "Solo puede inscribirse una vez a cada curso")
        }else {
            addToCursos(curso)
        }
    }

    def getCursosQueEstoyCursando(){
        return cursos
    }

    def aprobarMateria(materia){
        addToMateriasAprobadas(materia)
    }
}
