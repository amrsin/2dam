
package domain;

import java.sql.Date;

/**
 *
 * @author singh
 */
public class Compra {
    
    private int id_compra;
    private String DNI_cliente;
    private int id_producto;
    private Date Fecha;
    private int Puntos;
    private double Importe;

    //Constructor por defecto
    public Compra() {
    }
    
    //Constructor con solo id_compra para delete
    public Compra (int id_compra) {
        
        this.id_compra = id_compra;   
    }
    //Constructor con DNI_cliente y id_producto
    public Compra (String DNI_cliente, int id_producto) {
        
        this.id_producto= id_producto;   
        this.DNI_cliente = DNI_cliente;
    }
    //Constructor con todos los datos menos id_compra para insert
    public Compra(String DNI_cliente, int id_producto, Date Fecha, int Puntos, double Importe) {
        
        this.DNI_cliente = DNI_cliente;
        this.id_producto = id_producto;
        this.Fecha = Fecha;
        this.Puntos = Puntos;
        this.Importe = Importe;
    }
    //Constructor con todos los datos para update
    public Compra(int id_compra, String DNI_cliente, int id_producto, Date Fecha, int Puntos, double Importe) {
        
        this.id_compra = id_compra;
        this.DNI_cliente = DNI_cliente;
        this.id_producto = id_producto;
        this.Fecha= Fecha;
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

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
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
        return "Id compra: " + id_compra + ", DNI cliente: " + DNI_cliente + ", Id producto: " + id_producto + ", Fecha: " + Fecha + ", Puntos: " + Puntos + ", Importe: " + Importe;
    }
}