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

    public static void main(String[] args) throws SQLException {

        PersonaDAO personaDao = new PersonaDAO();

        Persona p = new Persona("Carlos", "perez", "carlos@gmail.com", 54);
        System.out.println(personaDao.insertar(p));

        List<Persona> list_personas = personaDao.seleccionar();
        list_personas.forEach(Persona -> {

            System.out.println("Persona = " + Persona);
        });
        
        //poner el id adecuado a la hora de ejecutar
        
        /*Persona p1 = new Persona(9);
        System.out.println(personaDao.delete(p1));
        list_personas = personaDao.seleccionar();

        list_personas.forEach(Persona -> {

            System.out.println("Persona = " + Persona);
        });*/

    }
}