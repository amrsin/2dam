package ej_respaso_1.ej_7;

import ej_respaso_1.ej_7.Estudiante;
import ej_respaso_1.ej_7.Curso;
import java.util.*;

/**
 *
 * @author amrit
 */
public class ej_7_main {
    
     public static void main(String[] args) {
         
         //var
         Scanner sc = new Scanner(System.in);
         ArrayList<Estudiante> lista_estudiantes = new ArrayList<Estudiante>();
         Estudiante e;
         int op_menu = 0;
         
         while(op_menu!=6) {
             
         System.out.println("---------------------------------");
         System.out.println("Bienvenido/a al menu");
         System.out.println("1. Dar de alta alumno");
         System.out.println("2. Dar de baja alumno");
         System.out.println("3. Cambiar nota del alumno");
         System.out.println("4. Lista alumnos");
         System.out.println("5. Info extra");
         System.out.println("6. Salir");
         System.out.print("Indroduzca op menu: ");
         op_menu = sc.nextInt();
         System.out.println("---------------------------------");

         switch(op_menu) {
             
             case 1:
                e = alta_alumno(lista_estudiantes);
                lista_estudiantes.add(e);
                break;
             case 2: 
                 baja_alumno(lista_estudiantes);
                 break;
             case 3: 
                 cambiar_nota(lista_estudiantes);
                 break;
             case 4:
                 lista_alumnos(lista_estudiantes);
                 break;
             case 5:
                 extra_info(lista_estudiantes);
                 break;
             case 6: 
                 System.out.println("Gracias por usar el programa");
                 Curso c = new Curso(lista_estudiantes);
                 break;
         }
       }
     }
     
     public static Estudiante alta_alumno(ArrayList lista_estudiantes){
         
         //var
         Scanner sc = new Scanner(System.in);
         String nom;
         String apellido;
         String di;
         int nota_numero;
         //datos user
         System.out.print("Introduzca nombre: ");
         nom = sc.nextLine();
         System.out.print("Introduzca apellido: ");
         apellido = sc.nextLine();
         System.out.print("Introduzca direccion: ");
         di = sc.nextLine();
         System.out.print("Introduzca nota(numero): ");
         nota_numero = sc.nextInt();
         Estudiante e = new Estudiante(nom, apellido, di, nota_numero, nom);
         System.out.println("Se ha dado de alta al alumno " + nom);
         return e;
    }
     
     public static void baja_alumno(ArrayList lista_estudiantes){
         
         //var
         Scanner sc = new Scanner(System.in);
         String nom;
         String nom_aux;
         boolean encontrado = false;
         Estudiante e;
         Iterator iter = lista_estudiantes.iterator();

         //datos user
         System.out.print("Introduzca nombre: ");
         nom = sc.nextLine();
         
        
         while (iter.hasNext()) {             
            
             
            e = (Estudiante) iter.next();
            
            nom_aux = e.getNom();
            
             if (nom_aux.equalsIgnoreCase(nom)) {
                 
                 lista_estudiantes.remove(e);
                 encontrado = true;
                 System.out.println("Se ha dado de baja al alumno " + nom);
                 break;
             } 
         }
         if (!encontrado) {
          System.out.println("No hay alumno de nombre " + nom + " en la bd");

         }
 
    }
     
     public static void cambiar_nota(ArrayList lista_estudiantes){
         
         //var
         Scanner sc = new Scanner(System.in);
         String nom;
         String nom_aux;
         int new_nota;
         boolean encontrado = false;
         Estudiante e;
         Iterator iter = lista_estudiantes.iterator();

         //datos user
         System.out.print("Introduzca nombre: ");
         nom = sc.nextLine();
         
        
         while (iter.hasNext()) {             
            
             
            e = (Estudiante) iter.next();
            
            nom_aux = e.getNom();
            
             if (nom_aux.equalsIgnoreCase(nom)) {
                 
                 System.out.print("Introduzca nueva nota: ");
                 new_nota = sc.nextInt();
                 e.setNota_numero(new_nota);
                 e.setNota_letra(new_nota);
                 encontrado = true;
             } 
         }
         if (!encontrado) {
          System.out.println("No hay alumno de nombre " + nom + " en la bd");

         }
 
    }
     
     
       
     public static void lista_alumnos(ArrayList lista_estudiantes) {
         
         Iterator iter = lista_estudiantes.iterator();
         Estudiante e;
         
         while (iter.hasNext()) {

         e = (Estudiante) iter.next();
         
             System.out.println(e.toString());
             
         }
       }
     
     public static void extra_info(ArrayList lista_estudiantes){
         
         
         Iterator iter = lista_estudiantes.iterator();
         Estudiante e;
         
         int nota;
         String aprobados = "";
         String suspendidos = "";
         int size_array = lista_estudiantes.size();
         int cont_aprobados = 0;
         int cont_suspendidos = 0;     
         double procentaje_aprobados_d = 0;
         double procentaje_suspendidos_d = 0;
         
         
         while (iter.hasNext()) {

         e = (Estudiante) iter.next();
         
             nota = e.getNota_numero();
             
             if (nota < 0) {
                     
                 suspendidos = suspendidos + e.getNom() + "(not presented)\n";
             }else if (nota <=4) {
                 
                 suspendidos = suspendidos + e.getNom() + "\n";
                 cont_suspendidos++;
                                      
             }else if (nota >=5) {
    
                 aprobados = aprobados + e.getNom() + "\n";
                 cont_aprobados++;
             }   
         }
         
         aprobados = "Lista de alumnos aprobados \n" + aprobados;
         suspendidos = "Lista de alumnos suspendidos \n" + suspendidos;
         
         if (cont_aprobados !=0 || cont_suspendidos !=0) {
             
            procentaje_aprobados_d = (double) cont_aprobados / (double) size_array * 100;
            procentaje_suspendidos_d = (double) cont_suspendidos / (double) size_array * 100;
            
            procentaje_aprobados_d = Math.round(procentaje_aprobados_d);
            procentaje_suspendidos_d = Math.round(procentaje_suspendidos_d);
         }
           
         System.out.println(aprobados);
         System.out.println(suspendidos);
         System.out.println("---------------------------------");
         System.out.println(procentaje_aprobados_d + "% aprobados");
         System.out.println(procentaje_suspendidos_d + "% suspendidos");
     }          
 } 