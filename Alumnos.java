public class Alumnos {
  
  private String nombre;
  private String apellido;
  private String rut;
  private boolean asistencia;

    public Alumnos(String nombre, String apellido, String rut) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.rut = rut;
      this.asistencia = false;
    }
    public Alumnos(String nombre, String apellido) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.rut = "";
      this.asistencia = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    public void setAsistencia(boolean asistencia) {
      this.asistencia = asistencia;
    }

    public void setAsistencia(String estado) {
      if (estado.equalsIgnoreCase("Presente")) {
        this.asistencia = true;
      } else if (estado.equalsIgnoreCase("Ausente")) {
          this.asistencia = false;
      } else {
        // hacer caso no valido.
      }
    }
  
   

}
  