/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas_ej_OO.ej_1;

/**
 *
 * @author singh
 */
public class ej_1_main {
    
    public static void main(String[] args) {
        
        Cuenta c1 = new Cuenta("David");
        Cuenta c2 = new Cuenta("Juan", 100);
        System.out.println("----------------------------------------");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println("----------------------------------------");
        System.out.println("Ingresamos 100 euros a las cuentas");
        c1.ingresar(100);
        c2.ingresar(100);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println("----------------------------------------");
        System.out.println("Retiramos 50 euros a las cuentas");
        c1.retirar(50);
        c2.retirar(50);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }   
    
}
