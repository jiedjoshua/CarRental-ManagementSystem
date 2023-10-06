/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rentAcarLibs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import rentAcar.suv;

public class tablesuv {
    private final Connection con;
    private suv suvcar;
    

      public tablesuv(Connection con, suv suvcar) {
        this.con = con;
        this.suvcar = suvcar; // Initialize the sedan object
    }

public void tablePopulator(Comparator<Object[]> comparator, String filterBrand) {
    try {
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT brand, model, color, transmission, price, availability FROM suv");

        // Create a list to store rows of the specified brand
        List<Object[]> filteredRows = new ArrayList<>();

        while (rs.next()) {
            String brandValue = rs.getString("brand");
            String availabilityValue = rs.getString("availability");
            
            // Check if there is no filterBrand specified or if the car's brand matches the filterBrand
       if(filterBrand == "Toyota" || filterBrand == "Mitsubishi" || filterBrand == "Nissan"|| filterBrand == "Ford" || filterBrand == "Default"){
            if (filterBrand == null || filterBrand.isEmpty() || brandValue.equalsIgnoreCase(filterBrand)) {
                String modelValue = rs.getString("model");
                String colorValue = rs.getString("color");
                String transmissionValue = rs.getString("transmission");
                String priceValue = rs.getString("price");
               

                // Add the row to the filtered list
                Object[] row = {brandValue, modelValue, colorValue, transmissionValue, priceValue, availabilityValue};
                filteredRows.add(row);
            }
            
          }
       
       else 
           if (filterBrand == null || filterBrand.isEmpty() || availabilityValue.equalsIgnoreCase(filterBrand)) {
                String modelValue = rs.getString("model");
                String colorValue = rs.getString("color");
                String transmissionValue = rs.getString("transmission");
                String priceValue = rs.getString("price");

                // Add the row to the filtered list
                Object[] row = {brandValue, modelValue, colorValue, transmissionValue, priceValue, availabilityValue};
                filteredRows.add(row);
       
       }

        // Sort the filtered rows using the specified comparator
        filteredRows.sort(comparator);

        // Add sorted rows to the DefaultTableModel
        Object[][] rowsArray = filteredRows.toArray(new Object[0][]);
        DefaultTableModel tableModel = new DefaultTableModel(rowsArray, new String[]{"Brand", "Model", "Color", "Transmission", "Price", "Availability"});
        suvcar.getSuvtable().setModel(tableModel);
            System.out.println("done");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  

  }

}


