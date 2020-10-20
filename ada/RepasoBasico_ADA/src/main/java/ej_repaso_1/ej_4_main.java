package ej_respaso_1;


import java.util.Scanner;

/**
 *
 * @author amrsin
 */
public class ej_4_main {

    public static void main(String[] args) {

        //var
        Scanner sc = new Scanner(System.in);
        int num;

        //datos necesarios por user
        System.out.println("Introduzca numero entero y positivo: ");
        num = sc.nextInt();

        if (num > 0) {
            System.out.println("--------------");

            for (int i = 1; i <= num; i++) {
                //imprimimos en cada iterracion numero de 1 / 10
                System.out.print(i + "\t");
                //si i % 2 el resultado sale exacta entonces imprimimos i
                if (i % 2 == 0) {
                    System.out.print(i + "\t");
                } else {
                    System.out.print("- \t");
                }
                //si i % 3 el resultado sale exacta entonces imprimimos i
                if (i % 3 == 0) {
                    System.out.print(i + "\n");

                } else {
                    System.out.print("- \n");
                }
            }
        } else {
            System.out.println("El numero tiene que ser entero y positivo.");
        }
    }
}