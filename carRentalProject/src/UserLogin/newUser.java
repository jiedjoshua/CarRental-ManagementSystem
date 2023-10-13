
package UserLogin;

import java.sql.Statement;
import databasecon.connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


public class newUser {
    private String fname;
    private String lname;
    private String mNum;
    private String username;
    private String pwd;
    private String licno;
    private connection db;
    
    

    public newUser(String fname, String lname, String mNum, String username, String pwd, String licno) {
        
        this.fname = fname;
        this.lname = lname;
        this.mNum = mNum;
        this.username = username;
        this.pwd = pwd;
        this.licno = licno;
    }
    
    private void validateAndShowError(String value, String fieldName) {
        if (value == null || value.isEmpty()) {
            JOptionPane.showMessageDialog(null, fieldName + " cannot be null or empty", "Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
    }
  
    
 public void addUser(){
     validateAndShowError( fname, "First name");
     validateAndShowError( lname, "Last name");
     validateAndShowError( username, "Username");
     validateAndShowError( pwd, "Password");
     validateAndShowError( licno, "Password");

       
     try {
        Statement s = db.connect().createStatement();
        s.executeUpdate("INSERT INTO usertable (username, password) VALUES ('" + username + "','" + pwd + "')");
        s.executeUpdate("INSERT INTO userinfo (fname, lname, mNum, username, licno) VALUES ('" + fname + "','" + lname + "','" + mNum + "','" + username + "','" + licno + "')");

        JOptionPane.showMessageDialog(null, "Your account has been created!");

    } catch (Exception e) {
        System.out.println(e);
    }
 }
 
 public boolean numCounter(String mNum){
     try{
         
          if (mNum.length() == 11) {
                return true;
            } else {
                return false;
            }
     } catch (NullPointerException e) {
           
            System.err.println("Error: Input string is null.");
            return false;
     } catch (Exception e) {
            System.out.println(mNum.length());
            System.err.println("Error occurred: " + e.getMessage());
            return false;
        }
     
     }
 
         
 
 public boolean isStringInt(String mNum) {
    try {
        long num = Long.parseLong(mNum);
        return num >= 0; // Assuming negative integers are not valid in your context
    } catch (NumberFormatException ex) {
        return false;
    }
}
 
 
 


    
    
    
    
}
