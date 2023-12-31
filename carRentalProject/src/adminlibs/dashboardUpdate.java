/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminlibs;

// This class will update the total users, total rented cars and total earnings

import carrentalproject.adminDash;
import databasecon.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class dashboardUpdate {
    final Connection con;
    adminDash ad;

    public dashboardUpdate(adminDash ad) {
        this.con = ConnectionManager.getConnection();
        this.ad = ad;
    }
    
    public void usersCount(){
        try {
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT COUNT(*) as count FROM userinfo");

        if (rs.next()) {
            int count = rs.getInt("count");
            ad.getTotalAccounts().setText(Integer.toString(count));
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately in your application
    } finally {
       
    }
  }
    
    public void rentedCarsCount(){
         try {
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT COUNT(*) as count FROM rentedcars");

        if (rs.next()) {
            int count = rs.getInt("count");
            ad.getTotalRentedCars().setText(Integer.toString(count));
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately in your application
    } 
   }
    
    public void totalEarnings(){
    try {
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT SUM(total) as total_earnings FROM rentedcars");

        if (rs.next()) {
            int totalEarnings = rs.getInt("total_earnings");
            ad.getTotalEarnings().setText(Integer.toString(totalEarnings));
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately in your application
    } finally {
        
    }
}

}
  


