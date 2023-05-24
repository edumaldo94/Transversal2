/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author edu-1
 */
public class InscripcionData {

    private Connection con = null;
private Conexion conexion;

    public InscripcionData() {

        con = Conexion.getConexion();
    }
    
    
    
    public void guardarIncripcion(Inscripcion inscripcion) {
        try {
            String sql="INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES ( ?, ?, ?)";
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1,inscripcion.getNota());
            ps.setInt(2,inscripcion.getIdAlumno());
            ps.setInt(3, inscripcion.getIdMateria());
            
            if (ps.executeUpdate()>0) {
                 JOptionPane.showMessageDialog(null, "Alumno Inscripto con "
                        + "exito.");
            }
            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()) {
                inscripcion.setIdAlumno(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "ERROR al acceder a la "
                    + "tabla Inscripcion" + ex.getMessage());  }
        
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        List<Inscripcion> inscripciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM inscripcion";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {            
                Inscripcion ins = new Inscripcion();
                ins.setIdAlumno(rs.getInt("idAlumno"));
                ins.setIdInscripto(rs.getInt("idInscripto"));
                ins.setIdMateria(rs.getInt("idMateria"));
                ins.setNota(rs.getInt("nota"));
                inscripciones.add(ins);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
        return inscripciones;
    }
    
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id){
        List<Inscripcion> inscripciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM inscripcion "
                    + "WHERE idAlumno=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {            
                Inscripcion ins = new Inscripcion();
                ins.setIdAlumno(rs.getInt("idAlumno"));
                ins.setIdInscripto(rs.getInt("idInscripto"));
                ins.setIdMateria(rs.getInt("idMateria"));
                ins.setNota(rs.getInt("nota"));
                inscripciones.add(ins);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
        return inscripciones;
    }
    
    ////////////////////////////////////////
    public List<Materia> obtenerMateriasCursadas(int id){
        List<Materia> materias = new ArrayList<>();
        try {
            String sql="SELECT m.*\n" +
            "FROM materia AS m JOIN inscripcion AS i ON(m.idMateria=i.idMateria)\n" +
            "WHERE idAlumno=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
        return materias;
    }
    
    public List<Materia> obtenerMateriasNOCursadas(int id){
        List<Materia> materias = new ArrayList<>();
        try {
            String sql="SELECT *\n" +
                        "FROM materia\n" +
                        "WHERE idMateria not in (SELECT materia.idMateria\n" +
                        "			FROM materia join inscripcion on(materia.idMateria=inscripcion.idMateria)\n" +
                        "			WHERE idAlumno=?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
        return materias;
    }
    
    public void borrarInscripcionMateriaAlumno(int idA, int idM){
        try {
            String sql = "DELETE FROM inscripcion WHERE idAlumno=? && idMateria=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idA);
            ps.setInt(2, idM);
            int exito = ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "Inscripcion eliminada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar la inscripcion.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
        
    }
    
    public void actualizarNota(int idA, int idM, double not){
        try {
            String sql = "UPDATE inscripcion SET nota=? WHERE idAlumno=? && idMateria=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, not);
            ps.setInt(2, idA);
            ps.setInt(3, idM);
            int exito = ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "Nota cambiada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo cambiar la nota.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
    }
    
    public List<Alumno> obtenerAlumnosXMateria(int idM){
        List<Alumno> alumnos = new ArrayList<>();
        try {
            String sql="SELECT a.*\n" +
            "FROM alumno AS a JOIN inscripcion AS i ON(a.idAlumno=i.idAlumno)\n" +
            "WHERE idMateria=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Alumno alum = new Alumno();
                alum.setApellido(rs.getString("apellido"));
                alum.setDni(rs.getInt("dni"));
                alum.setNombre(rs.getString("nombre"));
                alum.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alum.setEstado(rs.getBoolean("estado"));
                alum.setIdAlumno(rs.getInt("idAlumno"));
                alumnos.add(alum);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
        return alumnos;
    }
}
