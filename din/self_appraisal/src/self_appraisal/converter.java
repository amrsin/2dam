
package self_appraisal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author amrsin
 */
public class converter extends JFrame {

    JTextField textField1, textField2;
    JPanel panel = new JPanel();

    public converter() {

        setTitle("Converter");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 2));
     
        JLabel lb_celsius = new JLabel(" Celsius Grades");
        textField1 = new JTextField("", 20);
        textField1.setBorder(BorderFactory.createLineBorder(Color.red));
        textField1.addActionListener(new TextFieldListener());
        panel.add(lb_celsius);
        panel.add(textField1);

        JLabel lb_kelvin = new JLabel(" Kelvin Grades");
        textField2 = new JTextField("", 20);
        textField2.setBorder(BorderFactory.createLineBorder(Color.red));
        textField2.addActionListener(new TextFieldListener2());
        panel.add(lb_kelvin);
        panel.add(textField2);

        JButton bt_clean = new JButton("Clean");
        bt_clean.addActionListener(new ButtonListener());
        panel.add(bt_clean);
        add(panel);
    }

    class TextFieldListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String text = textField1.getText();
            double celcius = Double.parseDouble(text);
            Double tokelvin = 273.15 + celcius;
            text = Double.toString(tokelvin);
            textField2.setText(text);

        }
    }

    class TextFieldListener2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String text = textField2.getText();
            double kelvin = Double.parseDouble(text);
            double tocelcius = kelvin - 273.15;
            text = Integer.toString((int) tocelcius);
            textField1.setText(text);
        }
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            textField1.setText("");
            textField1.requestFocus(); 
            textField2.setText("");
        }
    }
}