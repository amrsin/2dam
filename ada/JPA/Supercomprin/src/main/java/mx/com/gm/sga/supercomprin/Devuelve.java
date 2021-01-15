package mx.com.gm.sga.supercomprin;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author singh
 */
public class Devuelve implements Serializable {
    
    private int id_devuelve;
    private String DNI_cliente;
    private int id_producto;
    private Date Fecha;
    private int Puntos;
    private double Importe;

    //Constructor por defecto
    public Devuelve() {
    }
    
    //getters and setters
    public int getId_devuelve() {
        return id_devuelve;
    }

    public void setId_devuelve(int id_devuelve) {
        this.id_devuelve = id_devuelve;
    }
    
    public String getDNI_cliente() {
        return DNI_cliente;
    }

    public void setDNI_cliente(String DNI_cliente) {
        this.DNI_cliente = DNI_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha= Fecha;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public double getImporte() {
        return Importe;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }

    @Override
    public String toString() {
        return "Id devuelve: " + id_devuelve + ", DNI cliente: " + DNI_cliente + ", Id producto: " + id_producto + ", Fecha: " + Fecha + ", Puntos: " + Puntos + ", Importe: " + Importe;
    }    
}