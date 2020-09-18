
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author amrsin
 */
public class ej_1_main {

    public static void main(String[] args) {

        // TODO code application logic here
        //var
        String tipo_conductor;
        double tasa = 0;
        boolean puede = false;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el tipo de condutor: ");
        tipo_conductor = sc.nextLine();
        System.out.println("Introduzca la tasa: ");
        tasa = sc.nextDouble();

        puede = puede_conducir(tipo_conductor, tasa);

        if (puede) {
            System.out.println("Puede seguir conduciendo");

        } else {
            System.out.println("No puede seguir conduciendo.");

        }

    }

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
