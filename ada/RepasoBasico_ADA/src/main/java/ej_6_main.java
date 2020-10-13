
import java.util.Scanner;

/**
 *
 * @author amrit
 */
public class ej_6_main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op_menu = 0;
        int[][] array_ingresos = new int[18][10];

        while (op_menu != 4) {
            System.out.println("-------------------------");
            System.out.println("Bienvenido/a al menu");
            System.out.println("1- Introducir ingresos por cada vendedor");
            System.out.println("2- Total de cada vendedor");
            System.out.println("3- Total de todos los vendedores");
            System.out.println("4- Salir");
            System.out.print("Introduzca op_menu: ");
            op_menu = sc.nextInt();
            System.out.println("-------------------------");

            switch (op_menu) {

                case 1:
                    almacenar(array_ingresos);
                    break;
                case 2:
                    total_individual(array_ingresos);
                    break;
                case 3:
                    total(array_ingresos);
                    
                    break;
                case 4:
                    System.out.println("Gracias por usar el programa");
                    break;
              

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
        for (int i = 0; i < 18; i++) {

            System.out.println("Vendedor " + (i + 1) + ":");

            for (int j = 0; j < 10; j++) {

                total = total + array_ingresos[i][j];
                System.out.print("[ " + array_ingresos[i][j] + "]");
            }
            System.out.println("\n-----------------------------");
            System.out.println("Total ingresos vendedor " + (i + 1) + ": " + total);

            total = 0;
        }
    }
    
    public static void total(int[][] array_ingresos) {

        int total = 0;
        for (int i = 0; i < 18; i++) {


            for (int j = 0; j < 10; j++) {

                total = total + array_ingresos[i][j];
                
            }   
        }
            System.out.println("Total ingresos de los vendedores: " + total);
    }
}