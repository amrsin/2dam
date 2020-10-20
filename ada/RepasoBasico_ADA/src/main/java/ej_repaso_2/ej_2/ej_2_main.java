package ej_repaso_2.ej_2;

import java.util.Scanner;

/**
 *
 * @author singh
 */
public class ej_2_main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int alto;
        int ancho;
        int area;
        int perimetro;

        System.out.println("---------------------------");
        System.out.print("Proporciona el alto: ");
        alto = sc.nextInt();
        System.out.print("Proporciona el ancho: ");
        ancho = sc.nextInt();
        System.out.println("---------------------------");

        area = ancho * alto;
        perimetro = ancho * 2 + alto * 2;

        System.out.println("Area: " + area);
        System.out.println("Perimetro " + perimetro);

    }
}
