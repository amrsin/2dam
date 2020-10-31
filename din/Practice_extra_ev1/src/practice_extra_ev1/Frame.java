package practice_extra_ev1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author amrit
 */
public class Frame extends JFrame {

    JPanel panel_general = new JPanel();
    JPanel panel_combo = new JPanel();
    String[] combo_names = {"None", "Blue", "Red", "Green", "Pink"};
    Color[] combo_color = {panel_combo.getBackground(), Color.BLUE, Color.RED, Color.GREEN, Color.pink};
    JComboBox combo;
    JPanel panel_checkbox_radio = new JPanel();
    JLabel check_label;
    JCheckBox check_bold, check_italic;

    public Frame() {

        setTitle("Practice");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel_general.setLayout(new BorderLayout());
        panel_combo.setLayout(new GridLayout(1, 2));
        add(panel_general);

        JLabel combo_label = new JLabel(" Choose backgroud color: ");
        panel_combo.add(combo_label);
        combo = new JComboBox(combo_names);
        combo.addItemListener(new listener_combo());
        panel_combo.add(combo);
        panel_general.add(panel_combo, BorderLayout.NORTH);

        check_label = new JLabel(" Choose text font: ");
        check_label.setFont(new Font("serif", Font.PLAIN, 14));

        check_bold = new JCheckBox("Bold text");
        check_italic = new JCheckBox("Italic text");
        check_bold.addItemListener(new listener_check());
        check_italic.addItemListener(new listener_check());

        panel_checkbox_radio.add(check_label);
        panel_checkbox_radio.add(check_bold);
        panel_checkbox_radio.add(check_italic);
        panel_general.add(panel_checkbox_radio, BorderLayout.SOUTH);

    }

    class listener_combo implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            int selected_item = combo.getSelectedIndex();

            panel_general.setBackground(combo_color[selected_item]);

        }
    }

    class listener_check implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            int font_type = Font.PLAIN;

            if (check_bold.isSelected()) {

                font_type += Font.BOLD;

            }

            if (check_italic.isSelected()) {

                font_type += Font.ITALIC;

            }

            check_label.setFont(new Font("Serif", font_type, 14));

        }
    }
}
