package View;

import DAO.Car;
import java.awt.HeadlessException;
import javax.swing.*;

/**
 *
 * @author amrsin
 */
public class Frame_Update extends JDialog{
    
    private JLabel lbl_License_plate, lbl_Brand, lbl_Model, lbl_Year, lbl_Color,
             lbl_Kilometres, lbl_Fuel, lbl_Doors, lbl_Gear_change, lbl_Seats, lbl_price;
   
    private JTextField txt_License_plate, txt_Brand, txt_Model, txt_Year, txt_Color,
             txt_Kilometres, txt_Fuel, txt_Doors, txt_Gear_change, txt_Seats, txt_price;
   
    private String[] headers = {"License plate", "Brand", "Model", "Year", "Color", "Kilometres",
        "Fuel", "Doors", "Gear Change", "Seats", "Price"};
    
    
    public Frame_Update(JFrame father, Car c) {

        
        super(father, true);
        setTitle("Update car");        
        setLocationRelativeTo(null);
        lbl_License_plate = new JLabel(headers[0]);
        lbl_Brand = new JLabel(headers[1]);
        lbl_Model = new JLabel(headers[2]);
        lbl_Year = new JLabel(headers[3]);
        lbl_Color = new JLabel(headers[4]);
        lbl_Kilometres = new JLabel(headers[5]);
        lbl_Fuel = new JLabel(headers[6]);
        lbl_Doors = new JLabel(headers[7]);
        lbl_Gear_change = new JLabel(headers[8]);
        lbl_Seats = new JLabel(headers[9]);
        lbl_price = new JLabel(headers[10]);

        txt_License_plate = new JTextField(c.getLicense_plate());
        
        add(txt_License_plate);
        

    }    
}