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
         int op_menu = 7;
         System.out.println("Bienvenido/a al menu");
         System.out.println("1.Dar de alta alumno");
         
         
         switch(op_menu) {
             
             case 1:
                e = alta_alumno(lista_estudiantes);
                break;
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
         System.out.println("Introduzca nombre: ");
         nom = sc.nextLine();
         System.out.println("Introduzca apellido: ");
         apellido = sc.nextLine();
         System.out.println("Introduzca direccion: ");
         di = sc.nextLine();
         System.out.println("Introduzca nota(numero): ");
         nota_numero = sc.nextInt();
         Estudiante e = new Estudiante(nom, apellido, di, nota_numero, nom);
         lista_estudiantes.add(e);
         return e;
    }
}
