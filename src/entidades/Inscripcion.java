/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author edu-1
 */
public class Inscripcion {
    
private Inscripcion idInscripto;
    private int nota;
    private  Alumno idAlumno;
    private Materia idMateria;

    public Inscripcion() {
    }

    public Inscripcion(Inscripcion idInscripto, int nota, Alumno idAlumno, Materia idMateria) {
        this.idInscripto = idInscripto;
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }
    
    public Inscripcion getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(Inscripcion idInscripto) {
        this.idInscripto = idInscripto;
    }

    
    
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    
}