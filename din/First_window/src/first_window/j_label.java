/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first_window;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author amrsin
 */
public class j_label extends JFrame {

    public j_label() {

        setTitle("Jlabel example");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // change the default panel layout
        panel.setLayout(new GridLayout(3, 1));
        // create three labels
        JLabel label1 = new JLabel("First label"); // default left justification
        JLabel label2 = new JLabel("Second label", JLabel.CENTER); //centered
        JLabel label3 = new JLabel("Third label", JLabel.RIGHT); //right
// add them to the panel
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        add(panel);
    }
} // of frame