
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author amrsin
 */
public class Frame_JList_printer extends JFrame {

    private JPanel panel1, panel2, panelList, panelList1;
    private JList list = new JList();
    private JList list1 = new JList();
    private DefaultListModel list_model = new DefaultListModel(); 
    private DefaultListModel list1_model = new  DefaultListModel();
    private JButton btn1, btn2, btn3;
    
    
    public Frame_JList_printer()  {
        
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        panelList = new JPanel();
        panelList1 = new JPanel();
        
        setTitle("JList printer");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(3, 1, 10, 10));
        panelList.setLayout(new FlowLayout());
        panelList1.setLayout(new FlowLayout());
        add(panel1);
        
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(panelList, BorderLayout.WEST);
        panel1.add(panelList1, BorderLayout.EAST);
                
        list_model.addElement("list element");
        list = new JList(list_model);
        panelList.add(list);
        
        
        list1_model.addElement("list1 element");
        list1 = new JList(list1_model);
        panelList1.add(list1);
        
        
        btn1 = new JButton(">>>");
        btn2 = new JButton("<<<");
        btn3 = new JButton("Print");
        panel2.add(btn1);
        panel2.add(btn2);
        panel2.add(btn3);
        
          
    }
    
    
    
}

class connextion_bd  {
        
    
        
 }
