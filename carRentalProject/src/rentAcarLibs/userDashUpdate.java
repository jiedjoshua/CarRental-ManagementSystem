/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentAcarLibs;

import UserLogin.Session;
import carrentalproject.dashboard;
import databasecon.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class userDashUpdate {
    final Connection con;
    dashboard d;

    public userDashUpdate(dashboard d) {
        this.con = ConnectionManager.getConnection();
        this.d = d;
    }
    
     public void rentedCarsCount(String username) {
     try {
       
        // Create a PreparedStatement with parameterized query
        String query = "SELECT COUNT(*) as count FROM rentedcars WHERE username = ?";
        PreparedStatement ps = con.prepareStatement(query);
        
        // Set the username parameter in the prepared statement
        ps.setString(1, username);

        // Execute the query
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int count = rs.getInt("count");
            
            // Assuming d.getTotalRentedCars() returns a GUI component
            d.getTotalRentedCars().setText(Integer.toString(count));
        }
        
        // Close the ResultSet and PreparedStatement after use
        rs.close();
        ps.close();
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately in your application
    }
}

    
    
}
