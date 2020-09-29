package act_radio_checkbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * /**
 *
 * @author amrsin
 */
public class radio_check extends JFrame {
    //var
    JPanel panel = new JPanel();
    private JRadioButton male;
    private JRadioButton female;
    private JCheckBox daughters;
    private JCheckBox sons;
    private JLabel result;
    private String m;
    private String f;
    private String aux;

    public radio_check() {
        //app name
        setTitle("radio_checkbox");
        setSize(750, 300);//window size
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //4rows, 2colums layout
        panel.setLayout(new GridLayout(4, 2));
        male = new JRadioButton("Male"); //Created JradioButton male
        female = new JRadioButton("Female"); //Created JradioButton female
        ButtonGroup bt_group = new ButtonGroup();//Created ButtonGroup
        //added male and female radio buttons to bt_group
        bt_group.add(male);
        bt_group.add(female);
        
        m = "male";
        f = "female";
        male.addItemListener(new Radio_listener(m));//called radio_listener passing male string
        female.addItemListener(new Radio_listener(f));//called radio_listener passing female string
        panel.add(male);//added male to paenl
        panel.add(female);//added male to paenl
        //created Jcheckbox daughters and sons
        daughters = new JCheckBox("Daughters");
        sons = new JCheckBox("Sons");
        ListenerCheckBox maneger = new ListenerCheckBox();//created listener for checkbox
        daughters.addItemListener(maneger);//added daughters to listener item>
        sons.addItemListener(maneger);//added sons to listener item>

        panel.add(daughters);//added daughters to panel
        panel.add(sons);//added daughters to panel
        result = new JLabel(" ");//created Jlabel named result
        panel.add(result);//added result to paenl
        add(panel);//added panel

    }
    //class for radio witch implements ItemListener
    private class Radio_listener implements ItemListener {

        private String genere;
        //method Radio_listener with have string genere
        public Radio_listener(String g) {

            genere = " You are " + g;
        }
        //method for change item state
        public void itemStateChanged(ItemEvent evento) {
            
            String parts2[];
            if (aux!= null) {
                parts2 = aux.split(",");
                
                if (parts2.length <= 1) {
                    
                  result.setText(genere + " you don't have children's");

                }
                if (parts2.length > 1) {
                 result.setText(genere + "," + parts2[1]);

                }
                if (parts2.length > 2) {
                  result.setText(genere + "," + parts2[1]  + "," + parts2[2]);

                }
            }else {
                result.setText(genere + " you don't have children's");
            }
        }
    }
    //class for checkbox listener
    private class ListenerCheckBox implements ItemListener {
        //method for change item state
        public void itemStateChanged(ItemEvent event) {
            
            String[] parts;
            String family_status;
            aux = result.getText();
            parts = aux.split(",");
               
            if (event.getSource() == daughters) {

                family_status = ", you have daughters";
                aux = aux.replace(" you don't have children's", "");
                aux = aux + family_status;
                
                
                if (!daughters.isSelected() && sons.isSelected()) {
                        
                    aux = parts[0] + "," + " you have sons";
                }

            }
            
            if (event.getSource() == sons) {

                family_status = ", you have sons";
                aux = aux.replace(" you don't have children's", "");
                aux = aux + family_status;
                
                 if (!sons.isSelected()) {
                    
                    aux = parts[0] + "," +  " you have daughters";
                }
                 
            }
            
            if (!sons.isSelected() && !daughters.isSelected()) {
                    
                    aux = parts[0] + " you don't have children's";
                }
            result.setText(aux);
        } 
    }
}