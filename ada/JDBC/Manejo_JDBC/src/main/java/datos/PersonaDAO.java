package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author singh
 */
public class PersonaDAO {

    private static final String sql_SELECT = "Select id_persona, nombre, apellidos, edad, email FROM persona";
    private static final String sql_INSERT = "INSERT INTO persona(nombre, apellidos,email,edad) VALUES (?,?,?,?)";
    private static final String sql_DELETE = "DELETE FROM persona where id_persona = ?";

    public List<Persona> seleccionar() throws SQLException {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> list_personas = new ArrayList<>();

        try {

            con = getConnection();
            stmt = con.prepareStatement(sql_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id_persona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                int edad = rs.getInt("edad");
                persona = new Persona(id_persona, nombre, apellidos, email, edad);
                list_personas.add(persona);

            }

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);

        } finally {

            Conexion.close(con);
            Conexion.close(rs);
            Conexion.close(stmt);

        }
        return list_personas;

    }

    public int insertar(Persona p) {

        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_INSERT);
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getApellidos());
            stmt.setString(3, p.getEmail());
            stmt.setInt(4, p.getEdad());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);

        } finally {
            try {
                close(stmt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int delete(Persona p) {

        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {

            con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_DELETE);
            stmt.setInt(1, p.getId_persona());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        } finally {

            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {

                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}