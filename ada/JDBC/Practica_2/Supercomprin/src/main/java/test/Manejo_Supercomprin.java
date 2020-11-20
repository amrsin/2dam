package test;

import datos.ClienteDAO;
import datos.CompraDAO;
import datos.Conexion;
import domain.Cliente;
import domain.Compra;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author singh
 */
public class Manejo_Supercomprin {

    private static Connection conexion;
    private static ClienteDAO clientedao = new ClienteDAO(conexion);
    private static CompraDAO compradao = new CompraDAO(conexion);

    public static void main(String[] args) throws SQLException {

        Connection conexion = Conexion.getConnection();

        int op_menu = 0;

        try {

            while (op_menu != 8) {

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
                        pagar_compra();
                        break;
                    case 6:
                        pagar_con_puntos(conexion);
                        break;
                    case 7:
                        
                        break;
                    case 8:
                        System.out.println("Gracias por usar el menu");
                        break;
                    default:
                        System.out.println("La opcion menu no es valida intente de nuevo, porfavor");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

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
        System.out.println("|        5. Pagar compra                   |");
        System.out.println("|        6. Pagar compra con puntos        |");
        System.out.println("|        7. Devolver producto              |");
        System.out.println("|        8. Salir                          |");
        System.out.println("|------------------------------------------|");
        System.out.print("|        Introduza opcion del menu:        |");
        op_menu = sc.nextInt();
        System.out.println("--------------------------------------------");
        return op_menu;
    }
    //metodo para insertar nuevo registro en bd

    public static void insert_cliente() throws SQLException {
        //var 
        Cliente c1;

        c1 = teclado_cliente(); //llamando metodo teclado_cliente
        clientedao.insert(c1);//llamando metodo insert donde de verdad agregaremos a la bd el cliente

    }

    public static void delete_cliente() throws SQLException {
        //var 
        Scanner sc = new Scanner(System.in);
        Cliente c1;
        String DNI;
        //dato necesario por user
        System.out.print("Introduzca DNI: ");
        DNI = sc.nextLine();

        c1 = new Cliente(DNI); //Creamos cliente con DNI introducido por user
        clientedao.delete(c1);//llamando metodo delete donde de verdad eliminaremos de la bd el cliente

    }

    public static void update_cliente() throws SQLException {
        //var 
        Cliente c1;

        c1 = teclado_cliente(); //llamando metodo teclado_cliente
        clientedao.update(c1);//llamando metodo update donde de verdad actulizamos datos cliente

    }

    public static void listar_clientes() {

        List<Cliente> list_cliente;
        list_cliente = clientedao.select();
        list_cliente.forEach(Cliente -> {

            System.out.println("Cliente: " + Cliente);
        });
    }

    public static void pagar_compra() throws SQLException {
        
         //var 
        Compra compra_1;

        compra_1 = teclado_compra(); //llamando metodo teclado_compra
        compradao.insert(compra_1);//llamando metodo insert donde de verdad agregaremos a la bd la compra
        

    }

    //metodo para pagar con puntos 
    public static void pagar_con_puntos(Connection con) {
        //var
        Compra compra_1;
        Cliente c_aux;
        
        try {
            //autocommit a false
            if (con.getAutoCommit()) {
                
                System.out.println("conexion es : " + con.getAutoCommit());
                con.setAutoCommit(false);
               System.out.println("conexion es : " + con.getAutoCommit());


            }
            compra_1 = teclado_compra();//llamamos al metodo teclado_compra en el cual el usaurio introducira datos 
            compradao.insert(compra_1);//insert de la compra 
            System.out.println("importe " + compra_1.getImporte());
          

            c_aux = new Cliente(compra_1.getDNI_cliente());//cliente con el DNI de la compra
            c_aux = clientedao.select_DNI(c_aux);//cogemos todos los datos del cliente con el DNI que tenga la compra
            //si la compra es mayor de 5 euros
            if (compra_1.getImporte() < 5) {
                System.out.println("mayor 5");
                //si la resta de puntos es menos a 5 
                if (c_aux.getPuntos() - compra_1.getPuntos() < 5) {
                    System.out.println("estoy aqui");
                    //entramos rollback
                   // try {
                        con.rollback();
                        System.out.println("Entramos al rollback ya que la resta de putos es menos a 5");
                    //} catch (SQLException ex1) {
                       // ex1.printStackTrace(System.out);
                    //}
                    //sino insertamos en la tabla y actualizamos saldo / puntos
                }else {
                   System.out.println("Se ha hecho el commit");
                   c_aux.setPuntos(c_aux.getPuntos() - compra_1.getPuntos());
                   clientedao.update_puntos(c_aux);
                   conexion.commit();
                }
            }


        } catch (SQLException e) {
            
            e.printStackTrace(System.out);

        }
    }

    public static Cliente teclado_cliente() {
        //variables
        Scanner sc = new Scanner(System.in);
        String DNI;
        String Nombre;
        String Apellidos;
        String Email;
        String Fecha_nacimiento_str;
        Date Fecha_nacimiento = null;
        Cliente c1 = null;

        boolean fecha_bien = false;

        //datos requeridos por user
        System.out.print("Introduzca DNI: ");
        DNI = sc.nextLine();

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

    public static Compra teclado_compra() {
        //variables
        Scanner sc = new Scanner(System.in);
        String DNI_cliente;
        int id_producto;
        String Fecha_str;
        int Puntos;
        double Importe;
        Date Fecha = null;
        Compra compra_1 = null;
        boolean fecha_bien = false;

        //datos requeridos por user
        System.out.print("Introduzca DNI_cliente: ");
        DNI_cliente = sc.nextLine();

        System.out.print("Introduzca id_producto: ");
        id_producto = sc.nextInt();
        sc.nextLine();
        
        while (!fecha_bien) {
            try {

                System.out.print("Introduzca Fecha (yyyy-mm-dd): ");
                Fecha_str = sc.nextLine();
                Fecha = Date.valueOf(Fecha_str);
                fecha_bien = true;

            } catch (Exception e) {

            }
        }

        System.out.print("Introduzca Puntos: ");
        Puntos = sc.nextInt();

        System.out.print("Introduzca Importe: ");
        Importe = sc.nextDouble();
        if (fecha_bien) {
            //creando nuevo objeto de tipo compra con los datos proporcionados por teclado

            compra_1 = new Compra(DNI_cliente, id_producto, Fecha, Puntos, Importe);
        }
        return compra_1;
    }
}
