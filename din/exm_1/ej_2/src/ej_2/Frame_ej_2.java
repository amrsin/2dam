
package ej_2;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author amrsin
 */
public class Frame_ej_2 extends JFrame{
    
    JPanel panel_general = new JPanel();
    JPanel panel_q1 = new JPanel();
    JPanel panel_q2 = new JPanel();
    JPanel panel_q3 = new JPanel();
    JPanel panel_q4 = new JPanel();
    JPanel panel_q5 = new JPanel();
    TitledBorder title;
    JLabel lbl_q1, lbl_q2, lbl_q3, lbl_q4, lbl_q5;
    ButtonGroup bg_q1 = new ButtonGroup();
    ButtonGroup bg_q2 = new ButtonGroup();
    ButtonGroup bg_q3 = new ButtonGroup();
    ButtonGroup bg_q4 = new ButtonGroup();
    ButtonGroup bg_q5 = new ButtonGroup();
    JButton bnt = new JButton("Corregir");



    JRadioButton jb_q1_1,jb_q1_2,jb_q1_3,jb_q2_1,jb_q2_2,jb_q2_3
                 ,jb_q3_1,jb_q3_2,jb_q3_3,jb_q4_1,jb_q4_2,jb_q4_3,jb_q5_1,jb_q5_2,jb_q5_3;
    

    public Frame_ej_2() {
        
        
        //basic window config
        setTitle("ej_2");
        setSize(500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        panel_general.setLayout(new GridLayout(6,0, 10, 10));
        panel_q1.setLayout(new GridLayout(4,0, 10, 10));
        panel_q2.setLayout(new GridLayout(4,0, 10, 10));
        panel_q3.setLayout(new GridLayout(4,0, 10, 10));
        panel_q4.setLayout(new GridLayout(4,0, 10, 10));
        panel_q5.setLayout(new GridLayout(4,0, 10, 10));

        add(panel_general);
        
        title = BorderFactory.createTitledBorder("Pregunta: 1");       
        panel_q1.setBorder(title);
        
        lbl_q1 = new JLabel("¿Que es la máquina Virtual de Java");
        
        jb_q1_1 = new JRadioButton("Una maquina de cafés");
        jb_q1_2 = new JRadioButton("El sw que se encarga de interpretar el códigp Java y ejecutarlo");
        jb_q1_3 = new JRadioButton("Una maquina de cafés");
        bg_q1.add(jb_q1_1);
        bg_q1.add(jb_q1_2);
        bg_q1.add(jb_q1_3);
        panel_q1.add(lbl_q1);
        panel_q1.add(jb_q1_1);
        panel_q1.add(jb_q1_2);
        panel_q1.add(jb_q1_3);
        
        panel_general.add(panel_q1);
        
        title = BorderFactory.createTitledBorder("Pregunta: 2");       
        panel_q2.setBorder(title);
        
        lbl_q2 = new JLabel("Las clases Swing");
        
        jb_q2_1 = new JRadioButton("Dan soporte a los GUI");
        jb_q2_2 = new JRadioButton("Son clases de baile");
        jb_q2_3 = new JRadioButton("Ambas son correctas");
        bg_q2.add(jb_q2_1);
        bg_q2.add(jb_q2_2);
        bg_q2.add(jb_q2_3);
        panel_q2.add(lbl_q2);
        panel_q2.add(jb_q2_1);
        panel_q2.add(jb_q2_2);
        panel_q2.add(jb_q2_3);
        
        panel_general.add(panel_q2);
        
        title = BorderFactory.createTitledBorder("Pregunta: 3");       
        panel_q3.setBorder(title);
        
        lbl_q3 = new JLabel("JavaFX es: ");
        
        jb_q3_1 = new JRadioButton("Los efectos especiales de java");
        jb_q3_2 = new JRadioButton("El nuevo soporte GUI de java");
        jb_q3_3 = new JRadioButton("Ambas son correctas");
        bg_q3.add(jb_q3_1);
        bg_q3.add(jb_q3_2);
        bg_q3.add(jb_q3_3);
        panel_q3.add(lbl_q3);
        panel_q3.add(jb_q3_1);
        panel_q3.add(jb_q3_2);
        panel_q3.add(jb_q3_3);
        
        panel_general.add(panel_q3);
        
        title = BorderFactory.createTitledBorder("Pregunta: 4");       
        panel_q4.setBorder(title);
        
        lbl_q4 = new JLabel("¿NetBeans es pero que Eclipse?: ");
        
        jb_q4_1 = new JRadioButton("Si, pero sólo se pueden desarollar en java");
        jb_q4_2 = new JRadioButton("No, pero sólo Eclipse es de pago");
        jb_q4_3 = new JRadioButton("A y B son incorrectas");
        bg_q4.add(jb_q4_1);
        bg_q4.add(jb_q4_2);
        bg_q4.add(jb_q4_3);
        panel_q4.add(lbl_q4);
        panel_q4.add(jb_q4_1);
        panel_q4.add(jb_q4_2);
        panel_q4.add(jb_q4_3);
        
        panel_general.add(panel_q4);
        
        title = BorderFactory.createTitledBorder("Pregunta: 5");       
        panel_q5.setBorder(title);
        
        lbl_q5 = new JLabel("¿Oracle es la compañia propietaria de Java?: ");
        
        jb_q5_1 = new JRadioButton("Si");
        jb_q5_2 = new JRadioButton("No");
        jb_q5_3 = new JRadioButton("Sólo del 50%");
        bg_q5.add(jb_q5_1);
        bg_q5.add(jb_q5_2);
        bg_q5.add(jb_q5_3);
        panel_q5.add(lbl_q5);
        panel_q5.add(jb_q5_1);
        panel_q5.add(jb_q5_2);
        panel_q5.add(jb_q5_3);
        
        panel_general.add(panel_q5);
        
        panel_general.add(bnt);
        
        
        
    }
    
    
    
    
    
    
}
