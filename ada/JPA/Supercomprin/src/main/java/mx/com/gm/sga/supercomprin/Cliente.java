package mx.com.gm.sga.supercomprin;
import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author singh
 */
public class Cliente implements Serializable {
    
    private String DNI;
    private String Nombre;
    private String Apellidos;
    private String Email;
    private Date Fecha_nacimineto;
    private int Puntos;
    private double Saldos;

    //Constructor por defecto
    public Cliente() {
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

    public Date getFecha_nacimineto() {
        return Fecha_nacimineto;
    }

    public void setFecha_nacimineto(Date Fecha_nacimineto) {
        this.Fecha_nacimineto = Fecha_nacimineto;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public double getSaldos() {
        return Saldos;
    }

    public void setSaldos(double Saldos) {
        this.Saldos = Saldos;
    }
    //toString
    @Override
    public String toString() {
        return "DNI: " + DNI + ", Nombre: " + Nombre + ", Apellidos: " + Apellidos + ", Email: " + Email + ", Fecha_nacimineto: " + Fecha_nacimineto + ", Puntos: " + Puntos + ", Saldo: " + Saldos;
    }
}