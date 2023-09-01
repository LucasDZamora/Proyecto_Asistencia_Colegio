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
  
  public Cursos(String nombre) {
    this.nombre = nombre;
    this.cantidadAlumnos = 0;
    alumnos = new HashMap<>();
  }
  
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public int getCantidadAlumnos() {
    return cantidadAlumnos;
  }
  public void setCantidadAlumnos(int cantidadAlumnos) {
    this.cantidadAlumnos = cantidadAlumnos;
  }

  public void agregarAlumno(Alumnos alumno){
    alumnos.put(alumno.getRut(), alumno);
  }

  public HashMap<String, Alumnos> getAlumnos() {
    return alumnos;
  }
  public void setAlumnos(HashMap<String, Alumnos> alumnos) {
    this.alumnos = alumnos;
  }
}