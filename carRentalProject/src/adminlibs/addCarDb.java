/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminlibs;

import UserLogin.Session;
import carrentalproject.addNow;
import databasecon.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class addCarDb {
    addNow ad;
    Connection con;

    public addCarDb(addNow ad) {
        this.ad = ad;
        this.con = ConnectionManager.getConnection();
    }
    
    public void addCar(String type){
        
    try {
        type = type.toLowerCase();
        String brand = (String) ad.getBrand().getSelectedItem();
        String model = ad.getModel().getText();
        String seat = ad.getSeat().getText();
        String color = ad.getColor().getText();
        String transmission = (String) ad.getTrans().getSelectedItem();
        String fuel = (String) ad.getFuel().getSelectedItem();
        String price = ad.getPrice().getText();
        
        String sql = "INSERT INTO " + type + " (brand, model, seat, color, transmission, fuel, price,availability) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, brand);
        preparedStatement.setString(2, model);
        preparedStatement.setString(3, seat);
        preparedStatement.setString(4, color);
        preparedStatement.setString(5, transmission);
        preparedStatement.setString(6, fuel);
        preparedStatement.setString(7,price);
        preparedStatement.setString(8,"Available");

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Car added to the table.");
        } else {
            System.out.println("Failed to add car to the table.");
        }

        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace(); // Log the exception for debugging purposes
        JOptionPane.showMessageDialog(null, "Error occurred while adding the car to rented cars table. Please try again later.");
    }
  }
                
}

