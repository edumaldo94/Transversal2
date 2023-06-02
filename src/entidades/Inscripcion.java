package entidades;

public class Inscripcion {
    private int idInscripto;
    private double nota;
    private Alumno alumnoId;
    private Materia materiaId;

    public Inscripcion() {
    }

    public Inscripcion(double nota, Alumno idAlumno, Materia idMateria) {
        this.nota = nota;
        this.alumnoId = idAlumno;
        this.materiaId = idMateria;
    }
    
    public Inscripcion(int idInscripto, double nota, Alumno idAlumno, Materia idMateria) {
        this.idInscripto = idInscripto;
        this.nota = nota;
        this.alumnoId = idAlumno;
        this.materiaId = idMateria;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Alumno getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Alumno alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Materia getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Materia materiaId) {
        this.materiaId = materiaId;
    }

    

    @Override
    public String toString() {
        return "[ID Inscripto: " + idInscripto + " / Nota: " + nota + " / ID del Alumno: " + alumnoId.getIdAlumno() + " / ID de la Materia: " + materiaId.getIdMateria() + ']';
    }

    
}