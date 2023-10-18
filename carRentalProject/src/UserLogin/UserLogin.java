package Userlogin;

// This class is used in login frame


import databasecon.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UserLogin {
    private Connection con;
    private String username;
    private String password;

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
        this.con = ConnectionManager.getConnection(); // Assuming you have a ConnectionManager class to establish database connection.
    }

    public boolean validateUser() {
        try {
            String query = "SELECT * FROM usertable WHERE username = ? AND password = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            return rs.next(); // If there is a matching user in the database, rs.next() will return true.

        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } 
    }
    
    public String getUserFullName(String enteredUsername, String enteredPassword) {
    try {
        Statement s = con.createStatement();
        ResultSet resultSet = s.executeQuery("SELECT ut.username, ui.fname, ui.lname FROM usertable ut INNER JOIN userinfo ui ON ut.username = ui.username WHERE ut.username = '" + enteredUsername + "' AND ut.password = '" + enteredPassword + "'");

        if (resultSet.next()) {
            String firstName = resultSet.getString("fname");
            String lastName = resultSet.getString("lname");
            return firstName;
        } else {
            return null; // User not found or invalid credentials
        }
    } catch (Exception e) {
        System.out.println(e);
        return null;
    }
}
    
}
