/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_repaso_1.ej_10;

/**
 *
 * @author singh
 */
public class CuentaCorriente {
    
    private Titular t1;
    private Titular t2;
    private String num_cuenta;
    double saldo;


    public CuentaCorriente(Titular t1, String num_cuenta, double saldo) {
        this.t1 = t1;
        this.num_cuenta = num_cuenta;
        this.saldo = saldo;
    }
    
    public CuentaCorriente(Titular t1, Titular t2, String num_cuenta, double saldo) {
        this.t1 = t1;
        this.t2 = t2;
        this.num_cuenta = num_cuenta;
        this.saldo = saldo;
    }

    public Titular getT1() {
        return t1;
    }

    public Titular getT2() {
        return t2;
    }

    public String getNum_cuenta() {
        return num_cuenta;
    }

    public double getSaldo() {
        return saldo;
    }
     
    public double cambiarSaldo(double s) {
        
        this.saldo = s;
        return saldo;
    }

    
    @Override
    public String toString() {
        
        if (t2 == null) {
          return  " Titular: " + t1 + " Numero cuenta: " + num_cuenta + ", Saldo: " + saldo + "€";
 
        }else{
          return  " Titular_1: " + t1 + " Titular_2: " + t2 + " Numero cuenta: " + num_cuenta + ", Saldo: " + saldo  + "€";
  
        }
    }    
}