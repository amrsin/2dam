package View;

import DAO.CarDao;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author singh
 */
public class Frame_autodealer extends JFrame {

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
        panel_btn.add(btn_new);
        panel_btn.add(btn_delete);
        panel_btn.add(btn_update);
        panel_btn.add(btn_refresh);
        panel_btn.setBackground(Color.WHITE);
        panel_general.add(panel_btn, BorderLayout.SOUTH);

        add(panel_general);
    }

    public void showTable() {

        CarDao c = new CarDao();
        model = c.fillTable(model);
    }
}