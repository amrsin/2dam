package View;

import Model.Car;
import Controller.CarDao;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.*;

/**
 *
 * @author amrsin
 */
public class Frame_Update extends JDialog{
    //elements and variables
    private JLabel lbl_License_plate, lbl_Brand, lbl_Model, lbl_Year, lbl_Color,
             lbl_Kilometres, lbl_Fuel, lbl_Doors, lbl_Gear_change, lbl_Seats, lbl_price;
    private JTextField txt_License_plate, txt_Brand, txt_Model, txt_Year, txt_Color,
             txt_Kilometres, txt_Fuel, txt_Doors, txt_Seats, txt_price;
    private JComboBox combo_gear;
    private String[] headers = {"License plate: ", "Brand: ", "Model: ", "Year: ", "Color: ", "Kilometres: ",
        "Fuel: ", "Doors: ", "Gear Change: ", "Seats: ", "Price: "};
    private String [] type_gear = {"Manual", "Automatic", "Other"};
    
    private JPanel panel;
    private JButton btn_save;
    
    public Frame_Update(JFrame father, Car c) {
        
        super(father, true);
        //basic config
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        setTitle("Update car");
        //adding elemnts to panel with gridLayout
        GridBagConstraints cons = new GridBagConstraints();
        cons.insets= new Insets(10, 5, 5, 5); 
        cons.anchor = GridBagConstraints.LINE_START;

        lbl_License_plate = new JLabel(headers[0]);
        cons.gridx = 0; cons.gridy = 0;
        panel.add(lbl_License_plate, cons);
       
        lbl_Brand = new JLabel(headers[1]);
        cons.gridx = 0; cons.gridy = 1;
        panel.add(lbl_Brand, cons);
        
        lbl_Model = new JLabel(headers[2]);
        cons.gridx = 0; cons.gridy = 2;
        panel.add(lbl_Model, cons);
        
        lbl_Year = new JLabel(headers[3]);
        cons.gridx = 0; cons.gridy = 3;
        panel.add(lbl_Year, cons);
        
        lbl_Color = new JLabel(headers[4]);
        cons.gridx = 0; cons.gridy = 4;
        panel.add(lbl_Color, cons);
        
        lbl_Kilometres = new JLabel(headers[5]);
         cons.gridx = 0; cons.gridy = 5;
        panel.add(lbl_Kilometres, cons);
        
        lbl_Fuel = new JLabel(headers[6]);
         cons.gridx = 0; cons.gridy = 6;
        panel.add(lbl_Fuel, cons);
        
        lbl_Doors = new JLabel(headers[7]);
         cons.gridx = 0; cons.gridy = 7;
        panel.add(lbl_Doors, cons);
        
        lbl_Gear_change = new JLabel(headers[8]);
         cons.gridx = 0; cons.gridy = 8;
        panel.add(lbl_Gear_change, cons);
        
        lbl_Seats = new JLabel(headers[9]);
         cons.gridx = 0; cons.gridy = 9;
        panel.add(lbl_Seats, cons);
        
        lbl_price = new JLabel(headers[10]);
         cons.gridx = 0; cons.gridy = 10;
        panel.add(lbl_price, cons);
         
        txt_License_plate = new JTextField(c.getLicense_plate(), 8);
        txt_License_plate.setEditable(false);
        cons.gridx = 1; cons.gridy = 0;
        panel.add(txt_License_plate, cons);
        
        txt_Brand = new JTextField(c.getBrand(), 8);
        cons.gridx = 1; cons.gridy = 1;
        panel.add(txt_Brand, cons);
        
        txt_Model = new JTextField(c.getModel(), 8);
        cons.gridx = 1; cons.gridy = 2;
        panel.add(txt_Model, cons);
         
        txt_Year = new JTextField(c.getYear(), 8);
        cons.gridx = 1; cons.gridy = 3;
        panel.add(txt_Year, cons);
        
        txt_Color = new JTextField(c.getColor(), 8);
        cons.gridx = 1; cons.gridy = 4;
        panel.add(txt_Color, cons);
        
        txt_Kilometres = new JTextField(c.getKilometres(), 8);
        cons.gridx = 1; cons.gridy = 5;
        panel.add(txt_Kilometres, cons);
        
        txt_Fuel = new JTextField(c.getFuel(), 8);
        cons.gridx = 1; cons.gridy = 6;
        panel.add(txt_Fuel, cons);
        
        txt_Doors = new JTextField(c.getDoors(), 8);
        cons.gridx = 1; cons.gridy = 7;
        panel.add(txt_Doors, cons);
        
        combo_gear = new JComboBox(type_gear);
        String gear = c.getGear_change();
        combo_gear.setSelectedItem(gear);

        cons.gridx = 1; cons.gridy = 8;
        panel.add(combo_gear, cons);
        
        txt_Seats = new JTextField(c.getSeats(), 8);
        cons.gridx = 1; cons.gridy = 9;
        panel.add(txt_Seats, cons);
        
        txt_price = new JTextField(c.getPrice(), 8);
        cons.gridx = 1; cons.gridy = 10;
        panel.add(txt_price, cons);
        
        btn_save = new JButton("Save");
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0; cons.gridwidth = 2; cons.gridy = 11; 
        btn_save.setBackground(Color.DARK_GRAY);
        btn_save.setForeground(Color.WHITE);
        btn_save.addMouseListener(new btn_mouse_adapter());
        btn_save.addActionListener(new btn_listener());
        panel.add(btn_save, cons);
        add(panel);
    }
      //listener MouseAdapter to change background color when entred and exited
    class btn_mouse_adapter extends MouseAdapter {

        public void mouseEntered(java.awt.event.MouseEvent evt) {
            
            btn_save.setBackground(new Color(143,21,0));   
        }
        
        public void mouseExited(java.awt.event.MouseEvent evt) {
            
            btn_save.setBackground(Color.DARK_GRAY);   
        }
    }
    
    //action listener for btn_save
    class btn_listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            CarDao cardao = new CarDao();
            Car c = new Car(txt_License_plate.getText(), txt_Brand.getText(), txt_Model.getText(), txt_Year.getText(), 
                    txt_Color.getText(), txt_Kilometres.getText(), txt_Fuel.getText(), txt_Doors.getText(), combo_gear.getSelectedItem().toString(),
                    txt_Seats.getText(), txt_price.getText());
            
            cardao.update(c);//calling method update for update data from bd
            setVisible(false);
        }
    }
}