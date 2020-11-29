package datos;


import domain.Compra_puntos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author singh
 */
public class Compra_puntosDAO {
    
    private static final String SQL_SELECT = "SELECT * FROM Compra_puntos";
    private static final String SQL_INSERT = "INSERT INTO compra_puntos(DNI_cliente, id_producto, Fecha, Puntos, Importe) VALUES (?,?,?,?,?)"; 

    private Connection conexionTrasaccional;
     

    public Compra_puntosDAO(Connection conexionTrasaccional) {

        this.conexionTrasaccional = conexionTrasaccional;

    }
    
     //metodo para hacer select y guardar los datos en list
    public List<Compra_puntos> select() {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Compra_puntos c = null;
        List<Compra_puntos> list_compra_puntos = new ArrayList<>();

        try {
           //get connection si conexionTrasaccional es null
             con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_SELECT); //indicamos la consulta a hacer
            rs = stmt.executeQuery(); //ejecutamos la consulta
            //mientras tengamos obejetos en resultSet
            //creando Objeto Usuario y lo agregamos en list_compra_puntos
            while (rs.next()) {
                
                int id_compra = rs.getInt("id_compra");
                String DNI_cliente = rs.getString("DNI_cliente");
                int id_producto = rs.getInt("id_producto");
                Date Fecha = rs.getDate("Fecha");
                int puntos = rs.getInt("Puntos");
                double Importe = rs.getDouble("Importe");
                c = new Compra_puntos(id_compra, DNI_cliente, id_producto, Fecha, puntos, Importe);
                list_compra_puntos.add(c);
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
        return list_compra_puntos;
    }


    //metodo para insertar
    public int insert(Compra_puntos c) throws SQLException {

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
            stmt.setString(1, c.getDNI_cliente());
            stmt.setInt(2, c.getId_producto());
            stmt.setDate(3, c.getFecha());
            stmt.setInt(4, c.getPuntos());
            stmt.setDouble(5, c.getImporte());
            
            registros = stmt.executeUpdate();
            //si registros es distinto 0 es que se ha insetado cliente bien, sino algo ha fallado
            if (registros != 0) {

                System.out.println("Se ha agregado a la bd la compra con puntos");
            } else {

                System.out.println("Ha habido fallo a la hora de insertar la compra con puntos");
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