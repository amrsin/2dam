

package ej_respaso_1.ej_9;

/**
 *
 * @author amrsin
 */

public abstract class Punto {
    
    int x;
    int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
   public abstract String mostrarCordenadas(); 
   public abstract void cambiarCordenadas(int x, int y);
   public abstract double distanciaPuntos(Triangulo t1, Triangulo t2);
   public abstract String escribirTriangulo();  
   public abstract double perimetroTriangulo(vertice_1 v1, vertice_2 v2, vertice_3 v3);
   
}

