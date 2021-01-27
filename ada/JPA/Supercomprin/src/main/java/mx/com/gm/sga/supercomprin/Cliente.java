
package mx.com.gm.sga.supercomprin;

import java.io.Serializable;
import java.sql.*;
import javax.persistence.*;
/**
 *
 * @author singh
 */
@Entity
@Table(name="Cliente")
@NamedQueries({
	@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c"),
	//@NamedQuery(name="Usuario.findByUserAndPwd", query="SELECT u FROM Usuario u where u.usuario=?1 and u.password=?2")
})

public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="DNI")
    private String DNI;
    @Column(name="Nombre")
    private String Nombre;
    @Column(name="Apellidos")
    private String Apellidos;
    @Column(name="Email")
    private String Email;
    @Column(name="Fecha_nacimiento")
    Date Fecha_nacimiento;
    @Column(name="Puntos")
    private int Puntos;
    @Column(name="Saldo")
    private double Saldo;

    //Constructor por defecto
    public Cliente() {
    }
    
    //Constructor para insert
    public Cliente(String DNI, String Nombre, String Apellidos, String Email, Date Fecha_nacimiento) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Fecha_nacimiento= Fecha_nacimiento;
        this.Puntos = 0;
        this.Saldo = 0;
    }
    
    //Constructor con todos 
    public Cliente(String DNI, String Nombre, String Apellidos, String Email, Date Fecha_nacimiento, int Puntos, double Saldo) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Fecha_nacimiento= Fecha_nacimiento;
        this.Puntos = Puntos;
        this.Saldo = Saldo;
    }
    
    //getters y setters
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public Date getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date Fecha_nacimineto) {
        this.Fecha_nacimiento = Fecha_nacimineto;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }   
}