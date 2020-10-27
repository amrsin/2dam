package test;

import datos.PersonaDAO;
import domain.Persona;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author singh
 */
public class TestManejo_Personas {
    
    private static PersonaDAO personaDao = new PersonaDAO();


    public static void main(String[] args) throws SQLException {
        
        Scanner sc = new Scanner(System.in);
        int id_persona_dlt;
        int id_persona_up;
        String nombre;
        String apellido;
        String email;
        int edad;
        List<Persona> list_personas;
        list_personas = personaDao.seleccionar();

        
        //insertar persona
        Persona p = new Persona("Carlos", "perez", "carlos@gmail.com", 54);
        System.out.println("Registros ingresados: " + personaDao.insertar(p));
        listar_personas(list_personas);
        //Eliminando persona con determinado id
        System.out.println("-----------------------------------------------------");
        System.out.print("Introduzca el id persona a eliminar: ");
        id_persona_dlt = sc.nextInt();
        Persona p_dlt = new Persona(id_persona_dlt);
        System.out.println("Registro eliminado: " + personaDao.delete(p_dlt));
        listar_personas(list_personas);
        //Actualizar datos persona
        System.out.println("-----------------------------------------------------");
        System.out.print("Introduzca el id persona a actualizar: ");
        id_persona_up = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduzca nombre: ");
        nombre = sc.nextLine();
        System.out.print("Introduzca apellidos: ");
        apellido = sc.nextLine();
        System.out.print("Introduzca email: ");
        email = sc.nextLine();
        System.out.print("Introduzca edad: ");
        edad = sc.nextInt();
       
        Persona p_modificar = new Persona(id_persona_up, nombre, apellido, email, edad);
        
        personaDao.update(p_modificar);
        listar_personas(list_personas);

    }
    
    public static void listar_personas(List<Persona> list_personas) {
        
         list_personas = personaDao.seleccionar();
        
        list_personas.forEach(Persona -> {

            System.out.println("Persona = " + Persona);
        });   
    }
}