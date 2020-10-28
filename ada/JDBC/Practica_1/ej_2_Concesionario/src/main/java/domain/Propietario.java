package domain;

/**
 *
 * @author singh
 */
public class Propietario {
    
    //variables
    private String DNI;
    private String Nombre;
    private int Edad;
    
    //constructor por defecto 
    public Propietario() {

        DNI = "";
        Nombre = "";
        Edad = 0;

    }
    
    //constructor con solo DNI
    public Propietario(String DNI) {

        this.DNI = DNI;

    }

    //constructor con todas los datos
    public Propietario(String DNI, String Nombre, int Edad) {

        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Edad = Edad;
    }

    //getters y setters
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    //metodo toString
    @Override
    public String toString() {
        return "DNI; " + DNI + ", Nombre: " + Nombre + ", Edad: " + Edad;
    }
}
