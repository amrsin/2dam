package ej_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author amrsin
 */
public class Frame_ej_3 extends JFrame {

    JPanel panel_pos = new JPanel();
    JPanel panel_elemt = new JPanel();
    JLabel lbl_light, lbl_water, lbl_gas, lbl_sum;
    JTextField txt_light, txt_water, txt_gas;
    JButton btn_sum;

    public Frame_ej_3() {

        //basic window config
        setTitle("ej_3");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //layouts 
        panel_pos.setLayout(new BorderLayout());
        panel_elemt.setLayout(new GridLayout(4, 2, 10, 10));
        add(panel_pos);

        //elements in panel_elemt
        lbl_light = new JLabel("Light");
        txt_light = new JTextField();
        lbl_water = new JLabel("Water");
        txt_water = new JTextField();
        lbl_gas = new JLabel("Gas");
        txt_gas = new JTextField();
        btn_sum = new JButton("SUM");
        btn_sum.addActionListener(new btn_listener());
        lbl_sum = new JLabel("");
        //adding elements to panel
        panel_elemt.add(lbl_light);
        panel_elemt.add(txt_light);
        panel_elemt.add(lbl_water);
        panel_elemt.add(txt_water);
        panel_elemt.add(lbl_gas);
        panel_elemt.add(txt_gas);
        panel_elemt.add(btn_sum);
        panel_elemt.add(lbl_sum);
        panel_pos.add(panel_elemt, BorderLayout.CENTER);

    }
    //method for btn listener
    class btn_listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            double light = Double.parseDouble(txt_light.getText());
            double water = Double.parseDouble(txt_water.getText());
            double gas = Double.parseDouble(txt_gas.getText());
            double sum = light + water + gas;

            lbl_sum.setText("Total: " + Double.toString(sum));

        }
    }

}