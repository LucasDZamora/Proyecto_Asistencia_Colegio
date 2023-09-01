import java.util.HashMap;

public class Cursos {
  
  private String nombre;
  private int cantidadAlumnos;
  private HashMap<String, Alumnos> alumnos;
  
  public Cursos(String nombre, int cantidadAlumnos) {
    this.nombre = nombre;
    this.cantidadAlumnos = cantidadAlumnos;
    alumnos = new HashMap<>();
  }
  
  public String getNombre() {
    return nombre;
  }
  public int getCantidadAlumnos() {
    return cantidadAlumnos;
  }

  public void agregarAlumno(Alumnos alumno){
    alumnos.put(alumno.getRut(), alumno);
  }

  public HashMap<String, Alumnos> getAlumnos() {
    return alumnos;
  }
}