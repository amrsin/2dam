package ej_repaso_1.ej_8;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amrit
 */
public class Contactos {
    
    private String nom;
    private int num_telf;

    public Contactos(String nom, int num_telf) {
        this.nom = nom;
        this.num_telf = num_telf;
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNum_telf() {
        return num_telf;
    }

    public void setNum_telf(int num_telf) {
        this.num_telf = num_telf;
    }

    @Override
    public String toString() {
        return "Nombre: " + nom + ", Numero telefono: " + num_telf;
    }
    
        
    
}
