
package datos;

import domain.Cliente;
import domain.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author singh
 */
public class ProductoDAO {
    
    
    private static final String SQL_SELECT = "SELECT * FROM Producto";
    private static final String SQL_SELECT_ID = "SELECT * FROM Producto WHERE id_producto = ?";
    
    private Connection conexionTrasaccional;

    public ProductoDAO(Connection conexionTrasaccional) {

        this.conexionTrasaccional = conexionTrasaccional;

    }
    
      //metodo para select
    public List<Producto> select() {

        //variable
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto p = null;
        List<Producto> list_producto = new ArrayList<>();
        

        try {
            //get connection si conexionTrasaccional es null
            con = Conexion.getConnection();

            stmt = con.prepareStatement(SQL_SELECT); //indicamos la consulta a hacer
            rs = stmt.executeQuery(); //ejecutamos la consulta
            //mientras tengamos obejetos en resultSet
            //creando Objeto Usuario y lo agregamos en list_usuarios
            while (rs.next()) {

                int id_producto = rs.getInt("id_producto");
                String Nombre = rs.getString("Nombre");
                double Precio = rs.getDouble("Precio");
                int Puntos = rs.getInt("Puntos");
                p = new Producto(Nombre, Precio, Puntos);
                list_producto.add(p);
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
        return list_producto;
    }
    
     //metodo para select segun DNI
    public Producto select_id(int id) {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto p = null;
        

        try {
            //get connection si conexionTrasaccional es null
            con = Conexion.getConnection();

            stmt = con.prepareStatement(SQL_SELECT_ID); //indicamos la consulta a hacer
            stmt.setInt(1, id);
            rs = stmt.executeQuery(); //ejecutamos la consulta
            //mientras tengamos obejetos en resultSet
            //creando Objeto Usuario y lo agregamos en list_usuarios
            while (rs.next()) {

                int id_producto = rs.getInt("id_producto");
                String Nombre = rs.getString("Nombre");
                double Precio = rs.getDouble("Precio");
                int Puntos = rs.getInt("Puntos");
                p = new Producto(Nombre, Precio, Puntos);
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
        return p;
    }
}