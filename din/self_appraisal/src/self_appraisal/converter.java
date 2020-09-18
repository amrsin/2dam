/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package self_appraisal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author amrsin
 */
public class converter extends JFrame{

   
    JTextField textField1, textField2;
    JPanel panel = new JPanel();
    
    public converter() {
       
        setTitle("Converter");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3,2));
        
        JLabel lb_celsius = new JLabel(" Celsius Grades");
        textField1 = new JTextField ("", 2);
        textField1.addActionListener(new TextFieldListener());
        panel.add(lb_celsius);
        textField1.setBorder (BorderFactory.createLineBorder (Color.red));
        panel.add(textField1);
        JLabel lb_kelvin = new JLabel(" Kelvin Grades");
        panel.add(lb_kelvin);
        textField2 = new JTextField ("", 2);
        textField2.setBorder (BorderFactory.createLineBorder (Color.red));
        panel.add(textField2);
        add(panel);
    }
    
      class TextFieldListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
// get the text typed in textfield1
// and assign it to the other textfield.
            String text = textField1.getText();
            float celcius = Float.parseFloat(text);
            float tokelvin = (float) (273.15 + celcius);
            text = Float.toString(tokelvin);
            textField2.setText(text);

        }
    }
}
