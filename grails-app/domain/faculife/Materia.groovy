package faculife

class Materia {
    String codigo
    String nombre

    //static belongsTo = [ departamento : Departamento ]

    Set cursos = []
    def correlativas = [:]

    static belongsTo = Carrera

    static hasMany = [cursos: Curso, carreras: Carrera]

    static constraints = {
        codigo unique: true, required: true, nullable: false, blank: false
        nombre required: true, nullable: false, blank: false, minSize: 3, maxSize: 60
        departamento required: true
    }

    def asignarCorrelativa(Materia unaMateria) {
        this.correlativas[unaMateria.codigo] = unaMateria.nombre
    }

    def getSizeCorrelativas() {
      return this.correlativas.size()
    }
}
