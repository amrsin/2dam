/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author amrsin
 */
public class Frame_ej_1 extends JFrame {

    JPanel panel_pos = new JPanel();
    JPanel panel_combo_list = new JPanel();
    JComboBox combo;
    String curso[] = {"1 DAM", "2 DAM"};
    String one_dam[] = {"ED", "PRO", "FOL"};
    String two_dam[] = {"PMDM", "ADA", "SGA", "EIE"};
    JList list;

    public Frame_ej_1() {

        //basic window config
        setTitle("ej_1");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel_pos.setLayout(new BorderLayout());
        add(panel_pos);

        combo = new JComboBox(curso);
        combo.addItemListener(new listener_combo());
        panel_combo_list.add(combo);

        list = new JList();
        panel_combo_list.add(list);

        panel_pos.add(panel_combo_list, BorderLayout.NORTH);

    }

    class listener_combo implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            String selected = combo.getSelectedItem().toString();

            if (selected.equals("1 DAM")) {

            }

            if (selected.equals("2 DAM")) {

            }
        }

    }

}
