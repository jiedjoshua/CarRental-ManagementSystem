
package rentAcarLibs;

import com.toedter.calendar.JDateChooser;
import databasecon.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import rentAcar.sedan;

public class table implements ISort{
    private final Connection con;
    public sedan sedcar;
    

      public table(sedan sedcar) {
        this.con = ConnectionManager.getConnection();
        this.sedcar = sedcar; // Initialize the sedan object
    }

    @Override
 public void sortBrand(String filterBrand) {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT brand, model, color, transmission, price, availability FROM sedan");

            // Create a list to store rows of the specified brand
            List<Object[]> filteredRows = new ArrayList<>();

            while (rs.next()) {
                String brandValue = rs.getString("brand");
                String availabilityValue = rs.getString("availability");

                // Check if the car's brand matches the filterBrand or if filterBrand is "All"
                if ("All".equalsIgnoreCase(filterBrand) || brandValue.equalsIgnoreCase(filterBrand)) {
                    String modelValue = rs.getString("model");
                    String colorValue = rs.getString("color");
                    String transmissionValue = rs.getString("transmission");
                    String priceValue = rs.getString("price");
                    String availValue = rs.getString("availability");

                    // Add the row to the filtered list
                    Object[] row = {brandValue, modelValue, colorValue, transmissionValue, priceValue, availValue};
                    filteredRows.add(row);
                }
                
                else if("Available".equals(filterBrand) && "Available".equalsIgnoreCase(availabilityValue)){
                    String modelValue = rs.getString("model");
                    String colorValue = rs.getString("color");
                    String transmissionValue = rs.getString("transmission");
                    String priceValue = rs.getString("price");
                    String availValue = rs.getString("availability");

                    // Add the row to the filtered list
                    Object[] row = {brandValue, modelValue, colorValue, transmissionValue, priceValue, availValue};
                    filteredRows.add(row);
                }
                
                else if (filterBrand == null){
                    String modelValue = rs.getString("model");
                    String colorValue = rs.getString("color");
                    String transmissionValue = rs.getString("transmission");
                    String priceValue = rs.getString("price");
                    String availValue = rs.getString("availability");

                    // Add the row to the filtered list
                    Object[] row = {brandValue, modelValue, colorValue, transmissionValue, priceValue, availValue};
                    filteredRows.add(row);
                }
            }

            // Add filtered rows to the DefaultTableModel
            Object[][] rowsArray = filteredRows.toArray(new Object[0][]);
            DefaultTableModel tableModel = new DefaultTableModel(rowsArray,
                    new String[]{"Brand", "Model", "Color", "Transmission", "Price","Availability"});
            sedcar.getSedantable().setModel(tableModel);

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        } 
    }

    @Override
  public void sortDate(Date selectedDate) {
    try {
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM");
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfDay = new SimpleDateFormat("d");

        String formattedMonth = sdfMonth.format(selectedDate);
        String formattedYear = sdfYear.format(selectedDate);
        String formattedDay = sdfDay.format(selectedDate);

        String sql = "SELECT id, brand, model, color, transmission, price FROM sedan";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        // Create a list to store filtered car details
        List<Object[]> filteredCars = new ArrayList<>();

        while (rs.next()) {
            int carId = rs.getInt("id");
            String brand = rs.getString("brand");
            String model = rs.getString("model");
            String color = rs.getString("color");
            String price = rs.getString("price");
            String transmission = rs.getString("transmission");

            // Check if the carId is rented in the specified day, month, and year range
            boolean isAvailable = isCarAvailable(carId, formattedDay, formattedMonth, formattedYear);

            // Set availability to "Not Available" if the car is rented, otherwise "Available"
            String availability = isAvailable ? "Available" : "Not Available";

            // Add car details to the filteredCars list
            Object[] row = {brand, model, color, transmission, price, availability};
            filteredCars.add(row);
        }

        // Update the table with filtered car details
        DefaultTableModel tableModel = (DefaultTableModel) sedcar.getSedantable().getModel();
        tableModel.setRowCount(0); // Clear existing rows in the table

        for (Object[] carDetails : filteredCars) {
            // Add car details to the table
            tableModel.addRow(carDetails);
        }

    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately in your application
    }
}

    @Override
    public boolean isCarAvailable(int carId, String selectedDay, String selectedMonth, String selectedYear) throws SQLException {
    String sql = "SELECT * FROM rentedcars WHERE carid = ? AND day <= ? AND month = ? AND year = ? AND endday >= ? AND endmonth = ? AND endyear = ?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, carId);
    ps.setString(2, selectedDay);
    ps.setString(3, selectedMonth);
    ps.setString(4, selectedYear);
    ps.setString(5, selectedDay);
    ps.setString(6, selectedMonth);
    ps.setString(7, selectedYear);
    ResultSet rs = ps.executeQuery();
    return !rs.next(); // Returns true if no rented cars match the specified criteria, indicating the car is available
}





}














