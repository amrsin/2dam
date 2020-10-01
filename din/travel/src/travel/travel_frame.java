/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;


/**
 *
 * @author amrsin
 */
public class travel_frame extends JFrame{
    
    private JLabel label_country;
    private JLabel label_friends;
    private JComboBox country_combo;
    private JList friends_list;
    private final String countryNames[] = {" None" , "Portugal", " Peru", " Greece",
                        " Italy", " Tukey", " India", " Colombia", " New Zealand"};
    
    private final String FriendsNames[] = {"Alex", "Jorge", "Jampi",
                        "Javi", "Gabriel", "Nacho", "Antonio", "Pablo"};
    
    
    private JPanel panel = new JPanel();
    
    public travel_frame() {
        
        setTitle("Travel");
        setSize(700, 200 );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(2, 3));
        
        
        JLabel label1 = new JLabel(" Select Country: ");
        panel.add(label1);
        
        country_combo = new JComboBox(countryNames);
        panel.add(country_combo,BorderLayout.NORTH);
        
        
        
        label_country = new JLabel(" ");
        panel.add(label_country);
        
        
        
        JLabel label2 = new JLabel(" Select friends: ");
        panel.add(label2);
        
        friends_list = new JList(FriendsNames);
        friends_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        panel.add( new JScrollPane(friends_list) );
        
           
        label_friends = new JLabel(" ");
        panel.add(label_friends);
        country_combo.addItemListener(new ListenerCombo());
        friends_list.addListSelectionListener(new ListListener());

        add(panel);
        
        
        
    }
    
     private class ListenerCombo implements ItemListener {
        
        public void itemStateChanged (ItemEvent e) {
            
            int indice = country_combo.getSelectedIndex();
            
            String s = countryNames[indice];
            
            if (s.equals(" None")) {
                label_country.setText("");
            }else{ 
              label_country.setText(s + " is selected");

            }
         }
    }  
   
    
    private class ListListener implements ListSelectionListener{
        
        public void valueChanged( ListSelectionEvent e) {
            
            
            String s = friends_list.getSelectedValuesList().toString();
            label_friends.setText(" I will go with " + s);

        }
    }
    
}
