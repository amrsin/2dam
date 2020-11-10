/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author amrsin
 */
public class DialogModal extends JDialog {

    private JTextField textField;
    
    
    public DialogModal(JFrame padre) {

        super(padre, true);

        setTitle("Mete un dato");
        textField = new JTextField(20);
        add(textField);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
            }
        });
    }

    public String getText() {
        return textField.getText();
    }

}
