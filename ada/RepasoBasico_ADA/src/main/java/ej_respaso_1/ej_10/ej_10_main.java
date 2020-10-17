package ej_respaso_1.ej_10;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author singh
 */
public class ej_10_main {

    public static void main(String[] args) {

        
        
        CuentaCorriente c;

        c = rellenarCuenta();
        System.out.println("-------------------------------------------------");
        System.out.println(c.toString());
        System.out.println("-------------------------------------------------");
        System.out.println("Saldo actual " + c.getSaldo() + "€");
        System.out.println("-----------------------------------");
        System.out.println("Cambia el saldo");
        System.out.println("Cambiamos el saldo y ahora es: " + c.cambiarSaldo(Saldo()) + "€");

        

    }

    public static CuentaCorriente rellenarCuenta() {

        Scanner sc = new Scanner(System.in);
        int titulares;
        String num_cuenta = "";
        double saldo = 0;
        boolean cuenta_bien = false;
        Titular t1;
        Titular t2;
        
        CuentaCorriente cuenta = null;

        while (!cuenta_bien) {

            System.out.print("Introduzca numero cuenta(20 numero): ");
            num_cuenta = sc.nextLine();
            
            

            if (num_cuenta.length() == 20) {
                 
                try {
                    
                    BigInteger n_c = new BigInteger(num_cuenta);
                    cuenta_bien = true;
                    
                } catch (NumberFormatException e) {
                    cuenta_bien = false;
                }
            }
        }

        System.out.print("Cuantos titulares va tener la cuenta(1/2): ");
        titulares = sc.nextInt();
        sc.nextLine();
        
        if (titulares == 2) {
            
            System.out.println("Titular 1");
            t1 = alta_titular();
            System.out.println("Titular 2");
            t2 = alta_titular();
            saldo = Saldo();
            cuenta = new CuentaCorriente(t1, t2, num_cuenta, saldo);

        } else if (titulares == 1) {

            t1 = alta_titular();
            saldo = Saldo();
            cuenta = new CuentaCorriente(t1, num_cuenta, saldo);

        }

        return cuenta;

    }

    public static Titular alta_titular() {

        Scanner sc = new Scanner(System.in);

        String nom;
        String apellidos;
        String dir;
        String dni;

        System.out.print("Introduzca nombre: ");
        nom = sc.nextLine();
        System.out.print("Introduzca apellidos: ");
        apellidos = sc.nextLine();
        System.out.print("Introduzca direccion: ");
        dir = sc.nextLine();
        System.out.print("Introduzca DNI: ");
        dni = sc.nextLine();

        Titular t = new Titular(nom, apellidos, dir, dni);

        return t;
    }

    public static double Saldo() {

        Scanner sc = new Scanner(System.in);

        double saldo = 0;
        boolean saldo_bien = false;

        while (!saldo_bien) {

            System.out.print("Introduzca el saldo(en positivo): ");
            saldo = sc.nextDouble();

            if (saldo >=0) {

                saldo_bien = true;
            }
        }
        return saldo;

    }
    
}
