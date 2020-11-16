package datos;

import domain.Compra;
import java.sql.*;

/**
 *
 * @author singh
 */
public class CompraDAO {
    
    private static final String sql_INSERT = "INSERT INTO Compra VALUES (?,?,?,?,?)"; 
    private Connection conexionTrasaccional;
     

    public CompraDAO(Connection conexionTrasaccional) {

        this.conexionTrasaccional = conexionTrasaccional;

    }

     public int insertar(Compra c) throws SQLException {

        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(sql_INSERT);
            stmt.setString(1, c.getDNI_cliente());
            stmt.setInt(2, c.getId_producto());
            stmt.setDate(3, c.getFehca());
            stmt.setInt(4, c.getPuntos());
            stmt.setDouble(5, c.getImporte());
            
            registros = stmt.executeUpdate();

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
}