
package computer_budget;
/**
 *
 * @author amrsin
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class frame_computer extends JFrame {
    
    JPanel panel_position = new JPanel();
    JPanel panel_general = new JPanel();
    JPanel panel_micros = new JPanel();
    JPanel panel_ram = new JPanel();
    JPanel panel_monitor = new JPanel();
    JPanel panel_miscellanea = new JPanel();
    TitledBorder title;
    ButtonGroup bg_micro = new ButtonGroup();
    ButtonGroup bg_RAM = new ButtonGroup();
    ButtonGroup bg_monitors = new ButtonGroup();
    JRadioButton jb_micro = new JRadioButton();
    JRadioButton jb_RAM = new JRadioButton();
    JRadioButton jb_monitors = new JRadioButton();
    String text_micro;
    String text_RAM;
    String text_monitor;
    String text_miscellanea;
    
    String [][] micros = {{"Intel 1","300"},{"Intel 2","350"},{"AMD 1","200"},{"AMD 2","250"}};
    String [][] RAM = {{"RAM 1GB","300"},{"RAM 2GB","350"},{"RAM 4GB","200"},{"RAM 8GB","250"}};
    String [][] Monitors = {{"LG1","300"},{"LG2","350"},{"LG3","200"},{"LG4","250"}};
    String [][] Miscellanea = {{"Mouse normal","300"},{"Mouse pro","350"},{"Keyboard","200"},{"Keyboard pro","250"}};
    
    public frame_computer() {

        setSize(700, 350);
        setTitle("Choose a computer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel_position.setLayout(new BorderLayout());
        panel_general.setLayout(new GridLayout(1,4,2,2));
        panel_micros.setLayout(new GridLayout(micros.length,1));
        panel_ram.setLayout(new GridLayout(RAM.length, 1));
        panel_monitor.setLayout(new GridLayout(Monitors.length, 1));
        panel_miscellanea.setLayout(new GridLayout(Miscellanea.length, 1));
        
        
       
        add(panel_position);
        panel_position.add(panel_general, BorderLayout.CENTER);
      
        title = BorderFactory.createTitledBorder("Micros");       
        panel_micros.setBorder(title);
        
        for (int i = 0; i < micros.length; i++) {
            jb_micro = new JRadioButton(micros[i][0]);
            bg_micro.add(jb_micro);
            jb_micro.addItemListener(new micro_listener());
            panel_micros.add(jb_micro);
        }
        
        panel_general.add(panel_micros);
        
         
        title = BorderFactory.createTitledBorder("RAM");       
        panel_ram.setBorder(title);
        
        for (int i = 0; i < RAM.length; i++) {
            jb_RAM = new JRadioButton(RAM[i][0]);
            jb_RAM.addItemListener(new RAM_listener());
            bg_RAM.add(jb_RAM);
            
            
            panel_ram.add(jb_RAM);
        }
        
        
        
        panel_general.add(panel_ram);
          
        title = BorderFactory.createTitledBorder("Monitors");       
        panel_monitor.setBorder(title);
        
        for (int i = 0; i < Monitors.length; i++) {
            jb_monitors = new JRadioButton(Monitors[i][0]);
            bg_monitors.add(jb_monitors);
            jb_monitors.addItemListener(new Monitors_listener());
            panel_monitor.add(jb_monitors);
        }
        
        panel_general.add(panel_monitor);
        
        
        title = BorderFactory.createTitledBorder("Miscellanea");       
        panel_miscellanea.setBorder(title);
        
        for (int i = 0; i < Miscellanea.length; i++) {
            JRadioButton jb = new JRadioButton(Miscellanea[i][0]);
            JCheckBox chk = new JCheckBox(Miscellanea[i][0]);
            chk.addItemListener(new miscellanea_listener());
            panel_miscellanea.add(chk);
        }
        panel_general.add(panel_miscellanea);
        
        
        JButton btn_print = new JButton("Print");
        btn_print.addActionListener(new btn_listener());
        panel_position.add(btn_print, BorderLayout.SOUTH);
        
    }
    
    
    
    class micro_listener implements ItemListener{
        
        @Override
        public void itemStateChanged(ItemEvent e) {
            
            text_micro = "";
            for (int i = 0; i < panel_micros.getComponentCount(); i++) {
                
                JRadioButton rb = (JRadioButton)panel_micros.getComponent(i);
                
                if (rb.isSelected()) {
                    
                   text_micro = rb.getText();
                   
                   text_micro = text_micro + " " + micros[i][1];

                              
                }        
     
            }
        }
    } 
    
     class RAM_listener implements ItemListener{
        
        @Override
        public void itemStateChanged(ItemEvent e) {
            
            text_RAM = "";
            for (int i = 0; i < panel_ram.getComponentCount(); i++) {
                
                JRadioButton rb = (JRadioButton)panel_ram.getComponent(i);
                
                if (rb.isSelected()) {
                    
                   text_RAM = rb.getText();
                   text_RAM = text_RAM + " " + RAM[i][1];
                }        
     
            }
        }
    }
     
     class Monitors_listener implements ItemListener{
        
        @Override
        public void itemStateChanged(ItemEvent e) {
            
            text_monitor = "";
            for (int i = 0; i < panel_monitor.getComponentCount(); i++) {
                
                JRadioButton rb = (JRadioButton)panel_monitor.getComponent(i);
                
                if (rb.isSelected()) {
                    
                   text_monitor = rb.getText();
                   text_monitor = text_monitor + " " + Monitors[i][1];
                }        
            }
        }
    }
     
    class miscellanea_listener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            String aux_txt = "";
            text_miscellanea = "";
            for (int i = 0; i < panel_miscellanea.getComponentCount(); i++) {
                
               JCheckBox ck = (JCheckBox)panel_miscellanea.getComponent(i);
                if (ck.isSelected()) {
                   
                  aux_txt = ck.getText();
                  //text_miscellanea = ck.getText();
                  text_miscellanea = text_miscellanea + " " + aux_txt + " " + Miscellanea[i][1];    
                } 
            }  
        }
    }
    
    class btn_listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            System.out.println(text_micro);
            System.out.println(text_RAM);
            System.out.println(text_monitor);      
            System.out.println(text_miscellanea);      
        }
    }   
}