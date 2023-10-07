/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminlibs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import carrentalproject.rentedCarsTable;

/**
 *
 * @author HP
 */
public class rentedCarsPopulator implements ITablePopulator {
    
    private Connection con;
    private rentedCarsTable rc;

    public rentedCarsPopulator(Connection con, rentedCarsTable rc) {
        this.con = con;
        this.rc = rc;
    }
   
    
    @Override
    public void tablepopulator() {
        try {
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT username, brand, model, transmission, month, day, year FROM rentedcars");

        DefaultTableModel model = new DefaultTableModel();
        // Assuming jTable1 is your table component
        JTable jTable1 = rc.getjTable1();
        jTable1.setModel(model);

        // Add columns to the table model
        model.addColumn("Username");
        model.addColumn("Brand");
        model.addColumn("Model");
        model.addColumn("Transmission");
        model.addColumn("Month");
        model.addColumn("Day");
        model.addColumn("Year");

        while (rs.next()) {
            String username = rs.getString("username");
            String brand = rs.getString("brand");
            String modelval = rs.getString("model");
            String transmission = rs.getString("transmission");
            String month = rs.getString("month");
            String day = rs.getString("day");
            String year = rs.getString("year");

            // Add data to the table model
            model.addRow(new Object[]{username, brand, modelval, transmission, month, day, year});
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately in your application
    } finally {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }
  }
}
    

