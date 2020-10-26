package datos;

import domain.Usuario;
import java.util.*;
import java.sql.*;
/**
 *
 * @author singh
 */
public class UsuarioDAO {

    //consultas sql
    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(id_usuario, user, password) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM usuario where id_usuario = ?";
    private static final String sql_UPDATE = "UPDATE usuario SET user = ?, password = ? WHERE id_usuario = ?";

    public List<Usuario> select() {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario u = null;
        List<Usuario> list_usuarios = new ArrayList<>();

        try {

            con = Conexion.getConnection(); //establecemos connecion con la bd
            stmt = con.prepareStatement(SQL_SELECT); //indicamos la consulta a hacer
            rs = stmt.executeQuery(); //ejecutamos la consulta
            //mientras tengamos obejetos en resultSet
            //creando Objeto Usuario y lo agregamos en list_usuarios
            while (rs.next()) {
                
                int id_usuario = rs.getInt("id_usuario");
                String user = rs.getString("user");
                String password = rs.getString("password");
                u = new Usuario(id_usuario, user, password);
                list_usuarios.add(u);
            }
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
        } finally {

            try {
                
                Conexion.close(con); //cerramos connexion
                Conexion.close(rs); //cerramos resultSet
                Conexion.close(stmt); //cerramos statament

            } catch (SQLException ex) {

                ex.printStackTrace(System.out);

            }
        }
        return list_usuarios;
    }

    public int insert(Usuario u) {
        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = Conexion.getConnection(); //establecemos conexion con bd
            stmt = con.prepareStatement(SQL_INSERT); //indicamos la consulta a hacer
            //indicamos cada ? en orden de la consulta SQL_INSERT
            stmt.setInt(1, u.getId_usuario());
            stmt.setString(2, u.getUsr());
            stmt.setString(3, u.getPassword());
            registros = stmt.executeUpdate(); //ejecutamos quary

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {

                Conexion.close(stmt);
                Conexion.close(con);
                
            } catch (SQLException ex) {

                ex.printStackTrace(System.out);

            }
        }
        return registros;
    }

    public int delete(Usuario u) {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = Conexion.getConnection(); //establecemos conexion con bd
            stmt = con.prepareStatement(SQL_DELETE); //indicamos la consulta a hacer
            stmt.setInt(1, u.getId_usuario()); //indicamos el valor ? en consulta SQL_DELETE
            registros = stmt.executeUpdate(); //ejecutamos quary

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {

                Conexion.close(stmt);  //cerramos statament
                Conexion.close(con); //cerramos connexion

            } catch (SQLException ex) {

                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }
    
     public int update(Usuario u) {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = Conexion.getConnection(); //establecemos connecion con la bd
            stmt = con.prepareStatement(sql_UPDATE); //indicamos la consulta a hacer
            //indicamos cada ? en orden de la consulta SQL_UPDATE
            stmt.setString(1, u.getUsr());
            stmt.setString(2, u.getPassword());
            stmt.setInt(3, u.getId_usuario());

            registros = stmt.executeUpdate(); //ejecutamos quary
  
        } catch (SQLException ex) {           
            ex.printStackTrace(System.out);
        } finally {

            try {
                
                Conexion.close(stmt); //cerramos statament
                Conexion.close(con); //cerramos connexion

            } catch (SQLException ex) {

                ex.printStackTrace(System.out);
            }
        }
        return registros;
     }
}