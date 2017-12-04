package faculife

class Alumno {
    String nombres
    String apellidos
    int numeroDocumento
    Date fechaNacimiento
    String padron

    static hasMany = [cursos: Curso, grupoDeEstudios: GrupoDeEstudios, carreras: Carrera, notas: Nota]

    static constraints = {
        nombres required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        apellidos required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        numeroDocumento required: true
        fechaNacimiento required: true
        padron required: true, nullable: false, blank: false
    }

    def getMateriasAprobadas(){
        return notas.find { it.nota >= 4 }
    }
}
