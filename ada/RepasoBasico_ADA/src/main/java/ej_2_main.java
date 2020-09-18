/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        
        System.out.print("Introduzca valor a: ");
        a = sc.nextInt();
        System.out.print("Introduzca valor b: ");
        b = sc.nextInt();
        System.out.print("Introduzca valor c: ");
        c = sc.nextInt();
        
        
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("Es triangulo");
        }else{
            System.out.println("No es triangulo");
        }
    }
}
