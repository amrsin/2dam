
package datos;
import domain.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author singh
 */
public class ClienteDAO {
    
    
    private static final String SQL_SELECT = "SELECT * FROM Cliente"; 
    private static final String SQL_INSERT = "INSERT INTO Cliente VALUES (?,?,?,?,?,?,?)"; 
    private static final String SQL_DELETE = "DELETE FROM Cliente where DNI = ?";
    private static final String SQL_UPDATE = "UPDATE Cliente SET Nombre = ?, Apellidos = ?, Email = ?, Fecha_nacimiento =?, Puntos =?, Saldo =? WHERE DNI = ?";

    private Connection conexionTrasaccional;
     

    public ClienteDAO(Connection conexionTrasaccional) {

        this.conexionTrasaccional = conexionTrasaccional;

    }
    
    public List<Cliente> select() {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente c = null;
        List<Cliente> list_clientes = new ArrayList<>();

        try {
            //get connection si conexionTrasaccional es null
            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_SELECT); //indicamos la consulta a hacer
            rs = stmt.executeQuery(); //ejecutamos la consulta
            //mientras tengamos obejetos en resultSet
            //creando Objeto Usuario y lo agregamos en list_usuarios
            while (rs.next()) {
                
                String DNI = rs.getString("DNI");
                String Nombre = rs.getString("Nombre");
                String Apellidos = rs.getString("Apellidos");
                String Email = rs.getString("Email");
                Date Fecha_nacimiento = rs.getDate("Fecha_nacimiento");
                int puntos = rs.getInt("Puntos");
                double Saldo = rs.getDouble("Saldo");
                c = new Cliente(DNI, Nombre, Apellidos, Email, Fecha_nacimiento, puntos, Saldo);
                list_clientes.add(c);
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
        return list_clientes;
    }
     public int insertar(Cliente c) throws SQLException {

        //var
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            //get connection si conexionTrasaccional es null
            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_INSERT);//consulta
            //identificamos los ? segun la consulta
            stmt.setString(1, c.getDNI());
            stmt.setString(2, c.getNombre());
            stmt.setString(3, c.getApellidos());
            stmt.setString(4, c.getEmail());
            stmt.setDate(5, c.getFecha_nacimineto());
            stmt.setInt(6, c.getPuntos());
            stmt.setDouble(7, c.getSaldos());
            
            registros = stmt.executeUpdate();
           //cerramos la conecion
        } finally {
            try {
                Conexion.close(stmt);//cerramos stmt
                if (conexionTrasaccional == null) {

                    Conexion.close(con);

                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
     public int delete(Cliente c) throws SQLException {

        //var
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_DELETE);//consulta
            //identificamos ? segun la consulta
            stmt.setString(1, c.getDNI());
            registros = stmt.executeUpdate();
           //cerramos la conecion
        } finally {
            try {
                Conexion.close(stmt);//cerramos stmt
                if (conexionTrasaccional == null) {

                    Conexion.close(con);

                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
     public int update(Cliente c) throws SQLException {

        //var
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_UPDATE);//consulta
            //identificamos los ? segun la consulta
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getApellidos());
            stmt.setString(3, c.getEmail());
            stmt.setDate(4, c.getFecha_nacimineto());
            stmt.setInt(5, c.getPuntos());
            stmt.setDouble(6, c.getSaldos());
            stmt.setString(7, c.getDNI());            
            registros = stmt.executeUpdate();
           //cerramos la conecion
        } finally {
            try {
                Conexion.close(stmt);//cerramos stmt
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