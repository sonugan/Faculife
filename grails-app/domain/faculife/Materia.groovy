package faculife

class Materia {
    String codigo
    String nombre

    //static belongsTo = [ departamento : Departamento ]

    Set cursos = []
    Set correlativas = []
    static hasMany = [cursos: Curso, correlativas: Materia]

    static constraints = {
        codigo unique: true, required: true, nullable: false, blank: false
        nombre required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        departamento required: true
    }
}
