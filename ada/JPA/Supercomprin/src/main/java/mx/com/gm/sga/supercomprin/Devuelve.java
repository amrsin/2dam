package mx.com.gm.sga.supercomprin;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author singh
 */

@Entity
@Table(name = "Devuelve")
@NamedQueries({
    @NamedQuery(name = "Devuelve.findAll", query = "SELECT d FROM Devuelve d"),})

public class Devuelve {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_devuelve;
    @ManyToOne
    @JoinColumn(name = "DNI_cliente")
    private Cliente cliente;
    private int id_producto;
    private Date Fecha;
    private int Puntos;
    private double Importe;

    //Constructor por defecto
    public Devuelve() {
    }
    
    
    //Constructor con todos los datos menos id_compra para insert
    public Devuelve(Cliente cliente, int id_producto, Date Fecha, int Puntos, double Importe) {
        
        this.cliente = cliente;
        this.id_producto = id_producto;
        this.Fecha= Fecha;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
}