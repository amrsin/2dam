package datos;

import java.sql.*;
/**
 *
 * @author singh
 */
public class Conexion {
    
    //datos necesarios para poder conectar a la bd
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/supercomprin?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD= "din123";
  
    //metodo para establecer conexion con la bd
    public static Connection getConnection() throws SQLException {
              
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    //metodo para cerrar ResultSet
    public static void close (ResultSet rs) throws SQLException {
        
        rs.close();
    }
    
    //metodo para cerrar Statement
    public static void close (Statement smtm) throws SQLException {
        
        smtm.close();
    }
    
    //metodo para cerrar conexion
    public static void close(Connection con) throws SQLException {
        
        con.close();
    }  
}