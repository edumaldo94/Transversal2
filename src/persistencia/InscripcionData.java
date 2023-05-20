/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import conexion.Conexion;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
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
    
    
    
    public  void Inscribir(Inscripcion inscripcion) {
        try {
            String sql="INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES ( ?, ?, ?)";
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,inscripcion.getNota());
            ps.setObject(2,inscripcion.getIdAlumno());
            ps.setObject(3, inscripcion.getIdMateria());
            
            if (ps.executeUpdate()>0) {
                 JOptionPane.showMessageDialog(null, "Alumno Inscripto con "
                        + "exito.");
            }
            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()) {
               ps.setObject(1, rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "ERROR al acceder a la "
                    + "tabla Inscripcion" + ex.getMessage());  }
        
    }
    ////////////////////////////////////////
    List<Inscripcion> obtenerMCursadas(){
        
        return null;
        
    }
    
    List<Inscripcion> obtenerMCursadasPorAlumno(int id){
        
        return null;
        
    }
    
    public Alumno buscarAlumno(int id) {
        
        return null;
        
    }
   
     public Materia buscarMateria(int id) {
        
        return null;
        
    }
        List<Materia> obtenerMateriasCursadasr(int id){
        
        return null;
        
    }
}
