package mx.com.gm.sga.supercomprin;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author singh
 */

@Entity
@Table(name = "compra_puntos")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUserAndPwd", query = "SELECT u FROM Usuario u where u.usuario=?1 and u.password=?2")
})

public class Compra_puntos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_compra;
    private String DNI_cliente;
    private int id_producto;
    private Date Fecha;
    private int Puntos;
    private double Importe;

    //Constructor por defecto
    public Compra_puntos() {
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