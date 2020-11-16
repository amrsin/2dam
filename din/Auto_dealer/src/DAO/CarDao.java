package DAO;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author singh
 */
public class CarDao {
    
    private static String sql_select = "select * from car"; 
    private static String sql_insert = "INSERT INTO car VALUES (?,?,?,?,?,?,?,?,?,?,?)"; 
    private static String sql_delete = "DELETE FROM car WHERE license_plate = ?";
    private static String sql_update = "UPDATE car SET Brand = ?, Model = ?, Year = ?, Color = ?, Kilometres = ?, Fuel = ?, Doors = ?, Gear_change = ?, Seats = ?, Price = ? WHERE license_plate = ?";


    public DefaultTableModel fillTable(DefaultTableModel model) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Car c;
        try {

            con = Connection_BD.OpenConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql_select);

            while (rs.next()) {

                c = new Car(rs.getString("License_plate"), rs.getString("Brand"), rs.getString("Model"), rs.getString("Year"), rs.getString("Color"), rs.getString("Kilometres"), rs.getString("Fuel"), rs.getString("Doors"), rs.getString("Gear_change"), rs.getString("Seats"), rs.getString("Price"));
                Object[] rowData = new Object[model.getColumnCount()];
                rowData[0] = c.getLicense_plate();
                rowData[1] = c.getBrand();
                rowData[2] = c.getModel();
                rowData[3] = c.getYear();
                rowData[4] = c.getColor();
                rowData[5] = c.getKilometres();
                rowData[6] = c.getFuel();
                rowData[7] = c.getDoors();
                rowData[8] = c.getGear_change();
                rowData[9] = c.getSeats();
                rowData[10] = c.getPrice();
                model.addRow(rowData);

            }
        } catch (Exception e) {// SQLException and ClassNotFoundException
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {

            try {
                rs.close();
                stmt.close();
                Connection_BD.CloseConnection(con);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }
        return model;
    }

    public int insert(Car c) {

        Connection con = null;
        PreparedStatement stmt = null;
        int registry = 0;
        try {

            con = Connection_BD.OpenConnection();
            stmt = con.prepareStatement(sql_insert);
            stmt.setString(1, c.getLicense_plate());
            stmt.setString(2, c.getBrand());
            stmt.setString(3, c.getModel());
            stmt.setString(4, c.getYear());
            stmt.setString(5, c.getColor());
            stmt.setString(6, c.getKilometres());
            stmt.setString(7, c.getFuel());
            stmt.setString(8, c.getDoors());
            stmt.setString(9, c.getGear_change());
            stmt.setString(10, c.getSeats());
            stmt.setString(11, c.getPrice());

            registry = stmt.executeUpdate();
            if (registry > 0) {

                JOptionPane.showMessageDialog(null, "Inserted car with " + c.getLicense_plate() + " license plate");
            }
        } catch (Exception e) {// SQLException and ClassNotFoundException
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {

            try {
                stmt.close();
                Connection_BD.CloseConnection(con);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }
        return registry;
    }

    public int delete(Car c) {

        Connection con = null;
        PreparedStatement stmt = null;
        int registry = 0;
        try {

            con = Connection_BD.OpenConnection();
            stmt = con.prepareStatement(sql_delete);
            stmt.setString(1, c.getLicense_plate());
            registry = stmt.executeUpdate();
            if (registry > 0) {
                JOptionPane.showMessageDialog(null, "Deleted car with " + c.getLicense_plate() + " license plate");

            }
        } catch (Exception e) {// SQLException and ClassNotFoundException
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {

            try {
                stmt.close();
                Connection_BD.CloseConnection(con);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }
        return registry;
    }
    
    public int update(Car c) {

        Connection con = null;
        PreparedStatement stmt = null;
        int registry = 0;
        try {
            con = Connection_BD.OpenConnection();
            stmt = con.prepareStatement(sql_update);
            stmt.setString(1, c.getBrand());
            stmt.setString(2, c.getModel());
            stmt.setString(3, c.getYear());
            stmt.setString(4, c.getColor());
            stmt.setString(5, c.getKilometres());
            stmt.setString(6, c.getFuel());
            stmt.setString(7, c.getDoors());
            stmt.setString(8, c.getGear_change());
            stmt.setString(9, c.getSeats());
            stmt.setString(10, c.getPrice());
            stmt.setString(11, c.getLicense_plate());
            
            registry = stmt.executeUpdate();
            if (registry > 0) {
                JOptionPane.showMessageDialog(null, "Updated car with " + c.getLicense_plate() + " license plate");

            }
        } catch (Exception e) {// SQLException and ClassNotFoundException
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {

            try {
                stmt.close();
                Connection_BD.CloseConnection(con);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }
        return registry;
    }
}