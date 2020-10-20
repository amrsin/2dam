/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_repaso_2.ej_1;

/**
 *
 * @author singh
 */
public class Libro {
    
    private String Titulo;
    private String autor;

    public Libro(String Titulo, String autor) {
        this.Titulo = Titulo;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return Titulo + " fue escrito por " + autor;
    }
}
