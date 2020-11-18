
package Model;

/**
 *
 * @author singh
 */
public class Car {
    
    private String License_plate;
    private String Brand;
    private String Model;
    private String Year;
    private String Color;
    private String Kilometres;
    private String Fuel;
    private String Doors;
    private String Gear_change;
    private String Seats;
    private String price;

    public Car() {
    }
    
    public Car(String License_plate) {
        
       this.License_plate = License_plate;
    }

    public Car(String License_plate, String Brand, String Model, String Year, String Color, String Kilometres, String Fuel,String Doors, String Gear_change, String Seats, String price) {
        this.License_plate = License_plate;
        this.Brand = Brand;
        this.Model = Model;
        this.Year = Year;
        this.Color = Color;
        this.Kilometres = Kilometres;
        this.Fuel = Fuel;
        this.Doors = Doors;
        this.Gear_change = Gear_change;
        this.Seats = Seats;
        this.price = price;
    }

    public String getLicense_plate() {
        return License_plate;
    }

    public String getBrand() {
        return Brand;
    }

    public String getModel() {
        return Model;
    }

    public String getYear() {
        return Year;
    }

    public String getColor() {
        return Color;
    }

    public String getKilometres() {
        return Kilometres;
    }

    public String getFuel() {
        return Fuel;
    }
    
     public String getDoors() {
        return Doors;
    }


    public String getGear_change() {
        return Gear_change;
    }

    public String getSeats() {
        return Seats;
    }

    public String getPrice() {
        return price;
    }
    
}
