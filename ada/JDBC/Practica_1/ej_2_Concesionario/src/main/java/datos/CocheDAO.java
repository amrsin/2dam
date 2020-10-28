package datos;

import domain.Coche;
import java.sql.*;
import java.util.*;

/**
 *
 * @author singh
 */
public class CocheDAO {

    //consultas sql
    private static final String SQL_SELECT = "SELECT * FROM coches";
    private static final String SQL_INSERT = "INSERT INTO coches VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM coches WHERE Matricula = ?";
    private static final String sql_UPDATE = "UPDATE coches SET Marca = ?, Precio = ?, DNI = ? WHERE Matricula = ?";

    public List<Coche> select() {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Coche c;
        List<Coche> list_coches = new ArrayList<>();

        try {

            con = Conexion.getConnection(); //establecemos conexion con la bd
            stmt = con.prepareStatement(SQL_SELECT); //indicamos la consulta a hacer
            rs = stmt.executeQuery(); //ejecutamos consulta

            //mientras tengamos obejetos en resultSet
            while (rs.next()) {
                //Creamos Objeto Coche y lo agregamos en list_coches
                String Matricula = rs.getString("Matricula");
                String Marca = rs.getString("Marca");
                int Precio = rs.getInt("Precio");
                String DNI = rs.getString("DNI");

                c = new Coche(Matricula, Marca, Precio, DNI);
                list_coches.add(c);
            }
        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        } finally {

            try {

                Conexion.close(rs); //cerramos resultSet
                Conexion.close(stmt); //cerramos statement
                Conexion.close(con); //cerramos conexion

            } catch (Exception e) {
            }
        }

        return list_coches;
    }

    public int insert(Coche c) {
        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = Conexion.getConnection(); //establecemos conexion con bd
            stmt = con.prepareStatement(SQL_INSERT); //indicamos la consulta a hacer
            //indicamos cada ? en orden de la consulta SQL_INSERT
            stmt.setString(1, c.getMatricula());
            stmt.setString(2, c.getMarca());
            stmt.setInt(3, c.getPrecio());
            stmt.setString(4, c.getDNI());
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
        //si registros es distinto 0 es que se ha insetado user bien, sino algo ha fallado
        if (registros != 0) {

            System.out.println("Se ha agregado a la bd el coche con matricula " + c.getMatricula());
        } else {

            System.out.println("Ha habido fallo a la hora de insertar el coche");
        }

        return registros;
    }

    public int delete(Coche c) {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = Conexion.getConnection(); //establecemos conexion con bd
            stmt = con.prepareStatement(SQL_DELETE); //indicamos la consulta a hacer
            stmt.setString(1, c.getMatricula()); //indicamos el valor ? en consulta SQL_DELETE
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

        //si registros es distinto 0 es que se ha eliminado user bien, sino algo ha fallado
        if (registros != 0) {

            System.out.println("Se ha eliminado de la bd el coche con matricula " + c.getMatricula());
        } else {

            System.out.println("Ha habido fallo a la hora de eliminar el coche");
        }

        return registros;
    }

    public int update(Coche c) {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = Conexion.getConnection(); //establecemos connecion con la bd
            stmt = con.prepareStatement(sql_UPDATE); //indicamos la consulta a hacer
            //indicamos cada ? en orden de la consulta SQL_UPDATE
            stmt.setString(1, c.getMarca());
            stmt.setInt(2, c.getPrecio());
            stmt.setString(3, c.getDNI());
            stmt.setString(4, c.getMatricula());
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

        //si registros es distinto 0 es que se ha actualizado user bien ,sino algo ha fallado
        if (registros != 0) {

            System.out.println("Se ha actualizado datos coche con matricula " + c.getMatricula());
        } else {

            System.out.println("Ha habido fallo a la hora de actualizar datos coche");
        }
        return registros;
    }
}
