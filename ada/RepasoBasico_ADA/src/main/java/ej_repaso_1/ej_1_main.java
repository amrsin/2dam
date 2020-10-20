package ej_repaso_1;

import java.util.Scanner;

/**
 *
 * @author amrsin
 */
public class ej_1_main {

    public static void main(String[] args) {

        //var
        String tipo_conductor;
        double tasa = 0;
        boolean puede = false;
        Scanner sc = new Scanner(System.in);
        //datos user
        System.out.print("Introduzca el tipo de condutor: ");
        tipo_conductor = sc.nextLine();
        System.out.print("Introduzca la tasa: ");
        tasa = sc.nextDouble();
        //llamamos a subclase llamda puede_conducir
        puede = puede_conducir(tipo_conductor, tasa);

        if (puede) {
            System.out.println("Puede seguir conduciendo");

        } else {
            System.out.println("No puede seguir conduciendo.");

        }
    }

    //para averiguar si la tasa segun conductor es correcta o no.
    public static boolean puede_conducir(String tipo_conductor, double tasa) {

        boolean puede = false;
        if ((tipo_conductor.equalsIgnoreCase("autobus") || tipo_conductor.equalsIgnoreCase("taxi")
                || tipo_conductor.equalsIgnoreCase("ambulancia")) && tasa <= 0.3) {

            puede = true;
        } else {
            if ((tipo_conductor.equalsIgnoreCase("conductor") || tipo_conductor.equalsIgnoreCase("ciclista")) && tasa <= 0.5) {

                puede = true;
            }
        }
        return puede;
    }
}
