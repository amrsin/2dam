
package ej_repaso_1.ej_9;

/**
 *
 * @author amrsin
 */

public class Triangulo extends Punto{
    
    public Triangulo(int x, int y) {
        super(x, y);
    }

   
    public String mostrarCordenadas() {
        
        String result = "(" + x + "," + y + ")"; 
        return result;
        
    }

    @Override
    public void cambiarCordenadas(int x, int y) {
        
        this.x = x;
        this.y = y;
    }

    @Override
    public double distanciaPuntos(Triangulo t1, Triangulo t2) {
        
        double distancia = 0;
        
        distancia = Math.sqrt(Math.pow(2, t2.getX()- (t1.getY())) + Math.pow(2, (t2.getY()) - (t1.getY())));
        
        distancia = Math.round(distancia);
        return distancia;
        
       
    }

    @Override
    public String escribirTriangulo() {
        
        String result = "(" + x + "," + y + "),"; 
        return result;
               
    }

    @Override
    public double perimetroTriangulo(vertice_1 v1, vertice_2 v2, vertice_3 v3) {
        
        double distancia = 0;
        
        //distancia v1 a v2
        distancia = Math.sqrt(Math.pow(2, v1.getX()- (v2.getX())) + Math.pow(2, (v1.getY()) - (v2.getY())));
        //distancia v2 a v3
        distancia = distancia + Math.sqrt(Math.pow(2, v2.getX()- (v3.getX())) + Math.pow(2, (v2.getY()) - (v3.getY())));
        //distancia v3 a v1
        distancia = distancia + Math.sqrt(Math.pow(2, v3.getX()- (v1.getX())) + Math.pow(2, (v3.getY()) - (v1.getY())));
        distancia = Math.round(distancia);
        return distancia;
        
    }    
}
