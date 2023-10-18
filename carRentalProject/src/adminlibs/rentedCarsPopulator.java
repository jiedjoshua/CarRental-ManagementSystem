/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminlibs;

// This class will populate the table will rented cars


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import carrentalproject.rentedCarsTable;
import databasecon.ConnectionManager;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class rentedCarsPopulator implements ITablePopulator {
    
    private Connection con;
    private rentedCarsTable rc;

    public rentedCarsPopulator(rentedCarsTable rc) {
        this.con = ConnectionManager.getConnection();
        this.rc = rc;
    }
   

    @Override
    public void tablepopulator() {
        try {
        int total = 0;
        int carid = 0;

        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT username, carid, month, day, year, total FROM rentedcars");

        DefaultTableModel model = new DefaultTableModel();
        JTable jTable1 = rc.getjTable1(); // Assuming rc is initialized properly
        jTable1.setModel(model);

        // Add columns to the table model
        model.addColumn("Username");
        model.addColumn("Car");
        model.addColumn("Transmission");
        model.addColumn("Month");
        model.addColumn("Day");
        model.addColumn("Year");
        model.addColumn("Total Amount");

        while (rs.next()) {
            String username = rs.getString("username");
            carid = rs.getInt("carid");
            String month = rs.getString("month");
            String day = rs.getString("day");
            String year = rs.getString("year");
            total = rs.getInt("total");

            String brand = "";
            String transmission = "";
            String modelcar = "";

            // Retrieve car information using carid
            String carSql = "SELECT brand, model, transmission FROM sedan WHERE id = ?";
            String suvSql = "SELECT brand, model, transmission FROM suv WHERE id = ?";

            // Create separate PreparedStatements for car and suv queries
            try (PreparedStatement carStatement = con.prepareStatement(carSql);
                 PreparedStatement suvStatement = con.prepareStatement(suvSql)) {
                carStatement.setInt(1, carid);
                suvStatement.setInt(1, carid);

                ResultSet carInfo = carStatement.executeQuery();
                ResultSet suvInfo = suvStatement.executeQuery();

                if (carInfo.next()) {
                    brand = carInfo.getString("brand");
                    modelcar = carInfo.getString("model");
                    transmission = carInfo.getString("transmission");
                } else if (suvInfo.next()) {
                    brand = suvInfo.getString("brand");
                    modelcar = suvInfo.getString("model");
                    transmission = suvInfo.getString("transmission");
                }

                brand = brand + " " + modelcar;

                // Add data to the table model
                model.addRow(new Object[]{username, brand, transmission, month, day, year, total});
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately in your application
    }
    }

}

    

