package transversal2;

import persistencia.AlumnoData;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import persistencia.InscripcionData;
import persistencia.MateriaData;

public class Transversal2 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean salir = true;
        int op = 0;
        InscripcionData insData = new InscripcionData();
        AlumnoData alumData = new AlumnoData();
        MateriaData matData = new MateriaData();
        String fechaDefault = "1900-01-01";
        LocalDate fecha = LocalDate.parse(fechaDefault);
        LocalDate fechaMod = LocalDate.parse(fechaDefault);
        do {
            System.out.println("UNIVERSIDAD ULP - ADMINISTRACION");
            System.out.println("------------ALUMNOS------------");
            System.out.println("1- Cargar un nuevo Alumno");
            System.out.println("2- Buscar Alumno por ID");
            System.out.println("3- Buscar Alumno por DNI");
            System.out.println("4- Listar Alumnos");
            System.out.println("5- Modificar un Alumno por su ID");
            System.out.println("6- Dar de baja un Alumno por su ID");
            System.out.println("7- Dar de alta un Alumno por su ID");
            System.out.println("-----------MATERIAS-----------");
            System.out.println("8- Cargar una nueva Materia");
            System.out.println("9- Buscar Materia por ID");
            System.out.println("10- Modificar una Materia por su ID");
            System.out.println("11- Listar las Materias activas");
            System.out.println("12- Dar de baja a una Materia por su ID");
            System.out.println("13- Dar de alta a una Materia por su ID");
            System.out.println("---------INSCRIPCIONES---------");
            System.out.println("14- Cargar una inscripcion");
            System.out.println("15- Obtener Inscripciones");
            System.out.println("16- Obtener Inscripciones de un Alumno por su ID");
            System.out.println("17- Obtener Materias Cursadas de un Alumno");
            System.out.println("18- Obtener Materias NO Cursadas de un Alumno");
            System.out.println("19- Borrar Inscripcion Materia-Alumno");
            System.out.println("20- Actualizar Nota");
            System.out.println("21- Obtener Alumnos por Materia");
            System.out.println("0- Salir.");
            op = leer.nextInt();
            switch (op) {
                //Alumnos
                case 1:
                    System.out.println("");
                    System.out.println("Ingrese el apellido: ");
                    String apellido = leer.next();
                    System.out.println("Ingrese el nombre: ");
                    String nombre = leer.next();
                    System.out.println("Ingrese el DNI: ");
                    int dni = leer.nextInt();
                    System.out.println("Ingrese la fecha de nacimiento");
                    System.out.println("Anio: ");
                    int anio = leer.nextInt();
                    System.out.println("Mes: ");
                    int mes = leer.nextInt();
                    System.out.println("Dia: ");
                    int dia = leer.nextInt();
                    fecha = LocalDate.of(anio, mes, dia);
                    Alumno alum = new Alumno(dni, apellido, nombre, fecha, true);
                    alumData.guardarAlumno(alum);
                    break;
                case 2:
                    System.out.println("Ingrese una ID para buscar ese alumno");
                    int id = leer.nextInt();
                    Alumno alumBuscarID = new Alumno();
                    alumBuscarID = alumData.buscarAlumno(id);
                    System.out.println("Nombre: " + alumBuscarID.getNombre());
                    System.out.println("Apellido: " + alumBuscarID.getApellido());
                    System.out.println("DNI: " + alumBuscarID.getDni());
                    System.out.println("Fecha de Nacimiento: " + alumBuscarID.getFechaNacimiento());
                    System.out.println("Estado activo: " + alumBuscarID.isEstado());
                    break;
                case 3:
                    System.out.println("Ingrese el DNI a buscar");
                    int dniBuscar = leer.nextInt();
                    Alumno alumBuscarDNI = new Alumno();
                    alumBuscarDNI = alumData.buscarAlumnoPorDni(dniBuscar);
                    System.out.println("Nombre: " + alumBuscarDNI.getNombre());
                    System.out.println("Apellido: " + alumBuscarDNI.getApellido());
                    System.out.println("DNI: " + alumBuscarDNI.getDni());
                    System.out.println("Fecha de Nacimiento: " + alumBuscarDNI.getFechaNacimiento());
                    System.out.println("Estado activo: " + alumBuscarDNI.isEstado());
                    break;
                case 4:
                    List<Alumno> alumnos = new ArrayList<>();
                    alumnos = alumData.listarAlumnos();
                    for (int i = 0; i < alumnos.size(); i++) {
                        System.out.println("");
                        System.out.println("ID del Alumno: " + alumnos.get(i).getIdAlumno());
                        System.out.println("Nombre: " + alumnos.get(i).getNombre());
                        System.out.println("Apellido: " + alumnos.get(i).getApellido());
                        System.out.println("DNI: " + alumnos.get(i).getDni());
                        System.out.println("Fecha de Nacimiento: " + alumnos.get(i).getFechaNacimiento());
                        System.out.println("Estado activo: " + alumnos.get(i).isEstado());
                    }
                    break;
                case 5:
                    System.out.println("Ingrese la ID del Alumno que sera modificado");
                    int idMod = leer.nextInt();
                    System.out.println("Ingrese los nuevos datos");
                    System.out.println("Nombre: ");
                    String nombreMod = leer.next();
                    System.out.println("Apellido: ");
                    String apellidoMod = leer.next();
                    System.out.println("DNI: ");
                    int dniMod = leer.nextInt();
                    System.out.println("Ingrese la fecha de nacimiento");
                    System.out.println("Anio: ");
                    int anioMod = leer.nextInt();
                    System.out.println("Mes: ");
                    int mesMod = leer.nextInt();
                    System.out.println("Dia: ");
                    int diaMod = leer.nextInt();
                    fechaMod = LocalDate.of(anioMod, mesMod, diaMod);
                    alumData.modificarAlumno(new Alumno(idMod, dniMod, apellidoMod, nombreMod, fechaMod, true));
                    break;
                case 6:
                    System.out.println("Ingrese la ID del Alumno a dar de baja");
                    int idBaja = leer.nextInt();
                    alumData.eliminarAlumno(idBaja);
                    break;
                case 7:
                    System.out.println("Ingrese la ID del Alumno a dar de alta");
                    int idAlta = leer.nextInt();
                    alumData.activarAlumno(idAlta);
                    break;
                //Materias
                case 8:
                    System.out.println("Ingrese la nueva Materia");
                    System.out.println("Nombre: ");
                    String nombreMateria = leer.next();
                    System.out.println("Anio: ");
                    int anioMateria = leer.nextInt();
                    matData.guardarMateria(new Materia(nombreMateria, anioMateria, true));
                    break;
                case 9:
                    System.out.println("Ingrese el ID de la Materia a buscar");
                    int idBuscarMat = leer.nextInt();
                    Materia matBuscada = matData.buscarMateria(idBuscarMat);
                    System.out.println("Datos de la Materia");
                    System.out.println("Nombre: " + matBuscada.getNombre());
                    System.out.println("Anio: " + matBuscada.getAnio());
                    System.out.println("Estado activo: " + matBuscada.isEstado());
                    System.out.println("ID: " + matBuscada.getIdMateria());
                case 10:
                    System.out.println("Ingrese la ID de la Materia que sera modificada");
                    int idModMat = leer.nextInt();
                    System.out.println("Ingrese los nuevos datos para la Materia");
                    System.out.println("Nombre: ");
                    String nombreModMat = leer.next();
                    System.out.println("Anio: ");
                    int anioModMat = leer.nextInt();
                    matData.modificarMateria(new Materia(idModMat, nombreModMat, anioModMat, true));
                    break;
                case 11:
                    List<Materia> materias = new ArrayList<>();
                    materias = matData.listarMaterias();
                    for (int i = 0; i < materias.size(); i++) {
                        System.out.println("");
                        System.out.println("ID de la Materia: " + materias.get(i).getIdMateria());
                        System.out.println("Nombre: " + materias.get(i).getNombre());
                        System.out.println("Anio: " + materias.get(i).getAnio());
                        System.out.println("Estado activo: " + materias.get(i).isEstado());
                    }
                    break;
                case 12:
                    System.out.println("Ingrese el ID de la Materia que sera dada de baja");
                    int idBajaMat = leer.nextInt();
                    matData.eliminarMateria(idBajaMat);
                    break;
                case 13:
                    System.out.println("Ingrese el ID de la Materia que sera dada de alta");
                    int idAltaMat = leer.nextInt();
                    matData.activarMateria(idAltaMat);
                    break;
                //Inscripciones
                case 14:
                    System.out.println("Ingrese el ID del Alumno");
                    int idA = leer.nextInt();
                    System.out.println("Ingrese el ID de la Materia");
                    int idM = leer.nextInt();
                    System.out.println("Ingrese la Nota");
                    double notaA = leer.nextDouble();
                    insData.guardarIncripcion(new Inscripcion(notaA, idA, idM));
                    break;
                case 15:
                    List<Inscripcion> inscripciones = new ArrayList<>();
                    inscripciones = insData.obtenerInscripciones();
                    for (Inscripcion aux : inscripciones) {
                        System.out.println(aux);
                    }
                    break;
                case 16:
                    System.out.println("Ingrese la ID del Alumno para mostrar sus Inscripciones");
                    int idIns = leer.nextInt();
                    List<Inscripcion> inscripcionesXAlumno = new ArrayList<>();
                    inscripcionesXAlumno = insData.obtenerInscripcionesPorAlumno(idIns);
                    for (Inscripcion auxIns : inscripcionesXAlumno) {
                        System.out.println(auxIns);
                    }
                    break;
                case 17:
                    System.out.println("Ingrese la ID del Alumno para mostrar en que Materias esta inscripto");
                    int idAlumIns = leer.nextInt();
                    List<Materia> alumInscripciones = new ArrayList<>();
                    alumInscripciones = insData.obtenerMateriasCursadas(idAlumIns);
                    for (Materia alumInsAux : alumInscripciones) {
                        System.out.println(alumInsAux);
                    }
                    break;
                case 18:
                    System.out.println("Ingrese la ID del Alumno para mostrar en que Materias NO esta inscripto");
                    int idAlumNOIns = leer.nextInt();
                    List<Materia> alumNOInscripciones = new ArrayList<>();
                    alumNOInscripciones = insData.obtenerMateriasNOCursadas(idAlumNOIns);
                    for (Materia alumNOInsAux : alumNOInscripciones) {
                        System.out.println(alumNOInsAux);
                    }
                    break;
                case 19:
                    System.out.println("Ingrese la ID del Alumno");
                    int idAlumDel = leer.nextInt();
                    System.out.println("Ingrese la ID de la Materia");
                    int idMatDel = leer.nextInt();
                    insData.borrarInscripcionMateriaAlumno(idAlumDel, idMatDel);
                    break;
                case 20:
                    System.out.println("Ingrese la ID del Alumno");
                    int idAlumNot = leer.nextInt();
                    System.out.println("Ingrese la ID de la Materia");
                    int idMatNot = leer.nextInt();
                    System.out.println("Ingrese la nueva Nota");
                    double notNueva = leer.nextDouble();
                    insData.actualizarNota(idAlumNot, idMatNot, notNueva);
                    break;
                case 21:
                    System.out.println("Ingrese el ID de la Materias");
                    int idMatLisAlum = leer.nextInt();
                    List<Alumno> alumnosXMat = new ArrayList<>();
                    alumnosXMat = insData.obtenerAlumnosXMateria(idMatLisAlum);
                    for (Alumno alumnosXMatAux : alumnosXMat) {
                        System.out.println(alumnosXMatAux);
                    }
                    break;
                case 0:
                    salir = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (salir);
    }
}
