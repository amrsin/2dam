
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
public class ej_3_main {
    
    public static void main(String[] args) {
        
      Scanner sc = new Scanner(System.in);
      int num;
      
        System.out.println("Introduzca numero: ");
        num = sc.nextInt();
        System.out.println("Divisores del numero " + num);
        for (int i = 1; i <=num; i++) {
            
             if (num % i==0) {
                 System.out.println(i);
            }
        }
    }  
}
