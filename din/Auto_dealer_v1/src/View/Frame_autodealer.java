package View;

import Model.Car;
import Controller.CarDao;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author singh
 */
public class Frame_autodealer extends JFrame {
    //elements and varibles
    CarDao cardao = new CarDao();
    JTable table = new JTable();
    DefaultTableModel model;
    String[] headers = {"License plate", "Brand", "Model", "Year", "Color", "Kilometres",
        "Fuel", "Doors", "Gear Change", "Seats", "Price"};
    JButton btn_new, btn_delete, btn_update, btn_refresh, btn_exit;
    JPanel panel_general = new JPanel();
    JPanel panel_btn = new JPanel();

    public Frame_autodealer() {
        //table cannot be edited
         model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
         
        //basic config
        panel_general.setLayout(new BorderLayout()); 
        panel_btn.setLayout(new FlowLayout());
        panel_general.setBackground(Color.WHITE);
        setTitle("Auto Dealer");
        setSize(1150, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel label = new JLabel("\n");
        panel_general.add(label, BorderLayout.NORTH);
        //table && scrollpanel configuration and customization 
        model.setColumnIdentifiers(headers);
        showTable(); //callig method add rows to table
        table.setModel(model);
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 13));
        table.getTableHeader().setBackground(Color.DARK_GRAY);
        table.getTableHeader().setForeground(Color.WHITE);
        table.setSelectionBackground(new Color(143,21,0));
        table.setSelectionForeground(Color.WHITE);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < model.getColumnCount(); i++) {

            table.getColumnModel().getColumn(i).setCellRenderer(tcr);

        }
        JScrollPane jScrollPane1 = new JScrollPane(table);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        panel_general.add(jScrollPane1, BorderLayout.CENTER);
        //Creating and customizating elements
        btn_new = new JButton("NEW");
        btn_new.setBackground(Color.DARK_GRAY);
        btn_new.setForeground(Color.WHITE);
        btn_new.setFocusable(false);
        btn_new.addMouseListener(new btn_mouse_adapter());
        btn_delete = new JButton("DELETE");
        btn_delete.setBackground(Color.DARK_GRAY);
        btn_delete.setForeground(Color.WHITE);
        btn_delete.setFocusable(false);
        btn_delete.addMouseListener(new btn_mouse_adapter());
        btn_update = new JButton("UPDATE");
        btn_update.setBackground(Color.DARK_GRAY);
        btn_update.setForeground(Color.WHITE);
        btn_update.setFocusable(false);
        btn_update.addMouseListener(new btn_mouse_adapter());
        btn_refresh = new JButton("REFRESH");
        btn_refresh.setBackground(Color.DARK_GRAY);
        btn_refresh.setForeground(Color.WHITE);
        btn_refresh.setFocusable(false);
        btn_refresh.addMouseListener(new btn_mouse_adapter());
        btn_exit = new JButton("EXIT");
        btn_exit.setBackground(Color.DARK_GRAY);
        btn_exit.setForeground(Color.WHITE);
        btn_exit.setFocusable(false);
        btn_exit.addMouseListener(new btn_mouse_adapter());
        //adding action listener to btn's
        btn_new.addActionListener(new btn_listener());
        btn_delete.addActionListener(new btn_listener());
        btn_update.addActionListener(new btn_update(this));
        btn_refresh.addActionListener(new btn_listener());
        btn_exit.addActionListener(new btn_listener());
        //adding butons to panel_btn
        panel_btn.add(btn_new);
        panel_btn.add(btn_delete);
        panel_btn.add(btn_update);
        panel_btn.add(btn_refresh);
        panel_btn.add(btn_exit);
        panel_btn.setBackground(Color.WHITE);
        panel_general.add(panel_btn, BorderLayout.SOUTH);//adding panel_btn in panel_general in south position
        //adding panel_general
        add(panel_general);
    }
    //method for call select_fillTable to collect data from db and add to table
    public void showTable() {

        model = cardao.select_fillTable(model);
    }
    //listener MouseAdapter to change background color when entred and exited
    class btn_mouse_adapter extends MouseAdapter {

        public void mouseEntered(java.awt.event.MouseEvent evt) {
            
            Object source = evt.getSource();
            
            if (source == btn_new) {
                btn_new.setBackground(new Color(143,21,0));   
            }else if (source == btn_delete) {
                btn_delete.setBackground(new Color(143,21,0));
            }else if (source == btn_update) {
                btn_update.setBackground(new Color(143,21,0));
            }else if (source == btn_refresh) {
                btn_refresh.setBackground(new Color(143,21,0));
            }else if (source == btn_exit) {
                btn_exit.setBackground(new Color(143,21,0));
            }
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            
            Object source = evt.getSource();

            if (source == btn_new) {
                btn_new.setBackground(Color.DARK_GRAY);   
            }else if (source == btn_delete) {
                btn_delete.setBackground(Color.DARK_GRAY);
            }else if (source == btn_update) {
                btn_update.setBackground(Color.DARK_GRAY);
            }else if (source == btn_refresh) {
                btn_refresh.setBackground(Color.DARK_GRAY);
            }else if (source == btn_exit) {
                btn_exit.setBackground(Color.DARK_GRAY);
            }            
        }      
    }
    //action listen for btn's
    class btn_listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Object source = e.getSource();

            if (source == btn_new) {

                try {

                    String license_plate = JOptionPane.showInputDialog(null, "Enter License plate");
                    String Brand = JOptionPane.showInputDialog(null, "Enter Brand");
                    String Model = JOptionPane.showInputDialog(null, "Enter Model");
                    String Year = JOptionPane.showInputDialog(null, "Enter Year");
                    String Color = JOptionPane.showInputDialog(null, "Enter Color");
                    String Kilometres = JOptionPane.showInputDialog(null, "Enter Kilometres");
                    String Fuel = JOptionPane.showInputDialog(null, "Enter Fuel");
                    String Doors = JOptionPane.showInputDialog(null, "Enter Doors");
                    Object Gear_change = JOptionPane.showInputDialog (
                            null,
                            "Select option",
                            "Options Selector",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new Object[]{"", "Manual", "Automatic", "Other"},
                            "");
                    
                    String Seats = JOptionPane.showInputDialog(null, "Enter Seats");
                    String Price = JOptionPane.showInputDialog(null, "Enter Price");

                    if (license_plate.equals("") || Brand.equals("") || Model.equals("") || Year.equals("")
                            || Color.equals("") || Kilometres.equals("") || Fuel.equals("") || Doors.equals("")
                            || Gear_change.toString().equals("") || Seats.equals("") || Price.equals("")) {

                        JOptionPane.showMessageDialog(null, "Nothing is added, you must enter all the data ");
                    } else {

                        Object rowData[] = {license_plate, Brand, Model, Year, Color, Kilometres, Fuel, Doors, Gear_change, Seats, Price};
                        Car c = new Car(license_plate, Brand, Model, Year, Color, Kilometres, Fuel, Doors, Gear_change.toString(), Seats, Price);
                        int registro = cardao.insert(c);

                        if (registro > 0) {
                            model.addRow(rowData);

                        }
                    }
                } catch (java.lang.NullPointerException ex) {

                    JOptionPane.showMessageDialog(null, "Nothing is added, you must enter all the data ");

                }
            }
            if (source == btn_delete) {

                if (table.getSelectedRowCount() == 1) {
                    
                    String license_plate = table.getValueAt(table.getSelectedRow(), 0).toString();
                    int reply = JOptionPane.showConfirmDialog(null, "DELETE car with \"" + license_plate + "\" license plate?" , "DELETE", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {

                        model.removeRow(table.getSelectedRow());
                        Car c = new Car(license_plate);
                        cardao.delete(c);

                    } else {
                        JOptionPane.showMessageDialog(null, "Nothing has been removed");
                        
                    }
                } else {
                    

                    if (table.getRowCount() == 0) {

                        JOptionPane.showMessageDialog(null, "Table is Empty");
                    }else {
                        JOptionPane.showMessageDialog(null, "Please select any row");
                    }
                }
            }

            if (source == btn_refresh) {

                model.setRowCount(0);
                showTable();
               JOptionPane.showMessageDialog(null, "Data updated from bd");

            }
            
            if (source == btn_exit) {
                
                int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to EXIT?", "EXIT", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        System.exit(0);                        
                    } 
            }
        }
    }
    //action listener for btn_update
    class btn_update implements ActionListener {

        JFrame miFrame;

        public btn_update(JFrame f) {

            miFrame = f;

        }

        public void actionPerformed(ActionEvent ae) {

            if (table.getSelectedRowCount() == 1) {

                Car c = null;
                String license_plate = table.getValueAt(table.getSelectedRow(), 0).toString();
                String Brand = table.getValueAt(table.getSelectedRow(), 1).toString();
                String Model = table.getValueAt(table.getSelectedRow(), 2).toString();
                String Year = table.getValueAt(table.getSelectedRow(), 3).toString();
                String Color = table.getValueAt(table.getSelectedRow(), 4).toString();
                String Kilometres = table.getValueAt(table.getSelectedRow(), 5).toString();
                String Fuel = table.getValueAt(table.getSelectedRow(), 6).toString();
                String Doors = table.getValueAt(table.getSelectedRow(), 7).toString();
                String Gear_change = table.getValueAt(table.getSelectedRow(), 8).toString();
                String Seats = table.getValueAt(table.getSelectedRow(), 9).toString();
                String Price = table.getValueAt(table.getSelectedRow(), 10).toString();
                c = new Car(license_plate, Brand, Model, Year, Color, Kilometres, Fuel, Doors, Gear_change, Seats, Price);

                Frame_Update f = new Frame_Update(miFrame, c);
                f.pack();
                f.setSize(350, 470);
                f.setVisible(true);
                model.setRowCount(0);
                showTable();

            } else {

                if (table.getRowCount() == 0) {

                    JOptionPane.showMessageDialog(null, "Table is Empty");
                }else {
                    JOptionPane.showMessageDialog(null, "Please select any row");
                }
            }
        }
    }
  }