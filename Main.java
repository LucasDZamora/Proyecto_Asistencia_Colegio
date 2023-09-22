import java.io.*;
import java.util.*;

public class Main{

  private static ArrayList<Cursos> arrayCursos = new ArrayList<>();

  
  public static void agregarCurso(String nombre, int cantidad) throws IOException {
    Cursos cursoaux = new Cursos(nombre,cantidad);
    arrayCursos.add(cursoaux);
  }

  public static void inicializarDatos() {
    String[] nombresCursos = {"Primero medio A", "Primero medio B", "Segundo medio A", "Segundo medio B", "Tercero medio A"};

    for (String nombreCurso : nombresCursos) {
      Cursos curso = new Cursos(nombreCurso, 5); // Cada curso con 5 alumnos únicos
      
      for (int i = 1; i <= 5; i++) {
            String rut = "RUT" + (i + arrayCursos.size() * 5); // Genera RUTs únicos
            String nombreAlumno = "Alumno" + i;
            String apellidoAlumno = "Apellido" + i;

            Alumnos alumno = new Alumnos(nombreAlumno, apellidoAlumno, rut);
            curso.agregarAlumno(alumno);
        }

        arrayCursos.add(curso);
    }
}


  public static void eliminarCurso(String nombreCursoEliminar) throws IOException {
    for (int i = 0; i < arrayCursos.size(); i++) {
      Cursos cursoaux = arrayCursos.get(i);
      if (cursoaux.getNombre().equals(nombreCursoEliminar)) {
        arrayCursos.remove(i);
        System.out.println("Curso eliminado: " + nombreCursoEliminar);
        return;
      } else {
        System.out.println("No se encontró el curso: " + nombreCursoEliminar);
      }
    }
  }

  public static void agregarAlumnos(String nombreCurso, String rut, String nombre, String apellido) throws IOException {
    for (Cursos cursoAux : arrayCursos) {
      
      if (cursoAux.getNombre().equals(nombreCurso)) {
        cursoAux.agregarAlumno(rut, nombre, apellido);
      }
    }
    System.out.println("No se encontró el curso: " + nombreCurso);
  }
  //Sin completar
  public static void pasarAsistenciaEnUnCurso(String nombreCurso, BufferedReader lector) throws IOException {
    for (int i = 0; i < arrayCursos.size(); i++) {
        Cursos cursoAux = arrayCursos.get(i);
        if (cursoAux.getNombre().equals(nombreCurso)) {
          cursoAux.pasarAsistenciaEnUnCurso(lector);
        }
    }
    System.out.println("No se encontró el curso: " + nombreCurso);
  }



  public static void mostrarTodosLosCursos() {
    for (Cursos curso : arrayCursos) {
      curso.mostrarInfoCurso();
    }
  }

  public static void mostrarAlumnosDeUnCurso(String nombreCursoVer) {
    for (Cursos curso : arrayCursos) {
      if (curso.getNombre().equals(nombreCursoVer)) {
        curso.mostrarAlumnos();
      }
    }
    System.out.println("No se encontró el curso: " + nombreCursoVer);
  }

  
  public static void main(String[] args) throws IOException {
    BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    inicializarDatos();
    while (true) {
      System.out.println("\nMenú:");
      System.out.println("1. Agregar curso");
      System.out.println("2. Eliminar curso");
      System.out.println("3. Agregar Alumnos");
      System.out.println("4. Pasar asistencia en un curso");
      System.out.println("5. Mostrar todos los cursos");
      System.out.println("6. Mostrar alumnos de un curso");
      System.out.println("7. Salir");
      System.out.print("Selecciona una opción: ");

      int opcion = Integer.parseInt(lector.readLine());
      switch (opcion) {
        case 1:
          System.out.print("Ingrese el nombre del curso: ");
          String nombreCursoAgregar = lector.readLine();
          System.out.print("Ingrese la cantidad de alumnos que tiene el curso: ");
          int cantidadAlumnos = Integer.parseInt(lector.readLine());
          agregarCurso(nombreCursoAgregar, cantidadAlumnos);
          break;
        case 2:
          System.out.print("Ingrese el nombre del curso que quiere eliminar: ");
          String nombreCursoEliminar = lector.readLine();
          eliminarCurso(nombreCursoEliminar);
          break;
        case 3:
          System.out.print("Ingrese el nombre del curso donde quiere agregar al alumno: ");
          String nombreCurso = lector.readLine();
          System.out.print("Ingrese el rut del alumno: ");
          String rut = lector.readLine();
          System.out.print("Ingrese el nombre del alumno: ");
          String nombreAgregar = lector.readLine();
          System.out.print("Ingrese el apellido del alumno: ");
          String apellidoAgregar = lector.readLine();
          agregarAlumnos(nombreCurso, rut, nombreAgregar, apellidoAgregar);
          break;
        case 4:
          System.out.print("Ingrese el nombre del curso: ");
          String nombreAsistencia = lector.readLine();
          pasarAsistenciaEnUnCurso(nombreAsistencia,lector);
          break;
        case 5:
          mostrarTodosLosCursos();
          break;
        case 6:
          System.out.print("Ingrese el nombre del curso del cual desea ver los alumnos: ");
          String nombreCursoVer = lector.readLine();
          mostrarAlumnosDeUnCurso(nombreCursoVer);
          break;
        case 7:
          System.exit(0);
        default:
          System.out.println("Opción no válida.");
          break;
      }
    }
  } 
}