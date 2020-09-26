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
         
         while(op_menu!=7) {
             
         System.out.println("---------------------------------");
         System.out.println("Bienvenido/a al menu");
         System.out.println("1. Dar de alta alumno");
         System.out.println("2. Dar de baja alumno");
         System.out.println("3. Cambiar datos del alumno");
         System.out.println("4. Lista alumnos");
         System.out.println("5. Cambiar nota");
         System.out.println("6. Info extra");
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
                 
                 break;
             case 4:
                 lista_alumnos(lista_estudiantes);
                 break;
             case 5:
                 
                 break;
             case 6: 
                 extra_info(lista_estudiantes);
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
                 break;
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
         while (iter.hasNext()) {

         e = (Estudiante) iter.next();
         
             nota = e.getNota_numero();
             
             if (nota <=4 ) {
                 
                 suspendidos = suspendidos + e.getNom() + "\n";
             }else if (nota >=5) {
                 
                 aprobados = aprobados + e.getNom() + "\n";
             }
             
             
             
         }
         
         aprobados = "Lista de alumnos aprobados \n" + aprobados;
         suspendidos = "Lista de alumnos suspendidos \n" + suspendidos;
         
         System.out.println(aprobados);
         System.out.println(suspendidos);
         
     }
             
             
     } 