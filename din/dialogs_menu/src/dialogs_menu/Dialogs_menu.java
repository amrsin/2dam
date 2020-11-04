package dialogs_menu;

import javax.swing.JOptionPane;

/**
 *
 * @author amrsin
 */
public class Dialogs_menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //JOptionPane.showMessageDialog(null, "Operation Successfull");
        //JOptionPane.showMessageDialog(null, "Message inside window", 
        //  "Message inside window", JOptionPane.WARNING_MESSAGE);
        /*int confirmed = JOptionPane.showConfirmDialog(null, "Do you confirm this?");

        if (JOptionPane.OK_OPTION == confirmed) {
            System.out.println("confirmed");

        } else {
            System.out.println("ok ... I don't delete anything ...");

        }*/
 /* String sel = JOptionPane.showInputDialog(null, "Input dialog" , JOptionPane.QUESTION_MESSAGE);
        
        System.out.println("The user hast typed " + sel);*/
        Object selec = JOptionPane.showInputDialog(
                null,
                "Select option",
                "Options Selector",
                JOptionPane.QUESTION_MESSAGE,
                null, // null for default icon
                new Object[]{"option 1", "option 2", "option 3"},
                "option 1");
        System.out.println("The user has chosen" + selec);

    }
}
