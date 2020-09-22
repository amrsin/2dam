package serveral_buttons;

/**
 *
 * @author amrsin
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class srv_buttons extends JFrame {

    JPanel panel = new JPanel();
    private JButton blue, pink, yellow, green;

    public srv_buttons() {
        setTitle("Example with several buttons");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());
        blue = new JButton("Blue");
        // listener
        blue.addActionListener(new listener_button_blue());
        Dimension d = new Dimension();
        d.height = 40;
        d.width = 100;
        blue.setPreferredSize(d);
        green = new JButton("Green");
        // listener
        green.addActionListener(new listener_button_green());
        d.height = 40;
        d.width = 100;
        green.setPreferredSize(d);
        yellow = new JButton("Yellow");
        // listener
        yellow.addActionListener(new listener_button_yellow());
        d.height = 40;
        d.width = 100;
        yellow.setPreferredSize(d);
        pink = new JButton("Pink");
        // listener
        pink.addActionListener(new listener_button_pink());
        d.height = 40;
        d.width = 100;
        pink.setPreferredSize(d);

        panel.add(blue, BorderLayout.SOUTH);
        panel.add(green, BorderLayout.NORTH);
        panel.add(yellow, BorderLayout.EAST);
        panel.add(pink, BorderLayout.WEST);
        add(panel);
        panel.setBackground(Color.red);

    }

    class listener_button_blue implements ActionListener {
        // The actionPerformed method has to be rewritten, it is the one that responds to the button click

        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.blue);

        }

    }

    class listener_button_green implements ActionListener {
        // The actionPerformed method has to be rewritten, it is the one that responds to the button click

        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.green);

        }

    }

    class listener_button_yellow implements ActionListener {
        // The actionPerformed method has to be rewritten, it is the one that responds to the button click

        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.yellow);

        }
    }

    class listener_button_pink implements ActionListener {
        // The actionPerformed method has to be rewritten, it is the one that responds to the button click

        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.pink);
        }
    }
}