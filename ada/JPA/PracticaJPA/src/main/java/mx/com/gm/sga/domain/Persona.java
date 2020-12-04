
package mx.com.gm.sga.domain;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author amrsin
 */
@Entity
public class Persona implements Serializable {
    
    private static final long SerialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="id_persona")
    private int idpersona;
    private String Nombre;
    private String Apellidos;
    private String Email;
    private int Edad;

    public Persona() {
    }

    public Persona(String Nombre, String Apellidos, String Email, int Edad) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Edad = Edad;
    }
    
    
    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    @Override
    public String toString() {
        return "Id persona: " + idpersona + ", Nombre: " + Nombre + ", Apellidos: " + Apellidos + ", Email: " + Email + ", Edad." + Edad + '}';
    }
    
    
    
    
    
}
