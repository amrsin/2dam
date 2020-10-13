
package view;

import controller.controller;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import model.show;

/**
 *
 * @author amrsin
 */
public class Frame_series extends JFrame{
    
    private JPanel panel1, panel2, panel3;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    private JLabel lbl_title;
    private JLabel lbl_screenwriter;
    private JLabel lbl_season;
    private JLabel lbl_genre;
    private JLabel lbl_seen_seasons;
    private JLabel lbl_platform;
    private JTextField text_title;
    private JTextField text_screenwriter;
    private JTextField text_season;
    private JTextField text_genre;
    private JTextField text_seen_season;
    private JTextField text_platform;
    private String[] platform_names = { "None", "Netflix", "HBO", "Amazon", "Sky"};
    private JComboBox combo_platform;
    
    private controller c = null;
    
    
   public Frame_series(controller control) {
       
       c = control; 
       panel1 = new JPanel();
       panel2 = new JPanel();
       panel3 = new JPanel();
       //basic config
       setTitle("Series");
       setSize(500,300);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       //layout for panels
       panel1.setLayout(new BorderLayout());
       panel2.setLayout(new GridLayout(7,2,10,10));
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
   
       //creating labels and Jtextfields 
       //adding labels and textfiels to panel2
       lbl_title = new JLabel(" Title");
       text_title = new JTextField();
       text_title.setEditable(false);
       panel2.add(lbl_title);
       panel2.add(text_title);
       
       lbl_screenwriter = new JLabel(" Screenwriter");
       text_screenwriter = new JTextField();
       text_screenwriter.setEditable(false);
       panel2.add(lbl_screenwriter);
       panel2.add(text_screenwriter);
       
       lbl_season = new JLabel(" Season");
       text_season = new JTextField();
       text_season.setEditable(false);
       panel2.add(lbl_season);
       panel2.add(text_season);
       
       lbl_genre= new JLabel(" Genre");
       text_genre = new JTextField();
       text_genre.setEditable(false);
       panel2.add(lbl_genre);
       panel2.add(text_genre);
       
       lbl_seen_seasons = new JLabel(" Seen seasons");
       text_seen_season = new JTextField();
       text_seen_season.setEditable(false);
       panel2.add(lbl_seen_seasons);
       panel2.add(text_seen_season);
       
       lbl_platform = new JLabel(" Platform");
       text_platform = new JTextField();
       text_platform.setEditable(false);
       panel2.add(lbl_platform);
       panel2.add(text_platform);
       
       combo_platform = new JComboBox(platform_names);
       panel2.add(combo_platform);
       combo_platform.setVisible(false);

      //adding listener to buttons 
      buttonsListener bl = new buttonsListener();
      btn1.addActionListener(bl);
      btn2.addActionListener(bl);
      btn3.addActionListener(bl);
      btn4.addActionListener(bl);
      btn5.addActionListener(bl);
      btn6.addActionListener(bl);
      btn7.addActionListener(bl);
      
      combo_platform.addItemListener(new ListenerCombo());

   }

   
   class buttonsListener implements ActionListener {
       
         String t = "";
       public void actionPerformed(ActionEvent e){
           
           show s=new show();
           
           if (e.getSource()==btn1) {
               s = c.first();
           }
           
           if (e.getSource()==btn2) {
               s = c.previous();
               
           }
           
           if (e.getSource()==btn3) {
               s = c.next();
               
           }
           
            if (e.getSource()==btn4) {
               s = c.last();
               
           }
            
           if (e.getSource()==btn5) {
               
               if (btn5.getText().equals("+")) {
                text_title.setText("");
                text_screenwriter.setText("");
                text_season.setText("");
                text_genre.setText("");
                text_seen_season.setText("");
                
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
               
                btn5.setText("+++");
                
                
                text_title.setEditable(true);
                text_screenwriter.setEditable(true);
                text_season.setEditable(true);
                text_genre.setEditable(true);
                text_seen_season.setEditable(true);
                lbl_platform.setVisible(false);
                text_platform.setVisible(false);
                combo_platform.setVisible(true);

                   
               }else{
                
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                
                text_title.setEditable(false);
                text_screenwriter.setEditable(false);
                text_season.setEditable(false);
                text_genre.setEditable(false);
                text_seen_season.setEditable(false);
                btn5.setText("+");
                
                lbl_platform.setVisible(true);
                text_platform.setVisible(true);
                combo_platform.setVisible(false);
                
                
                s=fillShow();
                c.new_s(s);
                
            }
           }
           
           if (e.getSource()==btn6) {
               
               String t = text_title.getText();
               c.delete(t);
               s = c.last();
               
           }
        
           if (e.getSource()==btn7) {
                
            
               if (!text_title.isEditable()) {
                    t = text_title.getText();
               }
             
              s = c.copy_d(t);
              
                if (btn7.getText().equals("*")) {
                 
                 String platform = text_platform.getText();

                 text_title.setEditable(true);
                 text_screenwriter.setEditable(true);
                 text_season.setEditable(true);
                 text_genre.setEditable(true);
                 text_seen_season.setEditable(true);
                 combo_platform.setSelectedItem(platform);
                 btn1.setEnabled(false);
                 btn2.setEnabled(false);
                 btn3.setEnabled(false);
                 btn4.setEnabled(false);
                 btn5.setEnabled(false);
                 btn6.setEnabled(false);
                 lbl_platform.setVisible(false);
                 text_platform.setVisible(false);
                 combo_platform.setVisible(true);
                 btn7.setText("***");
                  
               }else{
                
                 String title = text_title.getText();
                 String screenwriter = text_screenwriter.getText();
                 int season = Integer.parseInt(text_season.getText());
                 String genre = text_genre.getText();
                 int seen_season = Integer.parseInt(text_seen_season.getText());
                 String platform = text_platform.getText();
                 c.modify_d(s, title, screenwriter, season, genre, seen_season, platform);
                     
               
                 btn1.setEnabled(true);
                 btn2.setEnabled(true);
                 btn3.setEnabled(true);
                 btn4.setEnabled(true);
                 btn5.setEnabled(true);
                 btn6.setEnabled(true);
                 
                 text_title.setEditable(false);
                 text_screenwriter.setEditable(false);
                 text_season.setEditable(false);
                 text_genre.setEditable(false);
                 text_seen_season.setEditable(false);
                 
                 lbl_platform.setVisible(true);
                 text_platform.setVisible(true);
                 combo_platform.setVisible(false);
                 btn7.setText("*");
                
                 }  
                } 
           updating(s);
       }
   }
   
   private void updating(show s){
       
       text_title.setText(s.getTitle());
       text_screenwriter.setText(s.getScriptwriter());
       text_season.setText(String.valueOf(s.getSeasons()));
       text_genre.setText(s.getGenere());
       text_seen_season.setText(String.valueOf(s.getViews()));
       text_platform.setText(s.getPlatform());
   }
   
    private show fillShow(){
        
        show s = new show(text_title.getText(),
                text_screenwriter.getText(),
                Integer.parseInt(text_season.getText()),
                text_genre.getText(),
                Integer.parseInt(text_seen_season.getText()), 
                text_platform.getText());
        return s;
    }
    
    private class ListenerCombo implements ItemListener {
          
     
        
        public void itemStateChanged (ItemEvent e) {
            
            int indice = combo_platform.getSelectedIndex();
           
            String s = platform_names[indice];
            
            text_platform.setText(s);
            
         }
    }  
  }