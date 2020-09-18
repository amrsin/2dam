/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amrsin
 */
public class ej_5_main {

    public static void main(String[] args) {

        int num_random;
        int num;
        int num_aleatorios[] = new int[15];
        boolean encontrado = false;
        for (int i = 0; i < num_aleatorios.length; i++) {

            num_random = (int) (Math.random() * 90 + 1);
            

            for (int j = 0; j < num_aleatorios.length; j++) {
                    
                if (num_random == num_aleatorios[j]) {
                    encontrado = true;
                    i--;
                    break;
                } 
            }
            
            if (!encontrado) {
 
            num_aleatorios[i] = num_random;
                
            }
           
          encontrado = false;
        }
        System.out.println("----------------");
        System.out.println("Carton bingo");
        for (int i = 0; i < num_aleatorios.length; i++) {

            System.out.print( num_aleatorios[i] + "|");
        }
    }
}