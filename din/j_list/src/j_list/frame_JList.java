/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_list;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;


/**
 *
 * @author amrsin
 */
public class frame_JList extends JFrame{
    
    private JList list_colours;
    private final String namesColours[] = {"Black", "Blue", "Cyan",
                        "Dark gray", "Gray", "Green", "Light grey", "Magenta", 
                        "Orange", "Pink", "Red", "White", "Yellow"};
    
    private final Color colours[] = { Color.BLACK, Color.BLUE, Color.CYAN,
                      Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
                      Color.ORANGE, Color.PINK,Color.RED, Color.WHITE, Color.YELLOW};
    
    private JPanel panel = new JPanel();

    public frame_JList() {
        
        setSize(800, 600);
        setTitle("SimpleList");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
        
        list_colours = new JList(namesColours);
        
        list_colours.setVisibleRowCount(5);
        
        list_colours.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        panel.add( new JScrollPane( list_colours) );
        
        list_colours.addListSelectionListener (new ListListener());
}
    
    private class ListListener implements ListSelectionListener{
        
        public void valueChanged( ListSelectionEvent e) {
            
            panel.setBackground(colours[list_colours.getSelectedIndex()]);
        }
    }
}
