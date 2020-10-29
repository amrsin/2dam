
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
    
  //algunos paneles necesarios
    JPanel panel_position = new JPanel();
    JPanel panel_general = new JPanel();
    JPanel panel_micros = new JPanel();
    JPanel panel_ram = new JPanel();
    JPanel panel_monitor = new JPanel();
    JPanel panel_miscellanea = new JPanel();
    TitledBorder title;
    ButtonGroup bg = new ButtonGroup();

    
    String [][] micros = {{"Intel 1","300"},{"Intel 2","350"},{"AMD 1","200"},{"AMD 2","250"}};
    String [][] RAM = {{"RAM 1GB","300"},{"RAM 2GB","350"},{"RAM 4GB","200"},{"RAM 8GB","250"}};
    String [][] Monitors = {{"LG1","300"},{"LG2","350"},{"LG3","200"},{"LG4","250"}};
    String [][] Miscellanea = {{"Mouse normal","300"},{"Mouse pro","350"},{"Keyboard","200"},{"Keyboard pro","250"}};
    
    public frame_computer() {

        setSize(1000, 700 );
        setTitle("Choose a computer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel_position.setLayout(new BorderLayout());
        panel_general.setLayout(new GridLayout(1,4,5,5));
        panel_micros.setLayout(new GridLayout(micros.length,1));
        panel_ram.setLayout(new GridLayout(RAM.length, 1));
        panel_monitor.setLayout(new GridLayout(Monitors.length, 1));
        panel_miscellanea.setLayout(new GridLayout(Miscellanea.length, 1));
        
        
     
        add(panel_position);
        panel_position.add(panel_general, BorderLayout.CENTER);
        
        
        title = BorderFactory.createTitledBorder("Micros");       
        panel_micros.setBorder(title);
        
        for (int i = 0; i < micros.length; i++) {
            JRadioButton jb = new JRadioButton(micros[i][0]);
            bg.add(jb);
            panel_micros.add(jb);
        }
        
        panel_general.add(panel_micros);
        
         
        title = BorderFactory.createTitledBorder("RAM");       
        panel_ram.setBorder(title);
        
        for (int i = 0; i < RAM.length; i++) {
            JRadioButton jb = new JRadioButton(RAM[i][0]);
            bg.add(jb);
            panel_ram.add(jb);
        }
        
        panel_general.add(panel_ram);
             
    }
}