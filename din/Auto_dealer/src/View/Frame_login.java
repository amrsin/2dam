
package View;
import DAO.adminDAO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author singh
 */
public class Frame_login extends JFrame{

    JLabel lbl_usermane, lbl_password;
    JTextField txt_username;
    JPasswordField password;
    JButton btn_login;
    JPanel panel = new JPanel();
    
    public Frame_login() {
        //basic config
        setSize(350, 250);
        setTitle("Login");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel.setBackground(Color.WHITE);

        //panel with GridBagLayout
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(10, 5, 5, 5); 
        c.anchor = GridBagConstraints.LINE_START;
        //adding elements
        lbl_usermane= new JLabel("Username");  
        c.gridx = 0; c.gridy = 0;
        panel.add(lbl_usermane, c);
        txt_username = new JTextField(10);
        c.gridx = 1; c.gridy = 0;
        panel.add(txt_username, c);
        lbl_password = new JLabel("Password");
        c.gridx = 0; c.gridy = 1;
        panel.add(lbl_password, c);
        password = new JPasswordField(10);
        c.gridx = 1; c.gridy = 1;
        panel.add(password, c);
        btn_login = new JButton("Login");
        c.gridx = 1; c.gridy = 2;
        btn_login.setPreferredSize(new Dimension(110, 25));
        btn_login.addActionListener(new btnLogin_listener());//adding listener to btn_login
        panel.add(btn_login, c);
        add(panel);
    }  
    //listener btn_loging
    class btnLogin_listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean exist = false;
            adminDAO admindao = new adminDAO();
            try {
                exist = admindao.verify_login(txt_username, password);//calling verify _loging metohod to verify 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
            if (exist) {
                //if exist account 
                setVisible(false);//setVisible false this frame
                Frame_autodealer f = new Frame_autodealer();//creating Frame_autodealer
                f.setVisible(true);//setting visible Frame_autodealer
            }
        }
    }
}