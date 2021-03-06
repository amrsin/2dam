package ej_repaso_1.ej_7;

/**
 *
 * @author amrit
 */
public class Estudiante {

    private String nom;
    private String apellido;
    private String di;
    private int nota_numero;
    private String nota_letra;

    public Estudiante(String nom, String apellido, String di,
            int nota_numero, String nota_letra) {

        this.nom = nom;
        this.apellido = apellido;
        this.di = di;
        this.nota_numero = nota_numero;
        this.nota_letra = clasificacion_nota(this.nota_numero);
    }

    public String clasificacion_nota(int nota_numero) {

        String nt_letra = "";

        if (nota_numero < 0) {
            nt_letra = "Not prented";
        } else if (nota_numero < 5) {
            nt_letra = "Suspens";
        } else if (nota_numero < 7) {
            nt_letra = "Approved";
        } else if (nota_numero < 9 || nota_numero == 9) {
            nt_letra = "Outstanding";
        } else if (nota_numero == 10) {
            nt_letra = "Honors";

        }
        return nt_letra;
    }

    public String getNom() {
        return nom;
    }

    public int getNota_numero() {
        return nota_numero;
    }

    public void setNota_numero(int nota_numero) {
        this.nota_numero = nota_numero;
    }

    public void setNota_letra(int nota) {
        
        
        this.nota_letra = clasificacion_nota(nota);
    }
    
 
    public String toString() {
        return "Nombre: " + nom + ", Apellido: " + apellido 
               + ", Direccion: " + di + ", Nota numero: " + nota_numero + ", Nota letra: " + nota_letra;
    }
    
}
