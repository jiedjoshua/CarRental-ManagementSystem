
package rentAcarLibs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import rentAcar.sedan;

public class table {
    private final Connection con;
    private sedan sedcar;
    

      public table(Connection con, sedan sedcar) {
        this.con = con;
        this.sedcar = sedcar; // Initialize the sedan object
    }

public void tablePopulator(Comparator<Object[]> comparator, String filterBrand) {
    try {
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT brand, model, color, transmission, price, availability FROM sedan");

        // Create a list to store rows of the specified brand
        List<Object[]> filteredRows = new ArrayList<>();

        while (rs.next()) {
            String brandValue = rs.getString("brand");
            String availabilityValue = rs.getString("availability");
            
            // Check if there is no filterBrand specified or if the car's brand matches the filterBrand
       if(filterBrand == "Toyota" || filterBrand == "Mitsubishi" || filterBrand == "Honda"){
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
        sedcar.getSedantable().setModel(tableModel);
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

