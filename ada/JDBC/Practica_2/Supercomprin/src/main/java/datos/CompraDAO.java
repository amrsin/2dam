package datos;

import domain.Compra;
import java.sql.*;

/**
 *
 * @author singh
 */
public class CompraDAO {
    
    private static final String SQL_INSERT = "INSERT INTO Compra(DNI_cliente, id_producto, Fecha, Puntos, Importe) VALUES (?,?,?,?,?)"; 



   
    private Connection conexionTrasaccional;
     

    public CompraDAO(Connection conexionTrasaccional) {

        this.conexionTrasaccional = conexionTrasaccional;

    }

    //metodo para insertar
    public int insert(Compra c) throws SQLException {

        //var
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_INSERT);//consulta
            //identificamos los ? segun la consulta
            stmt.setString(1, c.getDNI_cliente());
            stmt.setInt(2, c.getId_producto());
            stmt.setDate(3, c.getFehca());
            stmt.setInt(4, c.getPuntos());
            stmt.setDouble(5, c.getImporte());
            
            registros = stmt.executeUpdate();
            //si registros es distinto 0 es que se ha insetado cliente bien, sino algo ha fallado
            if (registros != 0) {

                System.out.println("Se ha agregado a la bd el compra");
            } else {

                System.out.println("Ha habido fallo a la hora de insertar la compra");
            }
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