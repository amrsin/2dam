
package practice_jcombobox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author amrsin
 */
public class Frame_combo extends JFrame{
    
    private JComboBox combo;
    private JLabel label;
    private JPanel panel;
    private String[] images = { "Rabbit", "Cat", "Dog", "Bird", "Pig"};
    private Icon img;
    
    public Frame_combo() {
        
       setTitle("Combos and images");
       setSize(500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       panel = new JPanel();
       panel.setLayout(new BorderLayout());
       
       add(panel);
       //passing the array of img
       combo = new JComboBox(images);
       panel.add(combo,BorderLayout.NORTH);
       
    //an object ImageIcon brings the image:
        
        img = new ImageIcon( getClass().getResource("images/Rabbit.gif"));
        //instantiate label
        label = new JLabel();
        //label text:
        label.setText("Rabbit");
        //set icon to label:
        label.setIcon(img);
        
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.BOTTOM);
        
        label.setToolTipText( " This is a label");
        
        panel.add(label, BorderLayout.CENTER);
        
        combo.addItemListener(new ListenerCombo());
}
    
    private class ListenerCombo implements ItemListener {
        
        public void itemStateChanged (ItemEvent e) {
            
            int indice = combo.getSelectedIndex();
            
            String s = images[indice];
            
            img = new ImageIcon( getClass().getResource("images/" + s + ".gif"));
            label.setIcon(img);
            label.setText(s);
         }
    }  
}