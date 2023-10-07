/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentAcarLibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class rentSedan extends acceptRent {

    public rentSedan(String username, String brand, String model, String transmission, String smonth, String sday, String syear, String emonth, String eday, String eyear) {
        super(username, brand, model, transmission, smonth, sday, syear, emonth, eday, eyear);
    }

    @Override
    public void rentNow() {
         try (Connection connection = con.connect()) {
        String insertSql = "INSERT INTO rentedcars (username, brand, model, transmission, month, day, year, endmonth, endday, endyear, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String updateAvailabilitySql = "UPDATE sedan SET availability = 'Not Available' WHERE brand = ? AND model = ? AND transmission = ?";
        
        // Insert rental record
        
        int total = totalAmount();
        
        PreparedStatement insertStatement = connection.prepareStatement(insertSql);
        insertStatement.setString(1, username);
        insertStatement.setString(2, brand);
        insertStatement.setString(3, model);
        insertStatement.setString(4, transmission);
        insertStatement.setString(5, smonth);
        insertStatement.setString(6, sday);
        insertStatement.setString(7, syear);
        insertStatement.setString(8, emonth);
        insertStatement.setString(9, eday);
        insertStatement.setString(10, eyear);
        insertStatement.setInt(11, total);
        
        
        int rowsAffected = insertStatement.executeUpdate();
        
        if (rowsAffected > 0) {
            // Update sedan availability
            PreparedStatement updateAvailabilityStatement = connection.prepareStatement(updateAvailabilitySql);
            updateAvailabilityStatement.setString(1, brand);
            updateAvailabilityStatement.setString(2, model);
            updateAvailabilityStatement.setString(3, transmission);
            updateAvailabilityStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Rent successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Rent failed. Please try again.");
        }

    } catch (Exception e) {
        e.printStackTrace(); // Log the exception for debugging purposes
        JOptionPane.showMessageDialog(null, "Error occurred while renting the car. Please try again later.");
    }
    }

    @Override
    public boolean checkRentedCars() {
        try (Connection connection = con.connect()) {
        String sql = "SELECT * FROM rentedcars WHERE brand = ? AND model = ? AND transmission = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, brand);
        preparedStatement.setString(2, model);
        preparedStatement.setString(3, transmission);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String existingStartDate = resultSet.getString("month") + resultSet.getString("day") + resultSet.getString("year");
            String existingEndDate = resultSet.getString("endmonth") + resultSet.getString("endday") + resultSet.getString("endyear");
            String newStartDate = smonth + sday + syear;
            String newEndDate = emonth + eday + eyear;

            // Check for overlap
            if ((newStartDate.compareTo(existingEndDate) <= 0 && newStartDate.compareTo(existingStartDate) >= 0) ||
                (newEndDate.compareTo(existingEndDate) <= 0 && newEndDate.compareTo(existingStartDate) >= 0)) {
                // Overlapping rental period found, the car is already rented
                return true;
            }
        }

        // No overlapping rental period found, the car is available for rent
        return false;

    } catch (Exception e) {
        e.printStackTrace(); // Log the exception for debugging purposes
        JOptionPane.showMessageDialog(null, "Error occurred while checking the rented cars. Please try again later.");
        return false; // Return false in case of an error
    }
  }
    
    
  public int totalAmount(){
      
     int totalDays = Integer.parseInt(sday) + Integer.parseInt(eday);
     totalDays = totalDays - 1;
     try {
        Connection connection = con.connect();
        String sql ="SELECT price FROM sedan WHERE brand = ? AND model = ? AND transmission = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, brand);
        preparedStatement.setString(2, model);
        preparedStatement.setString(3, transmission);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int price = resultSet.getInt("price");
            int totalPrice = price * totalDays;
            return totalPrice;
        } else {
            System.out.println("Car not found in the database.");
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately in your application
    } 
    
     
     return 0;
  }
    
}
