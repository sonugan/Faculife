package faculife

class Curso {

    static belongsTo = [Cuatrimestre,Alumno]

    static hasMany = [alumnos: Alumno, docentes: Docente]

    static hasOne = [materia: Materia]

    static constraints = {
      materia unique: true
    }
}
