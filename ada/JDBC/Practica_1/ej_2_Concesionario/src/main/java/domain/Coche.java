package domain;

/**
 *
 * @author singh
 */
public class Coche {
    
    //variables
    private String Matricula;
    private String Marca;
    private int Precio;
    private String DNI;

    //constructor por defecto 
    public Coche() {

        Matricula = "";
        Marca = "";
        Precio = 0;
        DNI = "";
    }

    //constructor con solo Matricula
    public Coche(String Matricula) {

        this.Matricula = Matricula;

    }
    
    //constructor con todos los datos
    public Coche(String Matricula, String Marca, int Precio, String DNI) {

        this.Matricula = Matricula;
        this.Marca = Marca;
        this.Precio = Precio;
        this.DNI = DNI;
    }
    
    //getters y setters
    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
    //metodo toString
    @Override
    public String toString() {
        return "Matricula: " + Matricula + ", Marca: " + Marca + ", Precio: " + Precio + ", DNI: " + DNI;
    }
}
