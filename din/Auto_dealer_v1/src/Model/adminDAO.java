package Model;

/**
 *
 * @author singh
 */
import Model.Connection_BD;
import java.sql.*;
import javax.swing.*;

public class adminDAO {

    public boolean verify_login(JTextField txt_username, JPasswordField password) throws Exception {

        Boolean exist = false;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        if (!txt_username.getText().isEmpty() && !password.getText().isEmpty()) {

            try {

                con = Connection_BD.OpenConnection();
                stmt = con.prepareStatement("SELECT * FROM admin where username=? AND password=?");
                stmt.setString(1, txt_username.getText());
                stmt.setString(2, password.getText());
                rs = stmt.executeQuery();

                if (rs.next()) {

                    exist = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Username and Password are not correct");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
            } finally {
                rs.close();;
                stmt.close();
                Connection_BD.CloseConnection(con);
            }
        } else {
            
            if (txt_username.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username field is empty", "WARNING", JOptionPane.WARNING_MESSAGE);

            }
            if (password.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Password field is empty","WARNING", JOptionPane.WARNING_MESSAGE);

            }
        }
        return exist;
    }
}