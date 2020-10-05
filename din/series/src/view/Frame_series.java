/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

/**
 *
 * @author amrsin
 */
public class Frame_series extends JFrame{
    
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JLabel lbl_title;
    private JLabel lbl_screenwriter;
    private JLabel lbl_season;
    private JLabel lbl_genere;
    private JLabel lbl_seen_seasons;
    private JTextField text_title;
    private JTextField text_screenwriter;
    private JTextField text_season;
    private JTextField text_genere;
    private JTextField text_seen_season;
        
   public Frame_series() {
       
       setTitle("Series");
       setSize(500,300);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       panel1.setLayout(new BorderLayout());
       panel2.setLayout(new GridLayout(5,3,10,10));
       panel3.setLayout(new FlowLayout());
       add(panel1);
       panel1.add(panel3,BorderLayout.NORTH);
       panel1.add(panel2,BorderLayout.CENTER);
       
       btn1 = new JButton("|<");
       btn2 = new JButton("<");
       btn3 = new JButton(">");
       btn4 = new JButton(">|");
       btn5 = new JButton("+");
       btn6 = new JButton("-");
       btn7 = new JButton("*");
       panel3.add(btn1);
       panel3.add(btn2);
       panel3.add(btn3);
       panel3.add(btn4);
       panel3.add(btn5);
       panel3.add(btn6);
       panel3.add(btn7);
       add(panel3);
   }
    
}
