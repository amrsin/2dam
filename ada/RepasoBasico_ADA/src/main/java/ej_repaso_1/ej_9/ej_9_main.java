/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_respaso_1.ej_9;

/**
 *
 * @author amrsin
 */
public class ej_9_main {

     public static void main(String[] args) {
        
          Triangulo t1 = new Triangulo(-1, -1);
          Triangulo t2 = new Triangulo(2, 3);
          
          vertice_1 v1 = new vertice_1(-2, 5);
          vertice_2 v2 = new vertice_2(4, 3);
          vertice_3 v3 = new vertice_3(7, -2);
          
          
          //t1.cambiarCordenadas(2, 2);
          System.out.println(t1.mostrarCordenadas());
          
          System.out.println("La distancia entre " + t1.mostrarCordenadas() + t2.mostrarCordenadas() + " es de: " + t1.distanciaPuntos(t1, t2));
          System.out.println(v1.mostrarCordenadas() + "," + v2.mostrarCordenadas() + "," + v3.mostrarCordenadas());
          System.out.println(t1.perimetroTriangulo(v1, v2, v3));
    }       
   
    
    
}
