package Userlogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UserLogin {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

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
                    return true;
                }
            }
            JOptionPane.showMessageDialog(null, "Username or password is incorrect!");
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
