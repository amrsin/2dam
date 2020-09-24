
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
        //title for app
        setTitle("Converter");
        setSize(300, 160); //window size
        setResizable(false); //disabled resizing window op
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        panel.setLayout(new GridLayout(3, 2)); //3 rows, 2 colums
        //Celsius label
        JLabel lb_celsius = new JLabel(" Celsius Grades");
        textField1 = new JTextField("", 20); //textfield for celsius
        textField1.setBorder(BorderFactory.createLineBorder(Color.red)); //bg color red
        textField1.addActionListener(new tokelvin()); //calling tokelvin listener 
        panel.add(lb_celsius); //adding celsius label to panel
        panel.add(textField1); //adding celsius textfield to panel
        //kelvin label
        JLabel lb_kelvin = new JLabel(" Kelvin Grades");
        textField2 = new JTextField("", 20); //textfield for kelvin
        textField2.setBorder(BorderFactory.createLineBorder(Color.red)); //bg color red
        textField2.addActionListener(new tocelsius()); //calling tocelsius listener
        panel.add(lb_kelvin); //adding kelvin label to panel
        panel.add(textField2);  //adding kelvin textfield to panel
        //clean button
        JButton bt_clean = new JButton("Clean");
        bt_clean.addActionListener(new ButtonListener()); //caling buttonListener
        panel.add(bt_clean); //adding button to panel
        add(panel); //adding panel
    }
    //tokevin listener
    class tokelvin implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String text = textField1.getText();
            double celcius = Double.parseDouble(text);
            Double tokelvin = 273.15 + celcius;
            text = Double.toString(tokelvin);
            textField2.setText(text);

        }
    }
    //tocelsius listener
    class tocelsius implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String text = textField2.getText();
            double kelvin = Double.parseDouble(text);
            double tocelcius = kelvin - 273.15;
            text = Integer.toString((int) tocelcius);
            textField1.setText(text);
        }
    }
    //buttonlistener
    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            textField1.setText("");
            textField1.requestFocus(); 
            textField2.setText("");
        }
    }
}