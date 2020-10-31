package cajeroautomatico;

/**
 *
 * @author amrit
 */
class Cuenta {

    private int num_cuenta;
    private int fondos;

    public Cuenta(int num_cuenta, int fondos) {

        this.num_cuenta = num_cuenta;
        this.fondos = fondos;

    }

    public int getNum_cuenta() {

        return num_cuenta;
    }

    public int getfondos() {

        return fondos;
    }

    public synchronized int retirar_dinero(int cantidad) {

        return this.fondos = this.fondos - cantidad;

    }

}

class socio_dinero implements Runnable {

    private int cantidad;
    private static Cuenta c = new Cuenta(1234, 50);

    public void sacar_dinero(int cantidad) throws InterruptedException {

        if (c.getfondos() >= cantidad) {

            System.out.println(Thread.currentThread().getName()
                    + " está realizando un retiro de: " + cantidad + ".");
            Thread.sleep(1000);
            c.retirar_dinero(cantidad);
            System.out.println(Thread.currentThread().getName() + ": Retiro realizado.");
            System.out.println(Thread.currentThread().getName() + ": Los fondos son de: " + c.getfondos());
        } else {
            System.out.println("No hay suficiente dinero en la cuenta para realizar el retiro Sr." + Thread.currentThread().getName());
            System.out.println("Su saldo actual es de " + c.getfondos());
            Thread.sleep(1000);
        }

    }

    public void run() {

        for (int i = 0; i <= 3; i++) {
            try {
                this.sacar_dinero(10);
                if (c.getfondos() < 0) {
                    System.out.println("La cuenta está sobregirada.");
                }
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }

    }
}

public class CajeroAutomatico {

    public static void main(String[] args) {

        socio_dinero sc = new socio_dinero();

        Thread socio1 = new Thread(sc);
        Thread socio2 = new Thread(sc);

        socio1.start();
        socio1.setName("socio1");
        socio2.start();
        socio2.setName("socio2");

    }
}
