
import java.util.*;
import java.sql.*;

/**
 *
 * @author amrsin
 */
public class TestMysqlJDBC {
    
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/test_ada?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "Select id_persona, nombre, apellidos, edad FROM persona";
        
        try {

            //Class.forName("com.mysql.oj-jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "din123");
            
            Statement instuccion = conexion.createStatement();
            
            ResultSet rs = instuccion.executeQuery(sql);
            
            while (rs.next()) {                
                
                System.out.print("ID persona: " + rs.getInt("id_persona"));
                System.out.print(", Nombre: " + rs.getString("nombre"));
                System.out.print(", Apellidos: " + rs.getString("apellidos"));
                System.out.print(", Edad: " + rs.getInt("edad") + "\n");
                
            }
            
            rs.close();
            instuccion.close();
            conexion.close();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
        }
    }
}