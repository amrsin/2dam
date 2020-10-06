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
    private JLabel lbl_genre;
    private JLabel lbl_seen_seasons;
    private JTextField text_title;
    private JTextField text_screenwriter;
    private JTextField text_season;
    private JTextField text_genre;
    private JTextField text_seen_season;
        
   public Frame_series() {
       
       panel1 = new JPanel();
       panel2 = new JPanel();
       panel3 = new JPanel();
       //basic config
       setTitle("Series");
       setSize(500,300);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       //layout for panels
       panel1.setLayout(new BorderLayout());
       panel2.setLayout(new GridLayout(5,3,10,10));
       panel3.setLayout(new FlowLayout());
       add(panel1);//adding panel1
       //BorderLayout posicion for panel2 / 3
       panel1.add(panel3,BorderLayout.NORTH);
       panel1.add(panel2,BorderLayout.CENTER);
       //creating bottons
       btn1 = new JButton("|<");
       btn2 = new JButton("<");
       btn3 = new JButton(">");
       btn4 = new JButton(">|");
       btn5 = new JButton("+");
       btn6 = new JButton("-");
       btn7 = new JButton("*");
       //adding bottons to panel
       panel3.add(btn1);
       panel3.add(btn2);
       panel3.add(btn3);
       panel3.add(btn4);
       panel3.add(btn5);
       panel3.add(btn6);
       panel3.add(btn7);
       add(panel3);//adding panel3
       //creating labels and Jtextfields
       lbl_title = new JLabel(" Title");
       lbl_screenwriter = new JLabel(" Screenwriter");
       lbl_season = new JLabel(" Season");
       lbl_genre= new JLabel(" Genre");
       lbl_seen_seasons = new JLabel(" Seen seasons");
       text_title = new JTextField();
       text_screenwriter = new JTextField();
       text_season = new JTextField();
       text_genre = new JTextField();
       text_seen_season = new JTextField();
       //adding labels and textfiels to panel2
       panel2.add(lbl_title);
       panel2.add(text_title);
       panel2.add(lbl_screenwriter);
       panel2.add(text_screenwriter);
       panel2.add(lbl_season);
       panel2.add(text_season);
       panel2.add(lbl_genre);
       panel2.add(text_genre);
       panel2.add(lbl_seen_seasons);
       panel2.add(text_seen_season);
       add(panel2);//adding panel2
   }
}