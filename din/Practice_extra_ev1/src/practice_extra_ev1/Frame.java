package practice_extra_ev1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 *
 * @author amrit
 */
public class Frame extends JFrame {

    JPanel panel_general = new JPanel();
    JPanel panel_combo = new JPanel();
    String[] combo_names = {"None", "Blue", "Red", "Green", "Pink"};
    Color[] combo_color = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.pink};
    JComboBox combo;
    JPanel panel_checkbox_radio = new JPanel();
    JLabel combo_label, check_label, list_label;
    JCheckBox check_bold, check_italic;
    ButtonGroup bg = new ButtonGroup();
    JRadioButton radio_12, radio_24, radio_34;
    JPanel panel_list = new JPanel();
    JList list;

    public Frame() {

        setTitle("Practice");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel_general.setLayout(new BorderLayout());
        panel_combo.setLayout(new GridLayout(1, 2));
        panel_checkbox_radio.setLayout(new GridLayout(1, 2));
        panel_list.setLayout(new GridLayout(2, 0));

        add(panel_general);

        combo_label = new JLabel(" Choose backgroud color: ");
        panel_combo.add(combo_label);
        combo = new JComboBox(combo_names);
        combo.addItemListener(new listener_combo());
        panel_combo.add(combo);
        panel_general.add(panel_combo, BorderLayout.NORTH);

        check_label = new JLabel(" text ");
        check_label.setFont(new Font("serif", Font.PLAIN, 12));

        check_bold = new JCheckBox("Bold text");
        check_italic = new JCheckBox("Italic text");
        check_bold.addItemListener(new listener_check());
        check_italic.addItemListener(new listener_check());
        panel_checkbox_radio.add(check_label);
        panel_checkbox_radio.add(check_bold);
        panel_checkbox_radio.add(check_italic);

        radio_12 = new JRadioButton("DEFAULT");
        radio_24 = new JRadioButton("Size 24");
        radio_34 = new JRadioButton("Size 34");
        bg.add(radio_12);
        bg.add(radio_24);
        bg.add(radio_34);
        radio_12.addItemListener(new listener_radio());
        radio_24.addItemListener(new listener_radio());
        radio_34.addItemListener(new listener_radio());
        panel_checkbox_radio.add(radio_12);
        panel_checkbox_radio.add(radio_24);
        panel_checkbox_radio.add(radio_34);

        panel_general.add(panel_checkbox_radio, BorderLayout.SOUTH);

        list_label = new JLabel("List text");
        list = new JList(combo_names);
        list.addListSelectionListener(new listener_list());
        panel_list.add(list_label);
        panel_list.add(list);
        panel_general.add(panel_list, BorderLayout.CENTER);

    }

    class listener_combo implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            int selected_item = combo.getSelectedIndex();

            combo_label.setForeground(combo_color[selected_item]);

        }
    }

    class listener_check implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            Font f = check_label.getFont();
            int font_type = Font.PLAIN;

            if (check_bold.isSelected()) {

                font_type += Font.BOLD;

            }

            if (check_italic.isSelected()) {

                font_type += Font.ITALIC;

            }

            check_label.setFont(new Font("Serif", font_type, f.getSize()));

        }
    }

    class listener_radio implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            Font f = check_label.getFont();

            if (radio_12.isSelected()) {

                check_label.setFont(new Font("Serif", f.getStyle(), 12));

            }

            if (radio_24.isSelected()) {

                check_label.setFont(new Font("Serif", f.getStyle(), 24));

            }

            if (radio_34.isSelected()) {

                check_label.setFont(new Font("Serif", f.getStyle(), 34));

            }
        }
    }

    class listener_list implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {

            String selected_item = list.getSelectedValue().toString();

            list_label.setText(selected_item);

        }
    }
}