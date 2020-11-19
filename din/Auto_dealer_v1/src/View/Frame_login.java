
package View;
import Model.adminDAO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author singh
 */
public class Frame_login extends JFrame{
    //elements
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
        //adding elements to panel
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
        btn_login.setBackground(Color.DARK_GRAY);
        btn_login.setForeground(Color.WHITE);
        btn_login.setFocusable(false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; c.gridwidth = 2; c.gridy = 2;
        btn_login.addMouseListener(new btn_mouse_adapter()); //adding mouse lister to btn_login
        btn_login.addActionListener(new btnLogin_listener());//adding action listener to btn_login
        panel.add(btn_login, c);
        
        add(panel);//adding panel
    } 
    
      //listener MouseAdapter to change background color when entred and exited
    class btn_mouse_adapter extends MouseAdapter {

        public void mouseEntered(java.awt.event.MouseEvent evt) {
            
            btn_login.setBackground(new Color(143,21,0));   
        }
        
        public void mouseExited(java.awt.event.MouseEvent evt) {
            
            btn_login.setBackground(Color.DARK_GRAY);   
        }
    }
    
  
    //action listener btn_loging
    class btnLogin_listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean exist = false;
            adminDAO admindao = new adminDAO();
            try {
                exist = admindao.verify_login(txt_username, password);//calling verify _loging metohod to verify account
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