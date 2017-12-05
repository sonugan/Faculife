package faculife

class Curso {

    static belongsTo = [Cuatrimestre,Alumno,Materia]

    static hasMany = [alumnos: Alumno, docentes: Docente, horarios: Horario]

    static constraints = {

    }

    def estaHabilitado() {
      //hip: se toma como validos los datos que se guardaron
      return (alumno.size() && docentes.size() && horarios.size())
    }
}
