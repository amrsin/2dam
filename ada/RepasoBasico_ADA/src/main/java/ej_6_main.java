
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author amrit
 */
public class ej_6_main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op_menu = 0;
        int[][] array_ingresos = new int[20][10];
        
        while (op_menu != 4) {
            
        System.out.println("Bienvenido/a al menu");
        System.out.println("1- Introducir ingresos por cada vendedor");
        System.out.println("2- Total de cada vendedor");
        System.out.println("3- Total");
        System.out.println("4- Salir");
        System.out.print("Introduzca op_menu: ");
        op_menu = sc.nextInt();

     

            switch (op_menu) {

                case 1:
                    almacenar(array_ingresos);
                    break;
                case 2:
                    total_individual(array_ingresos);
                    break;
                case 3:

                    break;
                case 4:

                    break;

            }

        }

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 10; j++) {

                System.out.println(array_ingresos[i][j]);

            }

        }

    }

    public static void almacenar(int[][] array_ingresos) {

        Scanner sc = new Scanner(System.in);
        int ingreso = 0;

        for (int i = 0; i < 2; i++) {

            System.out.println("Introduzca productos del vendedor " + (i + 1));

            for (int j = 0; j < 10; j++) {

                System.out.print(" Introduzca ingresos del producto " + (j + 1) + ": ");
                ingreso = sc.nextInt();

                array_ingresos[i][j] = ingreso;
            }

        }

    }

    public static void total_individual(int[][] array_ingresos) {

          int total = 0;
        for (int i = 0; i < 20; i++) {

          

            for (int j = 0; j < 10; j++) {

                total = total + array_ingresos[i][j];

                System.out.println("Vendedor " + (i + 1));
                System.out.println("Ingresos total: " + total);

            }
                total = 0;
        }
    }
}
