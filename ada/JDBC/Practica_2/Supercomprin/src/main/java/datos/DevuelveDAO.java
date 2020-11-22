package datos;

import domain.Devuelve;
import java.sql.*;

/**
 *
 * @author singh
 */
public class DevuelveDAO {

    private static final String SQL_INSERT = "INSERT INTO Compra(DNI_cliente, id_producto, Fecha, Puntos, Importe) VALUES (?,?,?,?,?)";
    private Connection conexionTrasaccional;

    public DevuelveDAO(Connection conexionTrasaccional) {

        this.conexionTrasaccional = conexionTrasaccional;

    }

    //metodo para insertar
    public int insert(Devuelve d) throws SQLException {

        //var
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_INSERT);//consulta
            //identificamos los ? segun la consulta
            stmt.setString(1, d.getDNI_cliente());
            stmt.setInt(2, d.getId_producto());
            stmt.setDate(3, d.getFehca());
            stmt.setInt(4, d.getPuntos());
            stmt.setDouble(5, d.getImporte());

            registros = stmt.executeUpdate();
            //si registros es distinto 0 es que se ha insetado cliente bien, sino algo ha fallado
            if (registros != 0) {

                System.out.println("Se ha agregado a la bd lo devuelto");
            } else {

                System.out.println("Ha habido fallo a la hora de insertar devuelve");
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