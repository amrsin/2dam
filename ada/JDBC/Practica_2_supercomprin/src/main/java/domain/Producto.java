package domain;
/**
 *
 * @author singh
 */
public class Producto {

    //var
    private int id_producto;
    private String Nombre;
    private double Precio;
    private int Puntos;

    //constructor por defecto
    public Producto() {

        id_producto = 0;
        Nombre = "";
        Precio = 0;
        Precio = 0;
    }

    //constuctor con solo id para eliminar 
    public Producto(int id_producto) {

        this.id_producto = id_producto;
    }

    //constuctor con valores necesarios para insertar
    public Producto(String Nombre, double Precio, int Puntos) {

        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Puntos = Puntos;
    }
    //constuctor con todos los valores para modificar

    public Producto(int id_producto, String Nombre, double Precio, int Puntos) {

        this.id_producto = id_producto;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Puntos = Puntos;
    }

    //getters y setters 
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

    //to string
    @Override
    public String toString() {
        return "Id producto: " + id_producto + ", Nombre: " + Nombre + ", Precio: " + Precio + ", Puntos: " + Puntos;
    }
}