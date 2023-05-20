/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package transversal2;

import persistencia.AlumnoData;
import conexion.Conexion;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistencia.InscripcionData;
import persistencia.MateriaData;

/**
 *
 * @author edu-1
 */
public class Transversal2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//     
   
InscripcionData t1=new InscripcionData();
Materia mat=new Materia();
        Inscripcion tt=new Inscripcion();
         try {
 
               Conexion.getConexion();
            Scanner leer = new Scanner(System.in).useDelimiter("\n");
            
            Alumno e1 = new Alumno();

            System.out.println("name");
            String name = leer.next();
            System.out.println("apellido");
            String appe = leer.next();
            System.out.println("dni");
            int dni = leer.nextInt();
            System.out.println("año de nacimiento");
            int anio = leer.nextInt();
            System.out.println("mes ");
            int mes = leer.nextInt();
            System.out.println("dia");
            int dia = leer.nextInt();
            System.out.println("estate");
            boolean sta = true;
            e1.setNombre(name);
            e1.setApellido(appe);
            e1.setDni(dni);
            e1.setFechaNacimiento(LocalDate.of(anio,mes,dia));
            e1.setEstado(sta);
          
            String sql = "INSERT INTO alumno( dni, apellido, nombre, fechaNacimiento, estado) VALUES ( ?, ?, ?, ?, ?)";
 
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, e1.getDni());
            ps.setString(2, e1.getApellido());
            ps.setString(3, e1.getNombre());
            ps.setDate(4, java.sql.Date.valueOf(e1.getFechaNacimiento()));
            ps.setBoolean(5, e1.isEstado());
            int agregarReg = ps.executeUpdate();
            String carte;
          
         
            if (agregarReg > 0) {
                carte = "El Registro fue Agregado";

         
            } else {
                carte = "No fue posible agregar";
            }
     

            JOptionPane.showMessageDialog(null, carte);
                   ResultSet es = ps.getGeneratedKeys();
            if (es.next()) {
                int clave = es.getInt(1);
                e1.setIdAlumno(clave);
            
                  
            }
             
      mat.setEstado(true);
      mat.setIdMateria(1);
      mat.setAnio(1);
      mat.setNombre("Matematica");
       tt.setIdAlumno(e1);
      tt.setNota(0);
      tt.setIdMateria(mat);
      tt.setIdInscripto(tt);
             System.out.println("hola");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());

        }
       
  
    }

}
