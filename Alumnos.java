
import java.util.ArrayList;

public class Alumnos {
  
  private String nombre;
  private String apellido;
  private String rut;
  private ArrayList<Asistencia> asistencia;

    public Alumnos(String nombre, String apellido, String rut) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.rut = rut;
      this.asistencia = new ArrayList<>();
    }
    public Alumnos(String nombre, String apellido) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.rut = "";
      this.asistencia = new ArrayList<>();
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
    public ArrayList<Asistencia> getAsistencia() {
        return asistencia;
    }

    public void agregarAsistencia(Asistencia asistencia) {
        this.asistencia.add(asistencia);
    }
}

  