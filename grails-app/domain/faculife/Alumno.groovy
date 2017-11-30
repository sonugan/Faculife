package faculife

class Alumno {
    String nombres
    String apellidos
    int numeroDocumento
    Date fechaNacimiento
    String padron
    //Carrera carrera

    static belongsTo = GrupoDeEstudios

    static hasMany = [cursos: Curso]

    static constraints = {
        nombres required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        apellidos required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        numeroDocumento required: true
        fechaNacimiento required: true
        padron required: true, nullable: false, blank: false
    }

    def agregarMateria(Materia unaMateria) {
      materias.add(unaMateria)
    }

    def asignarCarrera(Carrera unaCarrera) {
      carrera.add(unaCarrera)
    }

    //static String getCarrera()
    //  return carrera.
}
