package Userlogin;

import databasecon.connection;
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
    private PreparedStatement pst;
    private ResultSet rs;
    private String username;
    private String password;
    private connection db;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserLogin(Connection con) {
        this.con = con;
    }

    public boolean validateLogin(String username, String password) {
        try {
            pst = con.prepareStatement("SELECT * FROM usertable");
            rs = pst.executeQuery();

            while (rs.next()) {
                String uname = rs.getString("username");
                String pwd = rs.getString("password");

                if (username.equals(uname) && password.equals(pwd)) {
                    this.username = uname;
                    this.password = uname;
                    return true;
                }
            }
            JOptionPane.showMessageDialog(null, "Username or password is incorrect!");
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public String getUserFullName(String enteredUsername, String enteredPassword) {
    try {
        Statement s = db.connect().createStatement();
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
