/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first_window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author amrsin
 */
public class first_frame extends JFrame {

    JPanel panel = new JPanel();

    public first_frame() {

        setTitle("Hello");
        setSize(300, 200);
        setDefaultCloseOperation (EXIT_ON_CLOSE);

        add(panel);
        panel.setBackground(Color.red);

        JButton button = new JButton("Change bg color");
        // listener
        button.addActionListener(new listener_button());
        Dimension d = new Dimension();
        d.height = 40;
        d.width = 200;
        button.setPreferredSize(d);
        panel.add(button);
        
        

    }

    class listener_button implements ActionListener {
      // The actionPerformed method has to be rewritten, it is the one that responds to the button click

        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.blue);

        }

    }
}
