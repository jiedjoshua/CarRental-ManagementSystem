package rentAcarLibs;


// Abstract that will be used in the following classes:
// 1. sortSedan
// 2. sortSuv

//Note: It will sort the brand and transmission for the rentnow Page


import databasecon.connection;
import java.sql.Connection;
import javax.swing.JComboBox;

abstract class carSort {
     final Connection con;
     JComboBox<String> jc;
     String selectedBrand;
     connection db;

    public carSort(Connection con, JComboBox<String> jc, String selectedBrand) {
        this.con = con;
        this.jc = jc;
        this.selectedBrand = selectedBrand;
    }

    public abstract void sortBrand(); /*{
        try {
            // Clear existing items in the JComboBox
            jc.removeAllItems();

            // Prepare SQL statement with a placeholder for selected brand
            String sql = "SELECT model FROM sedan WHERE brand = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, selectedBrand);
            ResultSet rs = ps.executeQuery();

            // Populate the JComboBox with models of the selected brand
            while (rs.next()) {
                String modelValue = rs.getString("model");
                jc.addItem(modelValue);
            }

            // Close the ResultSet and PreparedStatement
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } */
    
   public abstract void sortTransmission(); /*{
       try {
            // Clear existing items in the JComboBox
            jc.removeAllItems();

            // Prepare SQL statement with a placeholder for selected brand
            String sql = "SELECT transmission FROM sedan WHERE model = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, selectedBrand);
            ResultSet rs = ps.executeQuery();
            System.out.println("Selected Model: " + selectedBrand);


            // Populate the JComboBox with models of the selected brand
            while (rs.next()) {
                String modelValue = rs.getString("transmission");
                jc.addItem(modelValue);
                System.out.println(modelValue);
            }

            // Close the ResultSet and PreparedStatement
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
   } */
   
   
 
   
           
}
