package faculife

class Curso {

    static belongsTo = [Cuatrimestre,Alumno,Materia]

    static hasMany = [alumnos: Alumno, docentes: Docente]

    static constraints = {
      
    }
}
