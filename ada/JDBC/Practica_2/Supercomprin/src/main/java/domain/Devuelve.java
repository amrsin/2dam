package domain;
import java.sql.Date;

/**
 *
 * @author singh
 */
public class Devuelve {
    
    private int id_devuelve;
    private String DNI_cliente;
    private int id_producto;
    private Date Fehca;
    private int Puntos;
    private double Importe;

    //Constructor por defecto
    public Devuelve() {
    }
    
    //Constructor con solo id_compra para delete
    public Devuelve(int id_devuelve) {
        
        this.id_devuelve = id_devuelve;   
    }
    //Constructor con todos los datos menos id_compra para insert
    public Devuelve(String DNI_cliente, int id_producto, Date Fehca, int Puntos, double Importe) {
        
        this.DNI_cliente = DNI_cliente;
        this.id_producto = id_producto;
        this.Fehca = Fehca;
        this.Puntos = Puntos;
        this.Importe = Importe;
    }
    //Constructor con todos los datos para update
    public Devuelve(int id_devuelve, String DNI_cliente, int id_producto, Date Fehca, int Puntos, double Importe) {
        
        this.id_devuelve = id_devuelve;
        this.DNI_cliente = DNI_cliente;
        this.id_producto = id_producto;
        this.Fehca = Fehca;
        this.Puntos = Puntos;
        this.Importe = Importe;
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

    public Date getFehca() {
        return Fehca;
    }

    public void setFehca(Date Fehca) {
        this.Fehca = Fehca;
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
}