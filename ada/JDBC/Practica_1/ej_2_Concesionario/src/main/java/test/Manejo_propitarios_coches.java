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

    //metodo main        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = null;
        String DNI = null;
        int op_menu = 0;

        while (op_menu != 11) {
            op_menu = menu();

            switch (op_menu) {

                case 1:
                    insert_propietario();
                    break;
                case 2:
                    insert_coche();
                    break;
                case 3:
                    System.out.print("Introduzca DNI: ");
                    DNI = sc.nextLine();
                    delete_propietario(DNI);
                    break;
                case 4:
                    delete_coche();
                    break;
                case 5:
                    update_propietario();
                    break;
                case 6:
                    update_coche();
                    break;
                case 7:
                    listar_propietarios(list_propietarios);
                    break;
                case 8:
                    listar_coches(list_coches);
                    break;
                case 9:
                    result = listar_por_DNI(list_propietarios, list_coches);
                    if (result != null) {
                        System.out.println(result);
                    }
                    break;
                case 10:
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
        System.out.println("|        1. Insertar nuevo propietario     |");
        System.out.println("|        2. Insertar nuevo coche           |");
        System.out.println("|        3. Eliminar propietario           |");
        System.out.println("|        4. Eliminar coche                 |");
        System.out.println("|        5. Actualizar datos propietario   |");
        System.out.println("|        6. Actualizar datos coche         |");
        System.out.println("|        7. Listar los propietarios        |");
        System.out.println("|        8. Listar los coches              |");
        System.out.println("|        9. Listar por DNI                 |");
        System.out.println("|        10.Salir                          |");
        System.out.println("|------------------------------------------|");
        System.out.print("|        Introduza opcion del menu:        |");
        op_menu = sc.nextInt();
        System.out.println("--------------------------------------------");
        return op_menu;
    }

    //metodo para insertar nuevo registro en bd
    public static void insert_propietario() {
        //var 
        Propietario p1;

        p1 = teclado_propietario(); //llamando metodo teclado
        propietarioDao.insert(p1);//llamando metodo insert donde de verdad agregaremos a la bd el propietario
   
    }

    //metodo para insertar nuevo registro en bd
    public static void insert_coche() {
        //var 
        String DNI;
        boolean existe = false;
        Coche c1;

        c1 = teclado_coche(); //llamando metodo teclado
        DNI = c1.getDNI();
        existe = existe_DNI(list_propietarios, DNI);
        //si existe propietario con DNI proporcionado avanzara para añadir coche
        if (existe) {

          cocheDao.insert(c1);//llamando metodo insert donde de verdad agregaremos a la bd el user
           
        }else {
            System.out.println("No existe el propietario con DNI " + DNI);
        }
    }

    //metodo para eliminar propietario
    public static void delete_propietario(String DNI) {
        //variables
        Scanner sc = new Scanner(System.in);
        String DNI_aux;
        
            list_coches = cocheDao.select();

            for (Coche c : list_coches) {

            DNI_aux = c.getDNI();

            if (DNI.equals(DNI_aux)) {

                cocheDao.delete(c);
            }
        }
        
        //objeto tipo propietario con DNI
        Propietario p1 = new Propietario(DNI);
        propietarioDao.delete(p1);//metodo donde realmente se eliminar el propietario de bd
    }

    //metodo para eliminar coche
    public static void delete_coche() {
        //variables
        Scanner sc = new Scanner(System.in);
        String Matricula;
        //datos por user
        System.out.print("Introduzca matricula: ");
        Matricula = sc.nextLine();
        //objeto tipo coche con matricula
        Coche c1 = new Coche(Matricula);
        cocheDao.delete(c1);//metodo donde realmente se eliminar el coche de bd
    }

    //metodo para actualizaar datos_propietario
    public static void update_propietario() {
        //var
        Propietario p1;

        p1 = teclado_propietario(); //llamando metodo teclado_propietario
        propietarioDao.update(p1);//llamando metodo update donde de verdad actualizaremos datos propietario       
    }

    //metodo para actualizaar datos_coche
    public static void update_coche() {
        //var
        Coche c1;

        c1 = teclado_coche(); //llamando metodo teclado_coche
        cocheDao.update(c1);//llamando metodo update donde de verdad actualizaremos datos coche    
    }

    //listar propietarios actuales en la bd
    public static void listar_propietarios(List<Propietario> list_propietarios) {

        list_propietarios = propietarioDao.select();
        list_propietarios.forEach(Propietario -> {

            System.out.println("Propietario: " + Propietario);
        });
    }

    //listar propietarios actuales en la bd
    public static void listar_coches(List<Coche> list_coches) {

        list_coches = cocheDao.select();
        list_coches.forEach(Coche -> {

            System.out.println("Coche: " + Coche);
        });
    }

    public static String listar_por_DNI(List<Propietario> list_propietarios, List<Coche> list_coches) {

        list_propietarios = propietarioDao.select();
        list_coches = cocheDao.select();

        Scanner sc = new Scanner(System.in);
        String DNI;
        String DNI_aux;
        String result = "";

        System.out.print("Introduzca DNI: ");
        DNI = sc.nextLine();

        for (Propietario p : list_propietarios) {

            DNI_aux = p.getDNI();

            if (DNI.equals(DNI_aux)) {

                result = " Propietario: " + p;

            }
        }

        for (Coche c : list_coches) {

            DNI_aux = c.getDNI();

            if (DNI.equals(DNI_aux)) {

                result = result + " \n\t Coche: " + c;
            }
        }
        return result;
    }

    public static boolean existe_DNI(List<Propietario> list_propietarios, String DNI) {

        list_propietarios = propietarioDao.select();

        String DNI_aux;
        boolean existe = false;

        for (Propietario p : list_propietarios) {

            DNI_aux = p.getDNI();

            if (DNI.equals(DNI_aux)) {
                existe = true;
            }
        }
        return existe;
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