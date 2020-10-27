package DAO;

import java.sql.*;
import java.util.*;

/**
 *
 * @author amrsin
 */
public class ClientDao {

    public List<Client> findAll() throws Exception {
        
        List<Client> listClients = new ArrayList();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Client c = null;

        try {
            
            con = Connection_BD.OpenConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from clients");
            while (rs.next()) {
                c = new Client();
                getClientRow(rs, c);
                listClients.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("There was a problem searching the client “" + ex.getMessage());
        } finally {
            
            if (rs != null) {
                rs.close(); // We close the result
            }
            if (stmt != null) {
                stmt.close(); // We close the Statement
            }
        }
        return listClients;
    }

    private void getClientRow(ResultSet rs, Client cli) throws SQLException {
        cli.setId(rs.getString("id"));
        cli.setNotes(rs.getString("notes"));

    }    
}