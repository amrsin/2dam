
package jtable_with_bd;

import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amrsin
 */
public class Frame_JTable_bd extends JFrame {
    
   
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    
    public Frame_JTable_bd() {
        
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Object[] tags = new Object[2];
        tags[0] = "ID";
        tags[1] = "Notes";
        model.setColumnIdentifiers(tags);
       

        Connection con = null;

        Statement s = null;
        ResultSet rs = null;
        try {
            String urlOdbc = "jdbc:mysql://localhost:3306/di?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", "din123"));

            s = con.createStatement();
            rs = s.executeQuery("select * from clients");

            int row_num = 0;

            while (rs.next()) {

                Object[] rowData = new Object[model.getColumnCount()];
                rowData[0] = rs.getObject(1);
                rowData[1] = rs.getObject(2);
                model.addRow(rowData);
                row_num++;

            }
        } catch (Exception e) {// SQLException and ClassNotFoundException
            e.printStackTrace();
        } finally {

            try {
                rs.close();
                s.close();
                con.close();
            } catch (Exception e) {
            }
        }
        
        table.setModel(model);
        JScrollPane jScrollPane1 = new JScrollPane(table);
        add(jScrollPane1);
    } 
}
