package view;

import DAO.Client;
import DAO.ClientDAO;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author amrsin
 */
public class Frame_JList_printer extends JFrame {

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panelList = new JPanel();
    private JPanel panelList1 = new JPanel();
    private JList list = new JList();
    private JList list1 = new JList();
    private DefaultListModel list_model = new DefaultListModel();
    private DefaultListModel list1_model = new DefaultListModel();
    private JButton btn1, btn2, btn3;

    private List<Client> clients_list;

    public Frame_JList_printer() {

        //windows parameters
        setTitle("JList printer");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //layouts 
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(3, 1, 10, 10));
        panelList.setLayout(new FlowLayout());
        panelList1.setLayout(new FlowLayout());
        add(panel1);

        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(panelList, BorderLayout.WEST);
        panel1.add(panelList1, BorderLayout.EAST);

        add_element();
        list = new JList(list_model);        
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        list.setFixedCellWidth(100);
        panelList.add(list);
        
        list1 = new JList(list1_model);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        list1.setFixedCellWidth(100);
        panelList1.add(list1);

        btn1 = new JButton(">>>");
        btn2 = new JButton("<<<");
        btn3 = new JButton("Print");

        btn_listener listener = new btn_listener();
        btn1.addActionListener(listener);
        btn2.addActionListener(listener);

        panel2.add(btn1);
        panel2.add(btn2);
        panel2.add(btn3);

    }

    public void add_element() {

        list_clients l = new list_clients();
        l.list_clients(list);

    }

    class list_clients {

        private List<Client> clients_list;
        ClientDAO clientDao = new ClientDAO();

        public void list_clients(JList j) {

            try {
                clients_list = clientDao.findAll();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            for (Client c : clients_list) {

                String id = c.getId();
                list_model.addElement(id);
            }
        }
    }

    class btn_listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int index;
            String element;

            if (e.getSource() == btn1) {

                index = list.getSelectedIndex();
                element = (String) list.getSelectedValue();

                if (index >= 0) {

                    list_model.remove(index);
                    list1_model.addElement(element);
                }
            }

            if (e.getSource() == btn2) {

                index = list1.getSelectedIndex();
                element = (String) list1.getSelectedValue();

                if (index >= 0) {

                    list1_model.remove(index);
                    list_model.addElement(element);

                }

            }

        }
    }
}
