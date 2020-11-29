package datos;

import domain.Devuelve;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author singh
 */
public class DevuelveDAO {

    private static final String SQL_SELECT = "SELECT * FROM Devuelve";
    private static final String SQL_INSERT = "INSERT INTO Devuelve(DNI_cliente, id_producto, Fecha, Puntos, Importe) VALUES (?,?,?,?,?)";
    private Connection conexionTrasaccional;

    public DevuelveDAO(Connection conexionTrasaccional) {

        this.conexionTrasaccional = conexionTrasaccional;

    }
    
     //metodo para hacer select y guardar los datos en list
    public List<Devuelve> select() {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Devuelve d = null;
        List<Devuelve> list_devuelve = new ArrayList<>();

        try {
            //get connection si conexionTrasaccional es null
            con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();
            
            stmt = con.prepareStatement(SQL_SELECT); //indicamos la consulta a hacer
            rs = stmt.executeQuery(); //ejecutamos la consulta
            //mientras tengamos obejetos en resultSet
            //creando Objeto Usuario y lo agregamos en list_devuelve
            while (rs.next()) {
                
                int id_devuelve = rs.getInt("id_devuelve");
                String DNI_cliente = rs.getString("DNI_cliente");
                int id_producto = rs.getInt("id_producto");
                Date Fecha = rs.getDate("Fecha");
                int puntos = rs.getInt("Puntos");
                double Importe = rs.getDouble("Importe");
                d = new Devuelve(id_devuelve, DNI_cliente, id_producto, Fecha, puntos, Importe);
                list_devuelve.add(d);
            }
        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        } finally {

            try {

                Conexion.close(rs); //cerramos resultSet
                Conexion.close(stmt); //cerramos statament
               if (conexionTrasaccional == null) {

                    Conexion.close(con);

                }

            } catch (SQLException ex) {

                ex.printStackTrace(System.out);

            }
        }
        return list_devuelve;
    }
   

    //metodo para insertar
    public int insert(Devuelve d) throws SQLException {

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
            stmt.setString(1, d.getDNI_cliente());
            stmt.setInt(2, d.getId_producto());
            stmt.setDate(3, d.getFecha());
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