package com.example.lista_conobjetos;

public class Titular {

    private String titulo;
    private String subtitulo;
    private  int img;

    public Titular(String titulo, String subtitulo, int img){

        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.img = img;
    }

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
