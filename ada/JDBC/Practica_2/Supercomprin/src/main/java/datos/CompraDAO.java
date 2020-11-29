package datos;

import domain.Compra;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author singh
 */
public class CompraDAO {
    
    private static final String SQL_SELECT_id = "Select * from Compra where DNI_cliente = ? and id_producto = ?";
    private static final String SQL_SELECT = "SELECT * FROM Compra";
    private static final String SQL_INSERT = "INSERT INTO Compra(DNI_cliente, id_producto, Fecha, Puntos, Importe) VALUES (?,?,?,?,?)"; 

    private Connection conexionTrasaccional;
     

    public CompraDAO(Connection conexionTrasaccional) {

        this.conexionTrasaccional = conexionTrasaccional;

    }

     //metodo para hacer select y guardar los datos en list
    public List<Compra> select() {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Compra c = null;
        List<Compra> list_compra = new ArrayList<>();

        try {
            //get connection si conexionTrasaccional es null
             con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_SELECT); //indicamos la consulta a hacer
            rs = stmt.executeQuery(); //ejecutamos la consulta
            //mientras tengamos obejetos en resultSet
            //creando Objeto Usuario y lo agregamos en list_compra
            while (rs.next()) {
                
                int id_compra = rs.getInt("id_compra");
                String DNI_cliente = rs.getString("DNI_cliente");
                int id_producto = rs.getInt("id_producto");
                Date Fecha = rs.getDate("Fecha");
                int puntos = rs.getInt("Puntos");
                double Importe = rs.getDouble("Importe");
                c = new Compra(id_compra, DNI_cliente, id_producto, Fecha, puntos, Importe);
                list_compra.add(c);
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
        return list_compra;
    }
   
     //metodo para selecte segun id
    public boolean select_id(Compra c_aux) {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean exite_compra = false;
        

        try {
            //get connection si conexionTrasaccional es null
             con = this.conexionTrasaccional != null
                    ? this.conexionTrasaccional : Conexion.getConnection();

            stmt = con.prepareStatement(SQL_SELECT_id); //indicamos la consulta a hacer
            stmt.setString(1, c_aux.getDNI_cliente());
            stmt.setInt(2, c_aux.getId_producto());
            rs = stmt.executeQuery(); //ejecutamos la consulta
            if (rs.next()) {
                exite_compra = true;
                
            }
        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        } finally {

            try {

                Conexion.close(rs); //cerramos resultSet
                Conexion.close(stmt);//cerramos stmt
                if (conexionTrasaccional == null) {

                    Conexion.close(con);
                }

            } catch (SQLException ex) {

                ex.printStackTrace(System.out);

            }
        }
        return exite_compra;
    }

    //metodo para insertar
    public int insert(Compra c) throws SQLException {

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

                System.out.println("Se ha agregado a la bd la compra");
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