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

    JPanel panel = new JPanel();
    private JRadioButton male;
    private JRadioButton female;
    private JCheckBox daughters;
    private JCheckBox sons;
    private JLabel result;
    private String m;
    private String f;
    private String family_status;

    public radio_check() {
        //app name
        setTitle("radio_checkbox");
        setSize(500, 250);//window size
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(4, 2));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bt_group = new ButtonGroup();
        bt_group.add(male);
        bt_group.add(female);

        m = "male";
        f = "female";
        male.addItemListener(new Radio_listener(m));
        female.addItemListener(new Radio_listener(f));
        panel.add(male);
        panel.add(female);

        daughters = new JCheckBox("Daughters");
        sons = new JCheckBox("Sons");
        ListenerCheckBox maneger = new ListenerCheckBox();
        daughters.addItemListener(maneger);
        sons.addItemListener(maneger);

        panel.add(daughters);
        panel.add(sons);
        result = new JLabel("");
        panel.add(result);
        add(panel);

    }

    private class Radio_listener implements ItemListener {

        private String genere;

        public Radio_listener(String g) {

            genere = " You are " + g;
        }

        public void itemStateChanged(ItemEvent evento) {

            result.setText(genere);
        }
    }

    private class ListenerCheckBox implements ItemListener {

        public void itemStateChanged(ItemEvent event) {

            String aux = result.getText();
            String[] parts = aux.split(",");
               
            
            if (event.getSource() == daughters) {

                family_status = ", you have daughters";
                aux = aux + family_status;
                
                if (!daughters.isSelected()) {
                    
                    aux = parts[0];
                }

            }
            
            if (event.getSource() == sons) {

                family_status = ", you have sons";
                aux = aux + family_status;
                
                 if (!sons.isSelected()) {
                    
                    aux = parts[0] + "," +  parts[1];
                }
            } 
            
            result.setText(aux);
        } 
    }
}