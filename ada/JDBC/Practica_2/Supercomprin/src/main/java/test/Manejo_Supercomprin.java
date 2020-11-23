package test;

import datos.*;
import domain.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author singh
 */
public class Manejo_Supercomprin {

    private static Connection conexion;
    private static ClienteDAO clientedao;
    private static CompraDAO compradao;
    private static DevuelveDAO devuelvedao;

    public static void main(String[] args) throws SQLException {

        conexion = Conexion.getConnection();
        clientedao = new ClienteDAO(conexion);
        compradao = new CompraDAO(conexion);

        int op_menu = 0;

        while (op_menu != 9) {

            op_menu = menu();

            switch (op_menu) {

                case 1:
                    insert_cliente();
                    break;
                case 2:
                    delete_cliente();
                    break;
                case 3:
                    update_cliente();
                    break;
                case 4:
                    listar_clientes();
                    break;
                case 5:
                    recagar_euros(conexion);
                    break;
                case 6:
                    pagar_compra();
                    break;
                case 7:
                    pagar_con_puntos(conexion);
                    break;
                case 8:
                    devolver_compra();
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
        System.out.println("|        Bienvenido/a Supercomprin         |");
        System.out.println("|------------------------------------------|");
        System.out.println("|        1. Insertar cliente               |");
        System.out.println("|        2. Eliminar cliente               |");
        System.out.println("|        3. Actualizar datos               |");
        System.out.println("|        4. Listar los cliente             |");
        System.out.println("|        5. Recargar euros                 |");
        System.out.println("|        6. Pagar compra                   |");
        System.out.println("|        7. Pagar compra con puntos        |");
        System.out.println("|        8. Devolver producto              |");
        System.out.println("|        9. Salir                          |");
        System.out.println("|------------------------------------------|");
        System.out.print("|        Introduza opcion del menu:        |");
        op_menu = sc.nextInt();
        System.out.println("--------------------------------------------");
        return op_menu;
    }

    //metodo para insertar nuevo cliente en bd
    public static void insert_cliente() throws SQLException {

        try {
            //var 
            Cliente c1;

            c1 = teclado_cliente("insert"); //llamando metodo teclado_cliente
            clientedao.insert(c1);//llamando metodo insert donde de verdad agregaremos a la bd el cliente

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        }

    }

    //metodo para eliminar cliente de bd
    public static void delete_cliente() throws SQLException {

        try {
            //var 
            Scanner sc = new Scanner(System.in);
            Cliente c1;
            String DNI = null;
            boolean existe_dni = false;
            //dato necesario por user
            while (!existe_dni) {

                System.out.print("Introduzca el DNI: ");
                DNI = sc.nextLine();
                existe_dni = existe_DNI(DNI);

                if (!existe_dni) {
                    System.out.print("El DNI " + DNI + " no existe en la bd |");
                }
            }

            c1 = new Cliente(DNI); //Creamos cliente con DNI introducido por user
            clientedao.delete(c1);//llamando metodo delete donde de verdad eliminaremos de la bd el cliente

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //metodo para actualizar datos cliente
    public static void update_cliente() throws SQLException {
        try {
            //var    
            Cliente c1;

            c1 = teclado_cliente("update"); //llamando metodo teclado_cliente
            clientedao.update(c1);//llamando metodo update donde de verdad actulizamos datos cliente

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //metodo para listar_clientes
    public static void listar_clientes() {

        List<Cliente> list_cliente;
        list_cliente = clientedao.select();
        list_cliente.forEach(Cliente -> {

            System.out.println("Cliente: " + Cliente);
        });
    }

    public static boolean existe_DNI(String DNI) {

        List<Cliente> list_cliente;
        list_cliente = clientedao.select();

        String DNI_aux;
        boolean existe = false;

        for (Cliente c : list_cliente) {

            DNI_aux = c.getDNI();

            if (DNI.equals(DNI_aux)) {
                existe = true;
            }
        }
        return existe;
    }

    //metodo para pagar compra con euros
    public static void pagar_compra() throws SQLException {

        try {
            //var 
            Compra compra_1;

            compra_1 = (Compra) teclado_compra_devuelve("compra"); //llamando metodo teclado_compra_devuelve
            compradao.insert(compra_1);//llamando metodo insert donde de verdad agregaremos a la bd la compra

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //metodo para pagar compra con puntos 
    public static void pagar_con_puntos(Connection con) {
        //var
        Compra compra_1;
        Cliente c_aux;
        boolean transaction_ok = false;

        try {
            //autocommit a false
            if (con.getAutoCommit()) {

                con.setAutoCommit(false);

            }
            compra_1 = (Compra) teclado_compra_devuelve("compra");//llamamos al metodo teclado_compra_devuelve en el cual el usaurio introducira datos 
            compradao.insert(compra_1);//insert de la compra  
            c_aux = new Cliente(compra_1.getDNI_cliente());//cliente con el DNI de la compra
            c_aux = clientedao.select_DNI(c_aux);//cogemos todos los datos del cliente con el DNI que tenga la compra

            //si la compra es mayor de 5 euros            
            if (compra_1.getImporte() > 5) {
                //si la resta de puntos es mayor a 5 
                if (c_aux.getPuntos() - compra_1.getPuntos() > 5) {
                    c_aux.setPuntos(c_aux.getPuntos() - compra_1.getPuntos());
                    clientedao.update_puntos(c_aux);
                    con.commit();
                    transaction_ok = true;
                    System.out.println("Se ha hecho el commit");
                }
            }
            //si no se ha hecho bien la transaction hacemos rollback
            if (!transaction_ok) {
                con.rollback();
                System.out.println("Entramos al rollback, la compra tiene que ser superior a 5 euros y al hacer resta puntos tiene que haber 5 puntos");
            }

        } catch (SQLException e) {

            e.printStackTrace(System.out);
        }
    }

    //metodo para devolver compra
    public static void devolver_compra() throws SQLException {

        try {
            //var 
            Devuelve devuelve_1;

            devuelve_1 = (Devuelve) teclado_compra_devuelve("devuelve"); //llamando metodo teclado_compra_devuelve
            devuelvedao.insert(devuelve_1);//llamando metodo insert donde de verdad agregaremos a la bd la compra

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //metodo para pagar compra con puntos 
    public static void recagar_euros(Connection con) {
        //var
        Scanner sc = new Scanner(System.in);
        Cliente c;
        String DNI = null;
        Boolean existe = false;
        double recarga;
        boolean transaction_ok = false;
        Calendar fecha = Calendar.getInstance();

        //dato necesario por user
        while (!existe) {

            System.out.print("Introduzca el DNI: ");
            DNI = sc.nextLine();
            existe = existe_DNI(DNI);

            if (!existe) {
                System.out.print("El DNI " + DNI + " no existe en la bd |");
            }
        }

        System.out.print("Introduzca cantidad a recargar: ");
        recarga = sc.nextDouble();

        try {
            //autocommit a false
            if (con.getAutoCommit()) {

                con.setAutoCommit(false);
            }
            c = new Cliente(DNI);//cliente con el DNI recibido por teclado
            c = clientedao.select_DNI(c);//cogemos todos los datos del cliente con el DNI introducido user
            c.setSaldos(c.getSaldos() + recarga);
            clientedao.update_saldo(c);

            //si dia mes esta entre 1 y 5            
            if (fecha.get(Calendar.DAY_OF_MONTH) <= 5) {

                con.commit();
                transaction_ok = true;
                System.out.println("Se ha hecho el commit");
            }
            //si no se ha hecho bien la transaction hacemos rollback
            if (!transaction_ok) {
                con.rollback();
                System.out.println("Entramos al rollback, solo se puede recargar entre el dia 1 - 5 del mes");
            }
        } catch (SQLException e) {

            e.printStackTrace(System.out);
        }
    }

    //metodo para leer datos cliente por teclado
    public static Cliente teclado_cliente(String aux) {
        //variables
        Scanner sc = new Scanner(System.in);
        String DNI = null;
        Boolean existe_dni = false;
        String Nombre;
        String Apellidos;
        String Email;
        String Fecha_nacimiento_str;
        Date Fecha_nacimiento = null;
        Cliente c1 = null;

        boolean fecha_bien = false;

        //datos requeridos por user
        if (aux.equals("update")) {
            
            while (!existe_dni) {

            System.out.print("Introduzca el DNI: ");
            DNI = sc.nextLine();
            existe_dni = existe_DNI(DNI);

            if (!existe_dni) {
                System.out.print("El DNI " + DNI + " no existe en la bd |");
            }
        }   
      }
        if (aux.equals("insert")) {
            
            System.out.print("Introduzca el DNI: ");
            DNI = sc.nextLine();    
        }
        
        System.out.print("Introduzca Nombre: ");
        Nombre = sc.nextLine();

        System.out.print("Introduzca Apellidos: ");
        Apellidos = sc.nextLine();

        System.out.print("Introduzca Email: ");
        Email = sc.nextLine();
        while (!fecha_bien) {
            try {
                System.out.print("Introduzca Fecha nacimiento (yyyy-mm-dd): ");
                Fecha_nacimiento_str = sc.nextLine();
                Fecha_nacimiento = Date.valueOf(Fecha_nacimiento_str);
                fecha_bien = true;

            } catch (Exception e) {

            }
        }
        if (fecha_bien) {
            //creando nuevo objeto de tipo cliente con los datos proporcionados por teclado
            c1 = new Cliente(DNI, Nombre, Apellidos, Email, Fecha_nacimiento);
        }
        return c1;
    }

    //leer por teclado datos compra o devulve por teclado
    public static Object teclado_compra_devuelve(String aux) {
        //variables
        Scanner sc = new Scanner(System.in);
        String DNI_cliente = null;
        boolean existe_dni = false;
        int id_producto;
        String Fecha_str;
        int Puntos;
        double Importe;
        Date Fecha = null;
        Object ob_aux = null;
        Compra compra_1 = null;
        Devuelve devuelve_1 = null;

        //datos requeridos por user
        while (!existe_dni) {

            System.out.print("Introduzca el DNI: ");
            DNI_cliente = sc.nextLine();
            existe_dni = existe_DNI(DNI_cliente);

            if (!existe_dni) {
                System.out.print("El DNI " + DNI_cliente + " no existe en la bd |");
            }
        }

        System.out.print("Introduzca id_producto: ");
        id_producto = sc.nextInt();
        sc.nextLine();

        LocalDate now = LocalDate.now();
        Fecha = Date.valueOf(now);

        System.out.print("Introduzca Puntos: ");
        Puntos = sc.nextInt();

        System.out.print("Introduzca Importe: ");
        Importe = sc.nextDouble();

        //creando nuevo objeto de tipo compra con los datos proporcionados por teclado
        if (aux.equals("compra")) {

            compra_1 = new Compra(DNI_cliente, id_producto, Fecha, Puntos, Importe);
            ob_aux = compra_1;
        }

        if (aux.equals("devuelve")) {

            devuelve_1 = new Devuelve(DNI_cliente, id_producto, Fecha, Puntos, Importe);
            ob_aux = devuelve_1;
        }

        return ob_aux;
    }
}