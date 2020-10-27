package DAO;

import java.sql.*;
import java.util.*;

/**
 *
 * @author amrsin
 */
public class ClientDao {

    public List<Client> findAll(Connection con) throws Exception {
        
        List<Client> listClients = new ArrayList();
        Statement st = null;
        ResultSet rs = null;
        Client cli = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery("Select * from clients");
            while (rs.next()) {
                cli = new Client();
                getClientRow(rs, cli);
                listClients.add(cli);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("There was a problem searching the client “" + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close(); // We close the result
            }
            if (st != null) {
                st.close(); // We close the Statement
            }
        }
        return listClients;
    }

    private void getClientRow(ResultSet rs, Client cli) throws SQLException {
        cli.setId(rs.getString("id"));
        cli.setNotes(rs.getString("notes"));

    }    
}