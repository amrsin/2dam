package com.example.lista_conobjetos;

public class Titular {
    //var
    private String titulo;
    private String subtitulo;
    private  int img;
    //constructor con todos los datos
    public Titular(String titulo, String subtitulo, int img){

        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.img = img;
    }
    //getters
    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public int getImg() {
        return img;
    }
}
