/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    

    public radio_check() {
        //app name
        setTitle("radio_checkbox");
        setSize(300, 250);//window size
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(4, 2));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bt_group = new ButtonGroup();
        bt_group.add(male);
        bt_group.add(female);
        panel.add(male);
        panel.add(female);
        daughters = new JCheckBox("Daughters");
        sons = new JCheckBox("Sons");
        panel.add(daughters);
        panel.add(sons);
        JLabel resutl = new JLabel("hello");
        panel.add(resutl);
        add(panel);
    }
}