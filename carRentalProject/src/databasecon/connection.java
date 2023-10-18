/*package databasecon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class connection {
 

    public static Connection connect() {
       Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/carrentaldb", "root", "");
            System.out.println("Database connection established successfully!");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error connecting to the database: " + ex.getMessage());
        }
        return con;
    }
}*/
