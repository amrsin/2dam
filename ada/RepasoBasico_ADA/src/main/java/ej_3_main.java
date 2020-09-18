
import java.util.Scanner;

/**
 *
 * @author amrsin
 */
public class ej_3_main {

    public static void main(String[] args) {

        //var
        Scanner sc = new Scanner(System.in);
        int num;
        //info user
        System.out.print("Introduzca numero: ");
        num = sc.nextInt();
        System.out.println("Divisores del numero " + num);
        System.out.println("------------------------------");
        //bucle interar hasta numero introducido por user
        for (int i = 1; i <= num; i++) {
            //si num % i sale exacta la division imprimimos ya que es divisor
            if (num % i == 0) {
                System.out.println(i);
            }
        }
    }
}
