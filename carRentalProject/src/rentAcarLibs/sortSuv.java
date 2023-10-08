/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentAcarLibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;

//Note: It will sort the brand and transmission for the rentnow Page (suv)
/**
 *
 * @author HP
 */
public class sortSuv extends carSort{

    public sortSuv(Connection con, JComboBox<String> jc, String selectedBrand) {
        super(jc, selectedBrand);
    }

    @Override
    public void sortBrand() {
         try {
            // Clear existing items in the JComboBox
            jc.removeAllItems();

            // Prepare SQL statement with a placeholder for selected brand
            String sql = "SELECT model FROM suv WHERE brand = ?";
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
    }

    @Override
    public void sortTransmission() {
         try {
            // Clear existing items in the JComboBox
            jc.removeAllItems();

            // Prepare SQL statement with a placeholder for selected brand
            String sql = "SELECT transmission FROM suv WHERE model = ?";
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
    }
    
}
