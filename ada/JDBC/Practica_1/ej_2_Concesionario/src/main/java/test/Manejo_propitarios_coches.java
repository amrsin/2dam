/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import datos.CocheDAO;
import datos.PropietarioDAO;
import domain.Coche;
import domain.Propietario;
import java.util.*;
/**
 *
 * @author singh
 */
public class Manejo_propitarios_coches {
        
    private static PropietarioDAO propietarioDao = new PropietarioDAO();
    private static CocheDAO cocheDao = new CocheDAO();
    private static List<Propietario> list_propietarios;
    private static List<Coche> list_coches;
    

    
    public static void main(String[] args) {


        int op_menu = 0;

        while (op_menu != 9) {

            op_menu = menu();

            switch (op_menu) {

                case 1:
                    insert_propietario();
                    break;
                case 2:
                    insert_coche();
                    break;
                case 3:
                    delete_propietario();
                    break;
                case 4:
                    delete_coche();
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    listar_propietarios(list_propietarios);
                    break;
                case 8:
                    listar_coches(list_coches);
                    break;
                case 9:
                    System.out.println("Gracias por usar el menu");
                    break;
                default:
                    System.out.println("La opcion menu no es valida intente de nuevo, porfavor");
            }
        }
    }
    //metodo para pintar menu + leer op menu
    public static int menu() {

        Scanner sc = new Scanner(System.in);
        int op_menu;
        System.out.println("____________________________________________");
        System.out.println("|            Bienvenido/a al menu BD       |");
        System.out.println("|------------------------------------------|");
        System.out.println("|        1.Insertar nuevo propietario      |");
        System.out.println("|        2.Insertar nuevo coche            |");
        System.out.println("|        3.Eliminar propietario            |");
        System.out.println("|        4.Eliminar coche                  |");
        System.out.println("|        5.Actualizar datos propietario    |");
        System.out.println("|        6.Actualizar datos coche          |");
        System.out.println("|        7.Listar los propietarios         |");
        System.out.println("|        8.Listar los coches               |");
        System.out.println("|        9.Salir                           |");
        System.out.println("|------------------------------------------|");
        System.out.print("|        Introduza opcion del menu:        |");
        op_menu = sc.nextInt();
        System.out.println("--------------------------------------------");
       return op_menu;
    }
    
     //metodo para insertar nuevo registro en bd
    public static void insert_propietario() {
        //var 
        int registros;
        Propietario p1;

        p1 = teclado_propietario(); //llamando metodo teclado
        registros = propietarioDao.insert(p1);//llamando metodo insert donde de verdad agregaremos a la bd el propietario
        
        //si registros es distinto 0 es que se ha insetado user bien, sino algo ha fallado
        if (registros != 0) {

            System.out.println("Se ha agregado a la bd el propietario con nombre " + p1.getNombre());
        } else {

            System.out.println("Ha habido fallo a la hora de insertar el propietario");
        }
    }
    
     //metodo para insertar nuevo registro en bd
    public static void insert_coche() {
        //var 
        int registros;
        Coche c1;

        c1 = teclado_coche(); //llamando metodo teclado
        registros = cocheDao.insert(c1);//llamando metodo insert donde de verdad agregaremos a la bd el user
        
        //si registros es distinto 0 es que se ha insetado user bien, sino algo ha fallado
        if (registros != 0) {

            System.out.println("Se ha agregado a la bd el coche con matricula " + c1.getMatricula());
        } else {

            System.out.println("Ha habido fallo a la hora de insertar el coche");
        }
    }
    
    public static void delete_propietario() {
        //variables
        Scanner sc = new Scanner(System.in);
        String DNI;
        int registros;
        //datos por user
        System.out.print("Introduzca DNI: ");
        DNI = sc.nextLine();
        //objeto tipo propietario con DNI
        Propietario p1 = new Propietario(DNI);
        registros = propietarioDao.delete(p1);//metodo donde realmente se eliminar el propietario de bd
        
        //si registros es distinto 0 es que se ha eliminado propietario bien, sino algo ha fallado
        if (registros != 0) {

            System.out.println("Se ha eliminado de la bd el propietario con DNI " + DNI);
        } else {

            System.out.println("Ha habido fallo a la hora de eliminar el propietario");
        }
    }
    
    public static void delete_coche() {
        //variables
        Scanner sc = new Scanner(System.in);
        String Matricula;
        int registros;
        //datos por user
        System.out.print("Introduzca matricula: ");
        Matricula = sc.nextLine();
        //objeto tipo coche con matricula
        Coche c1 = new Coche(Matricula);
        registros = cocheDao.delete(c1);//metodo donde realmente se eliminar el coche de bd
        
        //si registros es distinto 0 es que se ha eliminado user bien, sino algo ha fallado
        if (registros != 0) {

            System.out.println("Se ha eliminado de la bd el coche con matricula " + Matricula);
        } else {

            System.out.println("Ha habido fallo a la hora de eliminar el coche");
        }
    }
   
     //listar propietarios actuales en la bd
    public static void listar_propietarios(List<Propietario> list_propietarios) {

        list_propietarios = propietarioDao.select();
        list_propietarios.forEach(Propietario -> {

            System.out.println("Propietario = " + Propietario);
        });
    }
     
     //listar propietarios actuales en la bd
    public static void listar_coches(List<Coche> list_coches) {

        list_coches = cocheDao.select();
        list_coches.forEach(Coche -> {

            System.out.println("Coche = " + Coche);
        });
    }
    
     //metodo para crear objeto tipo Propietario con los datos introducidos por user 
    public static Propietario teclado_propietario() {
        //variables
        Scanner sc = new Scanner(System.in);
        String DNI;
        String Nombre;
        int Edad;
        //datos requeridos por user
        System.out.print("Introduzca DNI: ");
        DNI = sc.nextLine();
        
        System.out.print("Introduzca nombre: ");
        Nombre = sc.nextLine();

        System.out.print("Introduzca edad: ");
        Edad = sc.nextInt();
        //creando nuevo objeto de tipo propietario con los datos proporcionados por teclado
        Propietario p1 = new Propietario(DNI, Nombre, Edad);
        
      return p1;
    }
    
     //metodo para crear objeto tipo Coche con los datos introducidos por user 
    public static Coche teclado_coche() {
        //variables
        Scanner sc = new Scanner(System.in);
        String Matricula;
        String Marca;
        int Precio;
        String DNI;

        //datos requeridos por user
        System.out.print("Introduzca matricula: ");
        Matricula = sc.nextLine();
        
        System.out.print("Introduzca marca: ");
        Marca = sc.nextLine();

        System.out.print("Introduzca precio: ");
        Precio = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduzca DNI: ");
        DNI = sc.nextLine();
        //creando nuevo objeto de tipo coche con los datos proporcionados por teclado
        Coche c1 = new Coche(Matricula, Marca, Precio, DNI);
      return c1;
    }
}
