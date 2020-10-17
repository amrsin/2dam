

package ej_respaso_1.ej_10;

/**
 *
 * @author singh
 */
public class ej_10_main {
    
    
    public static void main(String[] args) {
        
        Titular t1 = new Titular("Juan", "Rodrigues", "Calle a", "1");
        Titular t2 = new Titular("David", "Muñoz", "Calle b", "2");
        CuentaCorriente c = new CuentaCorriente(t1, "12345678912345678910", 10.0);
        System.out.println("Saldo actual " + c.getSaldo());
        System.out.println("Ingresamos 10 euros " + c.rellenarCuenta(10));
        System.out.println("Cambiamos el saldo a 50€: " + c.cambiarSaldo(50));
        
        
        
    }
    
}
