
package datos;
import domain.Cliente;
import java.sql.*;

/**
 *
 * @author singh
 */
public class ClienteDAO {
    
    private static final String sql_INSERT = "INSERT INTO Cliente VALUES (?,?,?,?,?,?,?)"; 
    private static final String SQL_DELETE = "DELETE FROM Cliente where DNI = ?";
    private static final String sql_UPDATE = "UPDATE Cliente SET Nombre = ?, Apellidos = ?, Email = ?, Fecha_nacimiento =?, Puntos =?, Saldo =? WHERE DNI = ?";

    private Connection conexionTrasaccional;
     

    public ClienteDAO(Connection conexionTrasaccional) {

        this.conexionTrasaccional = conexionTrasaccional;

    }

     public int insertar(Cliente c) throws SQLException {

        //var
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(sql_INSERT);//consulta
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

            stmt = con.prepareStatement(sql_UPDATE);//consulta
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