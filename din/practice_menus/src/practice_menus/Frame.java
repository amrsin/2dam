package practice_menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author amrsin
 */
public class Frame extends JFrame {

    public Frame() {
        
        JPanel panel = new JPanel();
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();
        menu = new JMenu("Frist Menu");
        menuBar.add(menu);

        menuItem = new JMenuItem("Option 1");
        menuItem.addActionListener(new em(this) );
        menu.add(menuItem);
        menu.addSeparator();

        menuItem = new JMenuItem("Option 2");
        menu.add(menuItem);
        menu = new JMenu("Second Menu");
        menuBar.add(menu);
        
        panel.add(menuBar);
        add(panel);
    }
    
    class em implements ActionListener {

        JFrame miFrame;
        
        public em(JFrame f) {
            
            miFrame = f;
            
        }
        
        

        public void actionPerformed(ActionEvent ae) {
            
            DialogModal dialogModal = new DialogModal(miFrame);
            dialogModal.pack();
            
            dialogModal.setVisible(true);
            
            System.out.println(dialogModal.getText());
            
            
            
           
        }  
    }
}
