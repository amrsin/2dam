
package domain;

/**
 *
 * @author singh
 */
public class Producto {
    
    private int id_producto;
    private String Nombre;
    private double Precio;
    private int Puntos;

    public Producto() {
    }
    

    public Producto(String Nombre, double Precio, int Puntos) {
        
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Puntos = Puntos;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    @Override
    public String toString() {
        return "Id producto: " + id_producto + ", Nombre: " + Nombre + ", Precio: " + Precio + ", Puntos: " + Puntos;
    }
}