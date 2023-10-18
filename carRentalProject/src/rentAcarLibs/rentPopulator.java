

//NOTE: THIS THE UPDATED VERSION OF RENTNOW SEDAN
// USED IN SELECTEDSEDAN
package rentAcarLibs;

import databasecon.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rentAcar.sedan;
import rentAcar.selectedSedan;

public class rentPopulator {
    Connection con;
    sedan s;
    selectedSedan select;

    public rentPopulator(sedan s, selectedSedan select) {
        this.con = ConnectionManager.getConnection();
        this.s = s;
        this.select = select;
    }
    
    
public void populateTable() {
    int selectedRow = s.getSedantable().getSelectedRow(); // Get the selected row index
    String seat = null;
    String fuel = null;
    int carid = 0;

    // Check if a valid row is selected
    if (selectedRow >= 0) {
        String brand = (String) s.getSedantable().getValueAt(selectedRow, 0); 
        String model = (String) s.getSedantable().getValueAt(selectedRow, 1); 
        String transmission = (String) s.getSedantable().getValueAt(selectedRow, 3);  
        String color = (String) s.getSedantable().getValueAt(selectedRow, 2); 
        String price = (String) s.getSedantable().getValueAt(selectedRow, 4); 

        String car = brand + " " + model;

        try {
            String sql = "SELECT id, seat, fuel FROM sedan WHERE brand = ? AND model = ? AND transmission = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, brand);
            ps.setString(2, model); // Use parameter index 2 for the model
            ps.setString(3, transmission); // Use parameter index 3 for the transmission
            ResultSet rs = ps.executeQuery();

            // Populate the JComboBox with models of the selected brand
            if (rs.next()) {
                seat = rs.getString("seat");
                fuel = rs.getString("fuel");
                carid = rs.getInt("id");
            }

            // Set the values in your GUI components
            select.getBrandName().setText(car);
            select.getColorType().setText(color);
            select.getTransType().setText(transmission);
            select.getPrice().setText(price);
            select.getFuelType().setText(fuel);
            select.getSeatType().setText(seat + " seater");
            select.getCarId().setText(Integer.toString(carid));
            
            

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }
}





}



    
    
    

