package escritor_main;

/**
 *
 * @author amrit
 *
 */

public class Escritor_Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final Object boligrafo = "boligrafo";
        final Object libreta = "Libreta";

        Thread escritor1 = new Thread("Escritor 1") {

            public void run() {

                for (int i = 0; i < 5; i++) {

                    synchronized (boligrafo) {
                        System.out.println("El escritor 1: bloquea el boligrafo");
                        synchronized (libreta) {
                        System.out.println("El escritor 1: bloquea la libreta");
                        }
                      System.out.println("El escritor 1: escribe");
                    }
                }
            }

        };
        
        Thread escritor2 = new Thread("Escritor 2") {

            public void run() {

                for (int i = 0; i < 5; i++) {

                    synchronized (boligrafo) {
                        System.out.println("El escritor 2: bloquea el boligrafo");
                        synchronized (libreta) {
                        System.out.println("El escritor 2: bloquea la libreta");
                        }
                      System.out.println("El escritor 2: escribe");
                    }
                }
            }

        };
        escritor1.start();
        escritor2.start();
    }
}