
package ej_repaso_2.ej_1;

import java.util.Scanner;

/**
 *
 * @author singh
 */
public class ej_1_main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String titulo;
        String autor;
        System.out.println("---------------------------");
        System.out.print("Proporciona el titulo: ");
        titulo = sc.nextLine();

        System.out.print("Proporciona el autor: ");
        autor = sc.nextLine();

        System.out.println("---------------------------");
        Libro l = new Libro(titulo, autor);
        System.out.println(l.toString());

    }
}
