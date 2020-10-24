/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;
/**
 *
 * @author singh
 */
public class Conexion {
  
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test_ada?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD= "din123";
    
    public static Connection getConnection() throws SQLException {
              
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    public static void close (ResultSet rs) throws SQLException {
        
        rs.close();
    }
    
    public static void close (Statement smtm) throws SQLException {
        
        smtm.close();
    }
    
    public static void close(Connection con) throws SQLException {
        
        con.close();
    }
    
}   

