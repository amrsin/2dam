package test;

import domain.Usuario;
import datos.UsuarioDAO;
import java.util.*;

/**
 *
 * @author singh
 */
public class Manejo_Usuarios {

    private static List<Usuario> list_usuarios;
    private static UsuarioDAO usuarioDao = new UsuarioDAO();

    public static void main(String[] args) {


        int op_menu = 0;

        while (op_menu != 5) {

            op_menu = menu();

            switch (op_menu) {

                case 1:
                    insert_new_user();
                    break;
                case 2:
                    delete_user();
                    break;
                case 3:
                    update_user();
                    break;
                case 4:
                    listar_usuarios(list_usuarios);
                    break;
                case 5:
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
        System.out.println("|        1.Insertar nuevo usuario          |");
        System.out.println("|        2.Eliminar usuario                |");
        System.out.println("|        3.Actualizar datos                |");
        System.out.println("|        4.Listar los usuarios             |");
        System.out.println("|        5.Salir                           |");
        System.out.println("|------------------------------------------|");
        System.out.print("|        Introduza opcion del menu:        |");
        op_menu = sc.nextInt();
        System.out.println("--------------------------------------------");
        return op_menu;
    }

    //metodo para insertar nuevo registro en bd
    public static void insert_new_user() {
        //var 
        int registros;
        Usuario u1;

        u1 = teclado(); //llamando metodo teclado
        registros = usuarioDao.insert(u1);//llamando metodo insert donde de verdad agregaremos a la bd el user
        
        //si registros es distinto 0 es que se ha insetado user bien, sino algo ha fallado
        if (registros != 0) {

            System.out.println("Se ha agregado a la bd el user con nombre " + u1.getUsr());
        } else {

            System.out.println("Ha habido fallo a la hora de insertar el user");
        }
    }

    //metodo para elimanr usr
    public static void delete_user() {
        //variables
        Scanner sc = new Scanner(System.in);
        int id_usuario;
        int registros;
        //datos por user
        System.out.print("Introduzca id_usuario: ");
        id_usuario = sc.nextInt();
        //objeto tipo user con id
        Usuario u1 = new Usuario(id_usuario);
        registros = usuarioDao.delete(u1);//metodo donde realmente se eliminar el user de bd
        
        //si registros es distinto 0 es que se ha eliminado user bien, sino algo ha fallado
        if (registros != 0) {

            System.out.println("Se ha eliminado de la bd el user con id " + id_usuario);
        } else {

            System.out.println("Ha habido fallo a la hora de eliminar el user");
        }
    }

    public static void update_user() {
        //var
        int registros;
        Usuario u1;

        u1 = teclado(); //llamando metodo teclado
        registros = usuarioDao.update(u1);//llamando metodo update donde de verdad actualizaremos datos user
        
        //si registros es distinto 0 es que se ha actualizado user bien ,sino algo ha fallado
        if (registros != 0) {

            System.out.println("Se ha actualizado datos user con nombre " + u1.getUsr());
        } else {

            System.out.println("Ha habido fallo a la hora de actualizar el user");
        }
    }

    //listar usuarios actuales en la bd
    public static void listar_usuarios(List<Usuario> list_usuarios) {

        list_usuarios = usuarioDao.select();
        list_usuarios.forEach(Usuario -> {

            System.out.println("Usuario = " + Usuario);
        });
    }
    //metodo para crear objeto tipo Usuario con los datos introducidos por user 
    public static Usuario teclado() {
        //variables
        Scanner sc = new Scanner(System.in);
        int id_usuario;
        String usr;
        String password;
        //datos requeridos por user
        System.out.print("Introduzca id_usuario: ");
        id_usuario = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduzca user: ");
        usr = sc.nextLine();

        System.out.print("Introduzca password: ");
        password = sc.nextLine();
        //creando nuevo objeto de tipo usr con los datos proporcionados por teclado
        Usuario u1 = new Usuario(id_usuario, usr, password);
        
      return u1;
    }
}