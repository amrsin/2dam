package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.*;

/**
 *
 * @author singh
 */
public class TestManejo_Personas {

    public static void main(String[] args) throws SQLException {

        Connection conexion = Conexion.getConnection();

        try {
            
            if (conexion.getAutoCommit()) {

                conexion.setAutoCommit(false);

            }

            PersonaDAO personaDao = new PersonaDAO(conexion);

            Persona cambioPersona = new Persona();
            cambioPersona.setId_persona(2);
            cambioPersona.setNombre("Karla Ivonne11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
            cambioPersona.setApellidos("Gomez");
            cambioPersona.setEmail("kgomez@mail.com");
            personaDao.update(cambioPersona);
            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Carlos");
            nuevaPersona.setApellidos("Ramirez");
            nuevaPersona.setEmail("Carlos@gmail.com");
            personaDao.insertar(nuevaPersona);
            
            Persona cambioPersona2 = new Persona();
            cambioPersona2.setId_persona(20);
            cambioPersona2.setNombre("Karla Ivonne");
            cambioPersona2.setApellidos("Gomez");
            cambioPersona2.setEmail("kgomez@mail.com");
            personaDao.update(cambioPersona2);
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
           
            
        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");

            try {
                conexion.rollback();
            } catch (SQLException ex1) {

                ex1.printStackTrace(System.out);

            }
        }

    }
}