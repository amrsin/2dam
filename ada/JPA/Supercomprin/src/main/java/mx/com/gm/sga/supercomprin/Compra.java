/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.supercomprin;

import java.sql.Date;
import javax.persistence.*;

/**
 *
 * @author singh
 */

@Entity
@Table(name="Compra")
@NamedQueries({
	@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c"),
	//@NamedQuery(name="Usuario.findByUserAndPwd", query="SELECT u FROM Usuario u where u.usuario=?1 and u.password=?2")
})

public class Compra {
    
private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
        
    private int id_compra;
    @ManyToOne
    @JoinColumn(name ="DNI_cliente")
    private Cliente cliente;
    private int id_producto;
    private Date Fecha;
    private int Puntos;
    private double Importe;

    //Constructor por defecto
    public Compra() {
    }
    
   
    //Constructor con todos los datos
    public Compra(Cliente cliente, int id_producto, Date Fecha, int Puntos, double Importe) {
        
        this.cliente = cliente;
        this.id_producto = id_producto;
        this.Fecha = Fecha;
        this.Puntos = Puntos;
        this.Importe = Importe;
    }
    //Constructor con todos los datos para update
    public Compra(int id_compra, String DNI_cliente, int id_producto, Date Fecha, int Puntos, double Importe) {
        
        this.id_compra = id_compra;
        this.cliente = cliente;
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
} 