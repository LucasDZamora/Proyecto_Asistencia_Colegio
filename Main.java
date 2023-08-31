import java.io.*;
import java.util.*;

public class Main {

  public static void agregarCurso(ArrayList<Cursos> arrayCursos, BufferedReader lector) throws IOException {
    System.out.print("Ingrese el nombre del curso");
    String nombre = lector.readLine();
    System.out.print("Ingrese la cantidad de alumnos que tiene la curso");
    int cant = Integer.parseInt(lector.readLine());
    Cursos cursoaux = new Cursos(nombre,cant);
    arrayCursos.add(cursoaux);
 }

  public static void eliminarCurso(ArrayList<Cursos> arrayCursos, BufferedReader lector) throws IOException {
    
    System.out.print("Ingrese el nombre del curso");
    String nombreCurso = lector.readLine();
    
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

  public static void agregarAlumnos(ArrayList<Cursos> arrayCursos, HashMap<String, Alumnos> alumnos, BufferedReader lector) throws IOException {
    System.out.print("Ingrese el nombre del curso donde quiere agregar al alumno: ");
    String nombreCurso = lector.readLine();

    for (Cursos curso : arrayCursos) {
        if (curso.getNombre().equals(nombreCurso)) {
            System.out.println("Curso encontrado: " + nombreCurso);

            System.out.print("Ingrese el rut del alumno: ");
            String rut = lector.readLine();
            if (alumnos.containsKey(rut)) {
                System.out.println("El alumno ya existe.");
                return;
            }

            System.out.print("Ingrese el nombre del alumno: ");
            String nombre = lector.readLine();
            System.out.print("Ingrese el apellido del alumno: ");
            String apellido = lector.readLine();

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

  
  public static void main(String[] args) throws IOException {

    BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    ArrayList arrayCursos = new ArrayList();
    HashMap alumnos = new HashMap();
    
    while (true) {
      System.out.println("\nMenú:");
      System.out.println("1. Agregar curso");
      System.out.println("2. Eliminar curso");
      System.out.println("3. Agregar Alumnos");
      System.out.println("4. Pasar asistencia en un curso");
      System.out.println("5. Mostrar asistencia de un curso");
      System.out.println("6. Salir");
      System.out.print("Selecciona una opción: ");
      int opcion = Integer.parseInt(lector.readLine());
      switch (opcion) {
        case 1: 
            agregarCurso(arrayCursos, lector);
            break;
        case 2:
            eliminarCurso(arrayCursos, lector);
            break;
        case 3:
            agregarAlumnos(arrayCursos,alumnos, lector);
            break;
        case 4:
            pasarAsistenciaEnUnCurso(arrayCursos,alumnos, lector);
            break;
        case 5:
            mostrarTodosLosCursos(arrayCursos);
            break;
        case 6:
            System.exit(0);
        default:
            System.out.println("Opción no válida.");
            break;
      }
    }
  } // Fin método main
} // Fin clase