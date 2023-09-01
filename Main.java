import java.io.*;
import java.util.*;

public class Main {

  private static ArrayList<Cursos> arrayCursos = new ArrayList<>();

  public static void agregarCurso(String nombre, int cantidad) throws IOException {
    Cursos cursoaux = new Cursos(nombre,cantidad);
    arrayCursos.add(cursoaux);
    return;
 }

  public static void eliminarCurso(String nombreCursoEliminar) throws IOException {
    
    for (int i = 0; i < arrayCursos.size(); i++) {
      Cursos cursoaux = arrayCursos.get(i);
      if (cursoaux.getNombre().equals(nombreCurso)) {
        arrayCursos.remove(i);
        System.out.println("Curso eliminado: " + nombreCurso);
        return;
      }else{
        System.out.println("No se encontró el curso: " + nombreCurso);
      }
    }
  }

  public static void agregarAlumnos(String nombreCurso ,String rut, String nombre, String apellido) throws IOException {

    for (Cursos cursoAux : arrayCursos) {
        if (cursoAux.getNombre().equals(nombreCurso)) {
            if (alumnos.containsKey(rut)) {
                System.out.println("El alumno ya existe.");
                return;
            }
            Alumnos nuevoAlumno = new Alumnos(rut, nombre, apellido);
            alumnos.put(rut, nuevoAlumno);
            curso.agregarAlumno(nuevoAlumno);

            System.out.println("Alumno agregado al curso: " + nombreCurso);
            return;
        }
    }

    System.out.println("No se encontró el curso: " + nombreCurso);
}

  
  
  public static void pasarAsistenciaEnUnCurso(ArrayList<Cursos> arrayCursos, HashMap<String, Alumnos> alumnos, BufferedReader lector) throws IOException {
    
    System.out.print("Ingrese el nombre del curso");
    String nombre = lector.readLine();
    for (int i = 0; i < arrayCursos.size(); i++) {
      Cursos cursoaux = arrayCursos.get(i);
      
      if (cursoaux.getNombre().equals(nombre)) {
        return;
      }else{
        System.out.println("No se encontró el curso: " + nombre);
      }        
    }
  }

  public static void mostrarTodosLosCursos(ArrayList<Cursos> arrayCursos) {
        for (Cursos curso : arrayCursos) {
            System.out.println("Curso: " + curso.getNombre());
            System.out.println("Cantidad de Alumnos: " + curso.getAlumnos().size());
        }
    }
  
  public static void inicializarDatos(ArrayList<Cursos> arrayCursos, HashMap<String, Alumnos> alumnos) {
    String[] nombresCursos = {"Primero medio A", "Primero medio B", "Segundo medio A", "Segundo medio B", "Tercero medio A"};

    for (String nombreCurso : nombresCursos) {
      Cursos curso = new Cursos(nombreCurso, 10); // Cada curso con 10 alumnos únicos
      
      for (int i = 1; i <= 5; i++) {
            String rut = "RUT" + (i + arrayCursos.size() * 5); // Genera RUTs únicos
            String nombreAlumno = "Alumno" + i;
            String apellidoAlumno = "Apellido" + i;

            Alumnos alumno = new Alumnos(rut, nombreAlumno, apellidoAlumno);
            curso.agregarAlumno(alumno);
            alumnos.put(rut, alumno);
        }

        arrayCursos.add(curso);
    }
}

    
  public static void mostrarAlumnosDeUnCurso(ArrayList<Cursos> arrayCursos, BufferedReader lector) throws IOException {
    System.out.print("Ingrese el nombre del curso del cual desea ver los alumnos: ");
    String nombreCurso = lector.readLine();

    for (Cursos curso : arrayCursos) {
        if (curso.getNombre().equals(nombreCurso)) {
            System.out.println("Alumnos en el curso " + nombreCurso + ":");
            for (Alumnos alumno : curso.getAlumnos().values()) {
                System.out.println("- Nombre: " + alumno.getNombre() + " Apellido: " + alumno.getApellido() + " Rut: "+ alumno.getRut());
            }
                return;
         }
    }

        System.out.println("No se encontró el curso: " + nombreCurso);
    }

  
  public static void main(String[] args) throws IOException {

    BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    ArrayList arrayCursos = new ArrayList();
    HashMap alumnos = new HashMap();
    inicializarDatos(arrayCursos, alumnos);
    
    
    while (true) {
      System.out.println("\nMenú:");
      System.out.println("1. Agregar curso");
      System.out.println("2. Eliminar curso");
      System.out.println("3. Agregar Alumnos");
      System.out.println("4. Pasar asistencia en un curso");
      System.out.println("5. Mostrar asistencia de un curso");
      System.out.println("6. Mostrar alumnos de un curso");
      System.out.println("7. Salir");
      System.out.print("Selecciona una opción: ");
      
      int opcion = Integer.parseInt(lector.readLine());
      switch (opcion) {
        case 1: 
            System.out.print("Ingrese el nombre del curso");
            String nombreCursoAgregar = lector.readLine();
            System.out.print("Ingrese la cantidad de alumnos que tiene la curso");
            int cantidadAlumnos = Integer.parseInt(lector.readLine());
            agregarCurso(nombreCursoAgregar, cantidadAlumnos);
            break;
        case 2:
            System.out.print("Ingrese el nombre del curso que quiere eliminar");
            String nombreCursoEliminar = lector.readLine();
            eliminarCurso(nombreCursoEliminar);
            break;
        case 3:
            System.out.print("Ingrese el nombre del curso donde quiere agregar al alumno: ");
            String nombreCurso = lector.readLine();
            System.out.print("Ingrese el rut del alumno: ");
            String rut = lector.readLine();
            System.out.print("Ingrese el rut del alumno: ");
            String nombreAgregar = lector.readLine();
            System.out.print("Ingrese el rut del alumno: ");
            String apellidoAgregar = lector.readLine();
            agregarAlumnos(nombreCurso, rut, nombreAgregar, apellidoAgregar);
            break;
        case 4:
            pasarAsistenciaEnUnCurso(arrayCursos,alumnos, lector);
            break;
        case 5:
            mostrarTodosLosCursos(arrayCursos);
            break;
        case 6:
            mostrarAlumnosDeUnCurso(arrayCursos, lector);
            break;
        case 7:
            System.exit(0);
        default:
            System.out.println("Opción no válida.");
            break;
      }
    }
  } // Fin método main
} // Fin clase