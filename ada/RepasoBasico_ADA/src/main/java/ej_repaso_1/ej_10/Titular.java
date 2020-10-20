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
public class Titular {
    
    private String nom;
    private String apellidos;
    private String dir;
    private String dni;

    public Titular(String nom, String apellidos, String dir, String dni) {
        this.nom = nom;
        this.apellidos = apellidos;
        this.dir = dir;
        this.dni = dni;
    }  

    @Override
    public String toString() {
        return " Nombre: " + nom + ", Apellidos: " + apellidos + ", Direccion: " + dir + ", DNI: " + dni +"\n";
    }
    
}


