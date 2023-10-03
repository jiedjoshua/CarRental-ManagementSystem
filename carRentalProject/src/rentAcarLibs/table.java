package rentAcarLibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rentAcar.sedan;

public class table {
    private final Connection con;
    private sedan sedcar;
    

      public table(Connection con, sedan sedcar) {
        this.con = con;
        this.sedcar = sedcar; // Initialize the sedan object
    }

public void tablePopulator(){    
        try {
           
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT model, color, transmission, availability FROM sedan");

            DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{},new String[]{"Model", "Color", "Transmission", "Availability"});
            sedcar.getSedantable().setModel(tableModel);

            
            while (rs.next()) {
                String modelValue = rs.getString("model");
                String colorValue = rs.getString("color");
                String transmissionValue = rs.getString("transmission");
                String availabilityValue = rs.getString("availability");

                // Add a new row to the sedantable
                 tableModel.addRow(new Object[]{modelValue, colorValue, transmissionValue, availabilityValue});
                

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
