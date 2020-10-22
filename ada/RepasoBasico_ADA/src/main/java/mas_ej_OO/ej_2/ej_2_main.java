/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas_ej_OO.ej_2;

import java.util.Scanner;

/**
 *
 * @author singh
 */
public class ej_2_main {
    
    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);
        String nombre;
        int edad;
        char sexo;
        double peso;
        double altura;
        
        System.out.print("Introduzca nombre: ");
        nombre = sc.nextLine();
        System.out.print("Introduzca edad: ");
        edad = sc.nextInt();
        System.out.print("Introduzca sexo: ");
        sexo = sc.next().charAt(0);
        System.out.print("Introduzca peso: ");
        peso = sc.nextDouble();
        System.out.print("Introduzca altura: ");
        altura = sc.nextDouble();
        
        Persona p1 = new Persona();
        Persona p2 = new Persona(nombre, edad, sexo);
        Persona p3 = new Persona(nombre, edad, sexo, peso, altura);
        
        p1.setNombre("Juan");
        p1.setEdad(20);
        p1.setSexo('M');
        p1.setPeso(70);
        p1.setAltura(1.65);
        
        p2.setNombre("David");
        p2.setPeso(80);
        p2.setAltura(1.75);
        System.out.println("------------------------");
        System.out.println(p1.toString());
        System.out.println(p1.calcularIMC());
        System.out.println("Es mayor: " + p1.esMayorDeEdad());
        System.out.println("------------------------");
        System.out.println(p2.toString());
        System.out.println(p2.calcularIMC());
        System.out.println("Es mayor: " + p2.esMayorDeEdad());
        System.out.println("------------------------");
        System.out.println(p3.toString());
        System.out.println(p3.calcularIMC());
        System.out.println("Es mayor: " + p3.esMayorDeEdad());
        
    }
}