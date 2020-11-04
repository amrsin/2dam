package ej_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author amrsin
 */
public class Frame_ej_1 extends JFrame {

    JPanel panel_pos = new JPanel();
    JPanel panel_combo_list = new JPanel();
    JComboBox combo;
    String curso[] = {"None", "1 DAM", "2 DAM"};
    String one_dam[] = {"ED", "PRO", "FOL"};
    String two_dam[] = {"PMDM", "ADA", "SGE", "EIE"};
    JList list;
    DefaultListModel list_model = new DefaultListModel();

    public Frame_ej_1() {

        //basic window config
        setTitle("ej_1");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel_pos.setLayout(new BorderLayout());
        panel_combo_list.setLayout(new GridLayout(2, 0, 10, 10));
        add(panel_pos);

        combo = new JComboBox(curso);
        combo.addItemListener(new listener_combo());
        panel_combo_list.add(combo);
        list_model.addElement("");
        list = new JList(list_model);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.addListSelectionListener(new listener_list());
        panel_combo_list.add(list);

        panel_pos.add(panel_combo_list, BorderLayout.NORTH);

    }

    class listener_combo implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            String selected = combo.getSelectedItem().toString();

            if (selected.equals("None")) {

                list_model.removeAllElements();

            }
            if (selected.equals("1 DAM")) {

                list_model.removeAllElements();
                for (int i = 0; i < one_dam.length; i++) {

                    list_model.addElement(one_dam[i]);

                }

            }

            if (selected.equals("2 DAM")) {

                list_model.removeAllElements();
                for (int i = 0; i < two_dam.length; i++) {

                    list_model.addElement(two_dam[i]);

                }

            }
        }
    }

    class listener_list implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {

            String s = list.getSelectedValuesList().toString();
            JOptionPane.showMessageDialog(null, s);
        }

    }
}
