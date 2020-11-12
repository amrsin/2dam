package practice_jtable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amrsin
 */
public class Frame_JTable extends JFrame {

    //headers for the colums
    String[] headers = new String[]{
        "Name", "Address", "Telephone", "Car?"
    };

    //data for the table 
    Object[][] data = new Object[][]{
        {"Alfons González Pi", "Argentona, Barcelona", new Long(933333333), true},
        {"Ana María Cuesta Suñer", "Gijón, Asturias", new Long(984454545), false},
        {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
        {"Pedro Aguado Rodríguez", "Madrid", new Long(912804574), true}
    };

    public Frame_JTable() {
        setSize(800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTable jTable1 = new JTable();
        jTable1.setModel(new DefaultTableModel(data, headers) {

            Class[] ColumType = {String.class, String.class,
                Long.class,
                Boolean.class
            };

            @Override
            public Class getColumnClass(int indColumn) {
                return ColumType[indColumn];
            }

        });
        JScrollPane jScrollPane1 = new JScrollPane(jTable1);

        add(jScrollPane1);

    }

}
