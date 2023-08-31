public class Alumnos {
  
  private String nombre;
  private String apellido;
  private String rut;
  private boolean asistencia;

  public Alumnos(String rut, String nombre, String apellido) {
    this.rut = rut;
    this.nombre = nombre;
    this.apellido = apellido;
    this.asistencia = false;
  }

  public boolean tieneAsistencia() {
    return asistencia;
  }
  public void marcarAsistencia() {
    asistencia = true;
  }
  
  public String getnombre() {
    return nombre;
  }
  
  public String getApellido() {
    return apellido;
  }
  
  public String getrut() {
    return rut;
  }
}