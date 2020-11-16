
package domain;

import java.sql.Date;

/**
 *
 * @author singh
 */
public class Compra {
    
    
    private String DNI_cliente;
    private int id_producto;
    private Date Fehca;
    private int Puntos;
    private double Importe;

    public Compra() {
    }

    public Compra (String DNI_cliente) {
        
        this.DNI_cliente = DNI_cliente;
    }
    public Compra(String DNI_cliente, int id_producto, Date Fehca, int Puntos, double Importe) {
        
        this.DNI_cliente = DNI_cliente;
        this.id_producto = id_producto;
        this.Fehca = Fehca;
        this.Puntos = Puntos;
        this.Importe = Importe;
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
