
package escritor_main;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amrit
 * 
 */


class Escribir implements Runnable {
    
   
    public synchronized void boli() throws InterruptedException {
        
       
        System.out.println(Thread.currentThread().getName() + "Tengo boli");
        Thread.sleep(1000);
    }
    
    public synchronized void libreta() throws InterruptedException {
        
       
        System.out.println(Thread.currentThread().getName() + "Tengo libreta");
        Thread.sleep(1000);
    }
    
   
 
    @Override
    public void run() {
        
        for (int i = 0; i < 10; i++) {
            
            try {
                boli();
                libreta();

            } catch (InterruptedException ex) {
            }
            
        }
        
        
    }
    
    
}
public class Escritor_Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Escribir escribir = new Escribir();
        Thread escritor1 = new Thread(escribir, "Escritor 1");
        Thread escritor2 = new Thread(escribir, "Escritor 2");
        
        escritor1.start();
        escritor2.start();
    }
    
}
