package practicedialogs;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author amrsin
 */
public class Frame_pDialogs extends JFrame {

    JButton btn_info, btn_advertencia, btn_error, btn_confirmación,
            btn_texto, btn_combo, btn_mas;

    JPanel panel = new JPanel();
    JCheckBox chk_veces, chk_menuado, chk_siempre;

    public Frame_pDialogs() {

        chk_veces = new JCheckBox("A veces");
        chk_menuado = new JCheckBox("A menudo");
        chk_siempre = new JCheckBox("Siempre");

        setTitle("Monitores de JOptionPane");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btn_info = new JButton("Info");
        btn_advertencia = new JButton("Advertencia");
        btn_error = new JButton("Error");
        btn_confirmación = new JButton("Confirmación");
        btn_texto = new JButton("Texto");
        btn_combo = new JButton("Combo");
        btn_mas = new JButton("Más");
        btn_info.addActionListener(new btn_listener());
        btn_advertencia.addActionListener(new btn_listener());
        btn_error.addActionListener(new btn_listener());
        btn_confirmación.addActionListener(new btn_listener());
        btn_texto.addActionListener(new btn_listener());
        btn_combo.addActionListener(new btn_listener());
        btn_mas.addActionListener(new btn_listener());

        panel.add(btn_info);
        panel.add(btn_advertencia);
        panel.add(btn_error);
        panel.add(btn_confirmación);
        panel.add(btn_texto);
        panel.add(btn_combo);
        panel.add(btn_mas);

        add(panel);

    }

    class btn_listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Object source = e.getSource();

            if (source == btn_info) {

                JOptionPane.showMessageDialog(
                        null, "Esto es un mensaje Simple tipo Información");

                JOptionPane.showMessageDialog(
                        null, "Otro mensaje Simple tipo Información pero con titulo",
                        "INFORMATION_MESSAGE",
                        JOptionPane.INFORMATION_MESSAGE);

            }

            if (source == btn_advertencia) {

                JOptionPane.showMessageDialog(
                        null, "Este es un mensje de Advertencia",
                        "WARNING_MESSAGE",
                        JOptionPane.WARNING_MESSAGE);

            }

            if (source == btn_error) {

                JOptionPane.showMessageDialog(
                        null, "Este es un mensje de error",
                        "WARNING_MESSAGE",
                        JOptionPane.ERROR_MESSAGE);

            }

            if (source == btn_confirmación) {

                JOptionPane.showMessageDialog(
                        null, "Este es un mensje de confirmación o pregunta",
                        "QUESTION_MESSAGE",
                        JOptionPane.QUESTION_MESSAGE);

            }

            if (source == btn_texto) {

                try {
                    int num = Integer.parseInt(JOptionPane.showInputDialog(
                            null, "Escribe un numero para multiplicarlo por 2"));

                    JOptionPane.showMessageDialog(
                            null, "El resultado es: 2*" + num + " =" + num * 2);

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            null, "El valor ingresado debe ser númerico",
                            "ERROR_MESSAGE",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            if (source == btn_combo) {

                Object selec = JOptionPane.showInputDialog(
                        null,
                        "Seleccione un Color",
                        "Colores",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Seleccione", "Rojo", "Azul", "Verde", "Amarillo"}, "Seleccione");

                if (selec != null && selec != "Seleccione") {

                    JOptionPane.showMessageDialog(
                            null, "Color Seleccionado " + selec);
                }

            }

            if (source == btn_mas) {

                int confirmed = JOptionPane.showConfirmDialog(null, "Usas mucho el JOptionPane");

                if (JOptionPane.OK_OPTION == confirmed) {

                    JOptionPane.showOptionDialog(
                            null,
                            "Seleccione un opcion",
                            "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new Object[]{chk_veces, chk_menuado, chk_siempre}, null);

                }
                if (JOptionPane.NO_OPTION == confirmed) {
                    JOptionPane.showMessageDialog(null, "Pues es muy útil");

                }
            }

        }

    }

}
