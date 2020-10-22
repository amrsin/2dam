/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas_ej_OO.ej_2;

/**
 *
 * @author singh
 */
public class Persona {

    protected String nombre;
    protected int edad;
    protected String DNI;
    protected char sexo;
    protected double peso;
    protected double altura;
    
    public Persona() {

        nombre = "";
        edad = 0;
        DNI = genrarDNI();
        sexo = 'H';
        peso = 0;
        altura = 0;
    }

    public Persona(String nombre, int edad, char sexo) {

        this.nombre = nombre;
        this.edad = edad;
        DNI = genrarDNI();
        this.sexo = sexo;
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad,char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        DNI = genrarDNI();
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    

    public String calcularIMC() {

        double peso_actual = this.peso / Math.pow(this.altura, 2);
        String peso;

        if (peso_actual >= 20 && peso_actual <= 25) {

            peso = "La persona esta en su peso ideal";
        }else if (peso_actual < 20) {

            peso = "La persona esta por debajo de su peso ideal";
        } else {

            peso = "La persona esta por encima de su peso ideal";
        }
        
        return peso;
    }
    
    public boolean esMayorDeEdad() {
        
        boolean esmayor = false;
        
        if (this.edad >= 18) {
            
            esmayor = true;
        }
        return esmayor;
    }
    
    public String genrarDNI() {
        
       int numero = (int)(Math.random()*10000000+10000000);
       String dni = Integer.toString(numero);
        return dni;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", DNI: " + DNI + ", Sexo: " + sexo + ", Peso: " + peso + ", Altura: " + altura;
    }
}