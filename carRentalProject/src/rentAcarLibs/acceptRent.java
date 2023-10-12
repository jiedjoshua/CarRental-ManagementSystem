package rentAcarLibs;


import databasecon.ConnectionManager;
import databasecon.connection;
import java.sql.Connection;

//Note: This abstract class will forward the rented cars in the database
//The following class will use this:
// 1. rentSedan
// 2. rentSuv


abstract class acceptRent {
    Connection con;
    String username;
    String brand;
    String model;
    String transmission;
    String smonth;
    String sday;
    String syear;
    String emonth;
    String eday;
    String eyear;

    public acceptRent(String username, String brand, String model, String transmission, String smonth, String sday, String syear, String emonth, String eday, String eyear) {
        this.con = ConnectionManager.getConnection();
        this.username = username;
        this.brand = brand;
        this.model = model;
        this.transmission = transmission;
        this.smonth = smonth;
        this.sday = sday;
        this.syear = syear;
        this.emonth = emonth;
        this.eday = eday;
        this.eyear = eyear;
    }
    

    public abstract void rentNow(); 
    public abstract boolean checkRentedCars(); 
    public abstract int totalAmount();
   
}

