package View;

import DAO.Car;
import DAO.CarDao;
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

    CarDao cardao = new CarDao();
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    String[] headers = {"License plate", "Brand", "Model", "Year", "Color", "Kilometres",
        "Fuel", "Doors", "Gear Change", "Seats", "Price"};
    JButton btn_new, btn_delete, btn_update, btn_refresh;
    JPanel panel_general = new JPanel();
    JPanel panel_btn = new JPanel();

    public Frame_autodealer() {

        panel_general.setLayout(new BorderLayout());
        panel_btn.setLayout(new FlowLayout());

        setTitle("Auto Dealer");
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        model.setColumnIdentifiers(headers);

        showTable();
        table.setModel(model);
        table.setRowHeight(30);

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < model.getColumnCount(); i++) {

            table.getColumnModel().getColumn(i).setCellRenderer(tcr);

        }

        JScrollPane jScrollPane1 = new JScrollPane(table);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        panel_general.add(jScrollPane1, BorderLayout.CENTER);

        btn_new = new JButton("NEW");
        btn_delete = new JButton("DELETE");
        btn_update = new JButton("UPDATE");
        btn_refresh = new JButton("REFRESH");

        btn_new.addActionListener(new btn_listener());
        btn_delete.addActionListener(new btn_listener());
        btn_update.addActionListener(new btn_update(this));
        btn_refresh.addActionListener(new btn_listener());

        panel_btn.add(btn_new);
        panel_btn.add(btn_delete);
        panel_btn.add(btn_update);
        panel_btn.add(btn_refresh);
        panel_btn.setBackground(Color.WHITE);
        panel_general.add(panel_btn, BorderLayout.SOUTH);

        add(panel_general);
    }

    public void showTable() {

        model = cardao.fillTable(model);
    }

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
                    String Gear_change = JOptionPane.showInputDialog(null, "Enter Gear change");
                    String Seats = JOptionPane.showInputDialog(null, "Enter Seats");
                    String Price = JOptionPane.showInputDialog(null, "Enter Price");

                    if (license_plate.equals("") || Brand.equals("") || Model.equals("") || Year.equals("")
                            || Color.equals("") || Kilometres.equals("") || Fuel.equals("") || Doors.equals("")
                            || Gear_change.equals("") || Seats.equals("") || Price.equals("")) {

                        JOptionPane.showMessageDialog(null, "Nothing is added, you must enter all the data ");
                    } else {

                        Object rowData[] = {license_plate, Brand, Model, Year, Color, Kilometres, Fuel, Doors, Gear_change, Seats, Price};
                        Car c = new Car(license_plate, Brand, Model, Year, Color, Kilometres, Fuel, Doors, Gear_change, Seats, Price);
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

                    int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "YES O NO", JOptionPane.YES_NO_OPTION);
                       if (reply == JOptionPane.YES_OPTION) {
                           
                           String license_plate = table.getValueAt(table.getSelectedRow(), 0).toString();
                           model.removeRow(table.getSelectedRow());
                           Car c = new Car(license_plate);
                           cardao.delete(c);
                           
                        } else {
                        JOptionPane.showMessageDialog(null, "Nothing has been removed");
                    }
                } else {

                    if (table.getRowCount() == 0) {

                        JOptionPane.showMessageDialog(null, "Table is Empty");
                    } else {

                        JOptionPane.showMessageDialog(null, "Please select only single row for delete");

                    }
                }
            }

            if (source == btn_refresh) {

                model.setRowCount(0);
                showTable();
            }

        }

    }

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
                } else {

                    JOptionPane.showMessageDialog(null, "Please select only single row for delete");

                }
            }
        }
    }
}