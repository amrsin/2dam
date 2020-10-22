package mas_ej_OO.ej_1;

/**
 *
 * @author singh
 */
public class Cuenta {

    private String titular;
    private double cantidad;

    public Cuenta(String titular) {
        this.titular = titular;

        if (cantidad < 0) {
            this.cantidad = 0;
        } else {
            this.cantidad = 0;
        }
    }

    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Titular: " + titular + ", Cantidad: " + cantidad;
    }

    public void ingresar(double cantidad) {

        if (cantidad >= 0) {

            this.cantidad = this.cantidad + cantidad;

        }
    }

    public void retirar(double cantidad) {

        Double resta;

        resta = this.cantidad - cantidad;

        if (resta < 0) {

            this.cantidad = 0;

        } else {

            this.cantidad = resta;
        }
    }
}
