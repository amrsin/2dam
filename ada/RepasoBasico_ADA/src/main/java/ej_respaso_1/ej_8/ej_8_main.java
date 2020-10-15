package ej_respaso_1.ej_8;


import ej_respaso_1.ej_8.Contactos;
import ej_respaso_1.ej_8.Calendario;
import java.util.*;
/**
 *
 * @author amrit
 */
public class ej_8_main {

    public static void main(String[] args) {

        ArrayList<Contactos> lista_contactos = new ArrayList<Contactos>();
        Contactos c;
        Scanner sc = new Scanner(System.in);
        int op_menu = 0;

        while (op_menu != 6) {
            System.out.println("-------------------------");
            System.out.println("Bienvenido/a al menu");
            System.out.println("1- Agregar contacto");
            System.out.println("2- Buscar contacto");
            System.out.println("3- Eliminar contacto");
            System.out.println("4- Lista contactos");
            System.out.println("5- Cambiar numero telefono");
            System.out.println("6- Salir");
            System.out.print("Introduzca op_menu: ");
            op_menu = sc.nextInt();
            System.out.println("-------------------------");

            switch (op_menu) {

                case 1:
                    c = alta_contacto(lista_contactos);
                    lista_contactos.add(c);
                    break;
                case 2:
                    buscar_contacto(lista_contactos);
                    break;
                case 3:
                    baja_contacto(lista_contactos);
                    break;
                case 4:
                    listar_contactos(lista_contactos);
                    break;
                case 5:
                    cambiar_num(lista_contactos);
                    break;
                case 6:
                    System.out.println("Gracias por usar el programa");
                    Calendario cl = new Calendario(lista_contactos);
                    break;

            }

        }
    }

    public static Contactos alta_contacto(ArrayList lista_contactos) {

        //var
        Scanner sc = new Scanner(System.in);
        String nom;
        int num_telf;
        //datos user
        System.out.print("Introduzca nombre: ");
        nom = sc.nextLine();
        System.out.print("Introduzca numero de telefono: ");
        num_telf = sc.nextInt();
        Contactos c = new Contactos(nom, num_telf);
        System.out.println("Se ha dado de alta al contacto " + nom);
        return c;
    }

    public static void buscar_contacto(ArrayList lista_contactos) {

        Scanner sc = new Scanner(System.in);
        Iterator iter = lista_contactos.iterator();
        Contactos c;
        String aux_nom;
        String nom;
        boolean encontrado = false;

        System.out.print("Introduza el nombre del contacto: ");
        nom = sc.nextLine();

        while (iter.hasNext()) {

            c = (Contactos) iter.next();
            aux_nom = c.getNom();

            if (aux_nom.equalsIgnoreCase(nom)) {

                System.out.println(c.toString());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El contacto no se ha encontrado");

        }
    }

    public static void baja_contacto(ArrayList lista_contactos) {

        Scanner sc = new Scanner(System.in);
        Iterator iter = lista_contactos.iterator();
        Contactos c;
        String aux_nom;
        String nom;
        boolean encontrado = false;

        System.out.print("Introduza el nombre del contacto: ");
        nom = sc.nextLine();

        while (iter.hasNext()) {

            c = (Contactos) iter.next();
            aux_nom = c.getNom();

            if (aux_nom.equalsIgnoreCase(nom)) {

                lista_contactos.remove(c);
                encontrado = true;
                System.out.println("Se ha dado de baja al contacto " + aux_nom);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El contacto no se ha encontrado");

        }
    }

    public static void listar_contactos(ArrayList lista_contactos) {

        Iterator iter = lista_contactos.iterator();
        Contactos c;

        while (iter.hasNext()) {

            c = (Contactos) iter.next();

            System.out.println(c.toString());

        }
    }

    public static void cambiar_num(ArrayList lista_contactos) {

        Scanner sc = new Scanner(System.in);
        Iterator iter = lista_contactos.iterator();
        Contactos c;
        String aux_nom;
        String nom;
        int num_telf;
        boolean encontrado = false;

        System.out.print("Introduza el nombre del contacto: ");
        nom = sc.nextLine();

        while (iter.hasNext()) {

            c = (Contactos) iter.next();
            aux_nom = c.getNom();

            if (aux_nom.equalsIgnoreCase(nom)) {

                System.out.print("Introduza el nuevo numero de telefono: ");
                num_telf = sc.nextInt();
                c.setNum_telf(num_telf);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El contacto no se ha encontrado");

        }
    }

}
