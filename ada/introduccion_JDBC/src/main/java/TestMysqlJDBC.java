
import java.util.*;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amrsin
 */
public class TestMysqlJDBC {
    
    public static void main(String[] args) throws SQLException {
        
        try {
            
            String url = "jdbc:mysql://localhost:3306/test_ada?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            Class.forName("com.mysql.oj-jdbc.Driver");
            
            Connection conexion = DriverManager.getConnection(url, "root", "din123");
            
            
        } catch (ClassNotFoundException ex) {
            
            ex.printStackTrace(System.out);
        }
    }
    
}
