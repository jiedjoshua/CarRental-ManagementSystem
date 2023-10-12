/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// NOTE: THIS IS THE UPDATED VERSION OF RENTNOWSUV
// THIS WILL BE USED IN THE SELECTEDSEDAN
package rentAcarLibs;

import UserLogin.Session;
import databasecon.ConnectionManager;
import rentAcar.selectedSedan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class addtoRentHistory {
    selectedSedan select;
    Connection con;
    int day1;
    int day2;
    
    
       

public addtoRentHistory(selectedSedan select) {
        this.select = select;
        this.con = ConnectionManager.getConnection();    
    }
    

public boolean isCarAvailable() {
    boolean isAvailable = false;
    try {
        String brand = select.getCarId().getText();
        
        

        Date selectedDate1 = select.getpDate().getDate();
        Date selectedDate2 = select.getrDate().getDate();

        // Check if dates are null before using them
        if (selectedDate1 != null && selectedDate2 != null) {
            String sql = "SELECT * FROM rentedcars WHERE carid = ? " +
                         "AND year <= ? AND month <= ? AND day <= ? " +
                         "AND endyear >= ? AND endmonth >= ? AND endday >= ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(brand));

            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(selectedDate1);
            String startYear = String.valueOf(calendar1.get(Calendar.YEAR));
            String startMonth = getMonthString(calendar1.get(Calendar.MONTH) + 1); // Month is 0-based
            String startDay = String.valueOf(calendar1.get(Calendar.DAY_OF_MONTH));

            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(selectedDate2);
            String endYear = String.valueOf(calendar2.get(Calendar.YEAR));
            String endMonth = getMonthString(calendar2.get(Calendar.MONTH) + 1); // Month is 0-based
            String endDay = String.valueOf(calendar2.get(Calendar.DAY_OF_MONTH));

            preparedStatement.setString(2, startYear);
            preparedStatement.setString(3, startMonth);
            preparedStatement.setString(4, startDay);
            preparedStatement.setString(5, endYear);
            preparedStatement.setString(6, endMonth);
            preparedStatement.setString(7, endDay);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if the specific car within the given date range is available in the rentedcars table
            if (resultSet.next()) {
                isAvailable = true; // Car found in the rented cars
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
        } else {
            System.out.println("Invalid dates selected."); // Handle the case where dates are null
        }
    } catch (Exception e) {
        e.printStackTrace(); // Log the exception for debugging purposes
        JOptionPane.showMessageDialog(null, "Error occurred while checking the rented cars. Please try again later.");
    }
    return isAvailable;
}



public void addRentedCar() {
    try {
        String username = Session.getUsername();
        String carId = select.getCarId().getText();
        int total = total();
        
        Date selectedStartDate = select.getpDate().getDate();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(selectedStartDate);
        String startYear = String.valueOf(calendar1.get(Calendar.YEAR));
        String startMonth = getMonthString(calendar1.get(Calendar.MONTH) + 1); // Month is 0-based
        String startDay = String.valueOf(calendar1.get(Calendar.DAY_OF_MONTH));

        Date selectedEndDate = select.getrDate().getDate();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(selectedEndDate);
        String endYear = String.valueOf(calendar2.get(Calendar.YEAR));
        String endMonth = getMonthString(calendar2.get(Calendar.MONTH) + 1); // Month is 0-based
        String endDay = String.valueOf(calendar2.get(Calendar.DAY_OF_MONTH));

        String sql = "INSERT INTO rentedcars (username, carid, month, day, year, endmonth, endday, endyear, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setInt(2, Integer.parseInt(carId));
        preparedStatement.setString(3, startMonth);
        preparedStatement.setString(4, startDay);
        preparedStatement.setString(5, startYear);
        preparedStatement.setString(6, endMonth);
        preparedStatement.setString(7,endDay);
        preparedStatement.setString(8, endYear);
        preparedStatement.setString(9,Integer.toString(total));

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Car added to rented cars table.");
        } else {
            System.out.println("Failed to add car to rented cars table.");
        }

        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace(); // Log the exception for debugging purposes
        JOptionPane.showMessageDialog(null, "Error occurred while adding the car to rented cars table. Please try again later.");
    }
}



private String getMonthString(int month) {
    String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };
    return months[month - 1]; // Month is 1-based in this method
}

 private int total() {
    Calendar calendar1 = Calendar.getInstance();
    calendar1.setTime(select.getpDate().getDate());
    int day1 = calendar1.get(Calendar.DAY_OF_MONTH);

    Calendar calendar2 = Calendar.getInstance();
    calendar2.setTime(select.getrDate().getDate());
    int day2 = calendar2.get(Calendar.DAY_OF_MONTH);

    int totalDays = day2 - day1;
    int price = Integer.parseInt(select.getPrice().getText());

    int total = totalDays * price;

    return total;
}
    

// Helper method to convert month strings to integers
private int convertMonthToInt(String month) {
    String[] months = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };
    
    for (int i = 0; i < months.length; i++) {
        if (month.equalsIgnoreCase(months[i])) {
            return i + 1; // Return 1-based index
        }
    }
    return -1; // Invalid month string
}

}
