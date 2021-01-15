
package mx.com.gm.sga;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author amrsin
 */
@Entity
@Table(name="contactos")
public class Contacto implements Serializable {
    
    private static final long SerialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private int idContacto;
    private String nombre;
    private String email;
    private String telefono;

    public Contacto() {
    }
    
    public Contacto(int idContacto) {
        
        this.idContacto = idContacto;
    }

    public Contacto(int idContacto, String nombre, String email, String telefono) {
        
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
    
    public Contacto(String nombre, String email, String telefono) {
        
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Id Contacto: " + idContacto + ", nombre: " + nombre + ", email: " + email + ", telefono: " + telefono;
    }
}
