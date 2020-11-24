package domain;
import java.sql.Date;

/**
 *
 * @author singh
 */
public class Compra_puntos {
    
    private int id_compra;
    private String DNI_cliente;
    private int id_producto;
    private Date Fehca;
    private int Puntos;
    private double Importe;

    //Constructor por defecto
    public Compra_puntos() {
    }
    
    //Constructor con solo id_compra para delete
    public Compra_puntos(int id_compra) {
        
        this.id_compra = id_compra;   
    }
    //Constructor con todos los datos menos id_compra para insert
    public Compra_puntos(String DNI_cliente, int id_producto, Date Fehca, int Puntos, double Importe) {
        
        this.DNI_cliente = DNI_cliente;
        this.id_producto = id_producto;
        this.Fehca = Fehca;
        this.Puntos = Puntos;
        this.Importe = Importe;
    }
    //Constructor con todos los datos para update
    public Compra_puntos(int id_compra, String DNI_cliente, int id_producto, Date Fehca, int Puntos, double Importe) {
        
        this.id_compra = id_compra;
        this.DNI_cliente = DNI_cliente;
        this.id_producto = id_producto;
        this.Fehca = Fehca;
        this.Puntos = Puntos;
        this.Importe = Importe;
    }
    //getters and setters
    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
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

    @Override
    public String toString() {
        return "Compra_puntos{" + "id_compra=" + id_compra + ", DNI_cliente=" + DNI_cliente + ", id_producto=" + id_producto + ", Fehca=" + Fehca + ", Puntos=" + Puntos + ", Importe=" + Importe + '}';
    }
    
    
}