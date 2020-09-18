
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
public class ej_4_main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num;
        
        System.out.println("Introduzca numero entero y positivo: ");
        num = sc.nextInt();
        
        if (num % 1 == 0) {
            
            for (int i = 1; i <= num; i++) {
                
                System.out.print(i + "\t");
                
                if (i % 2 == 0) {
                    System.out.print(i + "\t");
                }else{
                    System.out.print("- \t");
                }
                  if (i % 3 == 0) {
                    System.out.print(i+ "\n");

                }else{
                    System.out.print("- \n");
                }
            }
        }else{
            System.out.println("El numero tiene que ser entero y positivo.");
        }       
    }  
}