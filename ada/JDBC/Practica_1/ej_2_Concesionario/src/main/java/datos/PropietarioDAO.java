
package datos;
import domain.Propietario;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author singh
 */
public class PropietarioDAO {
    
    //consultas sql
    private static final String SQL_SELECT = "SELECT * FROM propietarios";
    private static final String SQL_INSERT = "INSERT INTO propietarios VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM propietarios where DNI = ?";
    private static final String sql_UPDATE = "UPDATE propietarios SET Nombre = ?, Edad = ? WHERE DNI = ?";

    public List<Propietario> select() {
        
        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Propietario p;
        List <Propietario> list_propietarios = new ArrayList<>();
        
        
        try {
            
            con = Conexion.getConnection(); //establecemos conexion con la bd
            stmt = con.prepareStatement(SQL_SELECT); //indicamos la consulta a hacer
            rs = stmt.executeQuery(); //ejecutamos consulta
            
            //mientras tengamos obejetos en resultSet
            while (rs.next()) {
                //Creamos Objeto Propietario y lo agregamos en list_propietario
                String DNI = rs.getString("DNI");
                String Nombre = rs.getString("Nombre");
                int Edad = rs.getInt("edad");
                p = new Propietario(DNI, Nombre, Edad);
                list_propietarios.add(p);
            }
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
        }finally {
            
            try {
               
                Conexion.close(rs); //cerramos resultSet
                Conexion.close(stmt); //cerramos statement
                Conexion.close(con); //cerramos conexion
                
            } catch (Exception e) {
           }
        }
        
        return list_propietarios;
    }
    
     public int insert(Propietario p) {
        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = Conexion.getConnection(); //establecemos conexion con bd
            stmt = con.prepareStatement(SQL_INSERT); //indicamos la consulta a hacer
            //indicamos cada ? en orden de la consulta SQL_INSERT
            stmt.setString(1, p.getDNI());
            stmt.setString(2, p.getNombre());
            stmt.setInt(3, p.getEdad());
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
            
            //si registros es distinto 0 es que se ha insetado user bien, sino algo ha fallado
        if (registros != 0) {

            System.out.println("Se ha agregado a la bd el propietario con nombre " + p.getNombre());
        } else {

            System.out.println("Ha habido fallo a la hora de insertar el propietario");
        }
        }
        return registros;
    }
     
     public int delete(Propietario p) {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = Conexion.getConnection(); //establecemos conexion con bd
            stmt = con.prepareStatement(SQL_DELETE); //indicamos la consulta a hacer
            stmt.setString(1, p.getDNI()); //indicamos el valor ? en consulta SQL_DELETE
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
        
         //si registros es distinto 0 es que se ha eliminado propietario bien, sino algo ha fallado
        if (registros != 0) {

            System.out.println("Se ha eliminado de la bd el propietario con DNI " + p.getDNI());
        } else {

            System.out.println("Ha habido fallo a la hora de eliminar el propietario");
        }

        return registros;
    }
     
      public int update(Propietario p) {

        //variables
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            con = Conexion.getConnection(); //establecemos connecion con la bd
            stmt = con.prepareStatement(sql_UPDATE); //indicamos la consulta a hacer
            //indicamos cada ? en orden de la consulta SQL_UPDATE
            stmt.setString(1, p.getNombre());
            stmt.setInt(2, p.getEdad());
            stmt.setString(3, p.getDNI());
            
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

            System.out.println("Se ha actualizado datos propietario con DNI " + p.getDNI());
        } else {

            System.out.println("Ha habido fallo a la hora de actualizar el propietario");
        }
        return registros;
     }
}