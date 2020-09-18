
/**
 *
 * @author amrsin
 */
import java.util.*;

public class ej_2_main {

    public static void main(String[] args) {
        //var
        int a;
        int b;
        int c;
        Scanner sc = new Scanner(System.in);
        //valores introducidos por user
        System.out.print("Introduzca valor a: ");
        a = sc.nextInt();
        System.out.print("Introduzca valor b: ");
        b = sc.nextInt();
        System.out.print("Introduzca valor c: ");
        c = sc.nextInt();
        //comparacion para saber si es trangulo
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("Es triangulo");
        } else {
            System.out.println("No es triangulo");
        }
    }
}
