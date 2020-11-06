package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.util.*;
import java.sql.*;

/**
 *
 * @author singh
 */
public class PersonaDAO {

    private static final String sql_SELECT = "Select id_persona, nombre, apellidos, edad, email FROM persona";
    private static final String sql_INSERT = "INSERT INTO persona(nombre, apellidos,email,edad) VALUES (?,?,?,?)";
    private static final String sql_DELETE = "DELETE FROM persona where id_persona = ?";
    private static final String sql_UPDATE = "UPDATE persona SET nombre = ?, apellidos = ?, email = ?, edad = ? "
            + "WHERE id_persona = ?";
    private Connection conexionTrasaccional;

    public PersonaDAO(Connection conexionTrasaccional) {

        this.conexionTrasaccional = conexionTrasaccional;

    }
    
   
    
    public List<Persona> seleccionar() {
        
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> list_personas = new ArrayList<>();

        try {
            
            con = this.conexionTrasaccional!=null ? 
            this.conexionTrasaccional : Conexion.getConnection();
            //con = getConnection();
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
            try {

                Conexion.close(rs);
                Conexion.close(stmt);
                if (conexionTrasaccional == null) {
                    
                    Conexion.close(con);
                    
                }

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return list_personas;

    }

    public int insertar(Persona p) {

        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = this.conexionTrasaccional!=null ? 
            this.conexionTrasaccional : Conexion.getConnection();
            //con = Conexion.getConnection();
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
                Conexion.close(stmt);
                if (conexionTrasaccional == null) {
                    
                    Conexion.close(con);
                    
                }
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

            con = this.conexionTrasaccional!=null ? 
            this.conexionTrasaccional : Conexion.getConnection();
            //con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_DELETE);
            stmt.setInt(1, p.getId_persona());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        } finally {

            try {
                Conexion.close(stmt);
               if (conexionTrasaccional == null) {
                    
                    Conexion.close(con);
                    
                }
            } catch (SQLException ex) {

                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int update(Persona p) {

        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = this.conexionTrasaccional!=null ? 
            this.conexionTrasaccional : Conexion.getConnection();
            //con = Conexion.getConnection();
            stmt = con.prepareStatement(sql_UPDATE);
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getApellidos());
            stmt.setString(3, p.getEmail());
            stmt.setInt(4, p.getEdad());
            stmt.setInt(5, p.getId_persona());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        }finally {

            try {
                Conexion.close(stmt);
               if (conexionTrasaccional == null) {
                    
                    Conexion.close(con);
                    
                }
            } catch (SQLException ex) {

                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
