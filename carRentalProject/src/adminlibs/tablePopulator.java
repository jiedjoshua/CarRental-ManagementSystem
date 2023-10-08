/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminlibs;

import carrentalproject.usersTable;
import databasecon.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class tablePopulator implements ITablePopulator{
    
    private final Connection con;
    private usersTable ut;

    public tablePopulator(usersTable ut) {
        this.con = ConnectionManager.getConnection();
        this.ut = ut;
    }
    
    
    @Override
    public void tablepopulator() {
    try {
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT username, fname, lname, mNum, licno FROM userinfo");

        DefaultTableModel model = new DefaultTableModel();
        // Assuming jTable1 is your table component
        JTable jTable1 = ut.getjTable1();
        jTable1.setModel(model);

        // Add columns to the table model
        model.addColumn("Username");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Mobile Number");
        model.addColumn("License Number");

        while (rs.next()) {
            String username = rs.getString("username");
            String fname = rs.getString("fname");
            String lname = rs.getString("lname");
            String mnum = rs.getString("mNum");
            String licno = rs.getString("licno");

            // Add data to the table model
            model.addRow(new Object[]{username, fname, lname, mnum, licno});
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately in your application
    } 
}

    
    
    
}
