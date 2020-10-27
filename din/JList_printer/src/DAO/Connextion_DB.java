
package DAO;

import java.sql.*;
/**
 *
 * @author amrsin
 */
public class Connextion_DB {
    
    public Connection OpenConnection() throws Exception {
        Connection con = null; // install a connection
        
        try {
            String urlOdbc = "jdbc:mysql://localhost:3306/di?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", "din123"));
            return con;
        } catch (Exception e) {// SQLException and ClassNotFoundException
            e.printStackTrace();
            throw new Exception("Connection could not be established" + e.getMessage());
        }
    }

    public void CloseConnection(Connection con) throws Exception {
        
        try {
           
            if (con!=null) {
               
                con.close();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("It was impossible to close the connection" + e.getMessage());
        }
    }
}