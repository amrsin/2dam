package first_window;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class j_checkbox extends JFrame {

    private JTextField fieldText; // show the text in changing fonts
    private JCheckBox boldJCheckBox; // to select / deselect bold
    private JCheckBox italicJCheckBox; // to select / deselect italic

// The constructor of MarcoCasillaVerification adds JCheckBox objects to JFrame
    public j_checkbox() {
        setTitle("JCheckBox Test");
        setSize(300, 200); //window size
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

// set JTextField and its font
        fieldText = new JTextField("Notice how the font style changes", 20);
        fieldText.setFont(new Font("Serif", Font.PLAIN, 14));
        add(fieldText); // add textField to JFrame

        boldJCheckBox = new JCheckBox("Bold"); // create "bold" check box
        italicJCheckBox = new JCheckBox("Italic"); // create "italic" check box
        add(boldJCheckBox); // add "bold" checkbox to JFrame
        add(italicJCheckBox); // add "italic" check box to JFrame

// JCheckBox listener
        HandlerCheckBox handler = new HandlerCheckBox();
        boldJCheckBox.addItemListener(handler);
        italicJCheckBox.addItemListener(handler);
    }

// class for the listener of the JCheckBox, in this case it is not an ActionListener as in the buttons, it is an ItemListener
    private class HandlerCheckBox implements ItemListener {

        private int valNegrita = Font.PLAIN; // controls the bold font style
        private int valCursiva = Font.PLAIN; // controls the italic font style

// when the state of a JCheckBox changes:
        public void itemStateChanged(ItemEvent event) {
// process the events of the "bold" check box
            if (event.getSource() == boldJCheckBox) {
                valNegrita = boldJCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;
            }

// process the events in the "italic" check box
            if (event.getSource() == italicJCheckBox) {
                valCursiva = italicJCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;
            }

// set the font of the text field
            fieldText.setFont(new Font("Serif", valNegrita + valCursiva, 14));
        }
    }
}
