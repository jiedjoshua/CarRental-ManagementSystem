package rentAcarLibs;


import databasecon.connection;


//Note: This abstract class will forward the rented cars in the database
//The following class will use this:
// 1. rentSedan
// 2. rentSuv


abstract class acceptRent {
    connection con;
    String username;
    String brand;
    String model;
    String transmission;
    String smonth;
    String sday;
    String syear;
    String emonth;
    String eday;
    String eyear;

    public acceptRent(String username, String brand, String model, String transmission, String smonth, String sday, String syear, String emonth, String eday, String eyear) {
        this.con = new connection();
        this.username = username;
        this.brand = brand;
        this.model = model;
        this.transmission = transmission;
        this.smonth = smonth;
        this.sday = sday;
        this.syear = syear;
        this.emonth = emonth;
        this.eday = eday;
        this.eyear = eyear;
    }
    

    
    public abstract void rentNow(); /*{
    try (Connection connection = con.connect()) {
        String insertSql = "INSERT INTO rentedcars (username, brand, model, transmission, month, day, year, endmonth, endday, endyear) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String updateAvailabilitySql = "UPDATE sedan SET availability = 'Not Available' WHERE brand = ? AND model = ? AND transmission = ?";
        
        // Insert rental record
        PreparedStatement insertStatement = connection.prepareStatement(insertSql);
        insertStatement.setString(1, username);
        insertStatement.setString(2, brand);
        insertStatement.setString(3, model);
        insertStatement.setString(4, transmission);
        insertStatement.setString(5, smonth);
        insertStatement.setString(6, sday);
        insertStatement.setString(7, syear);
        insertStatement.setString(8, emonth);
        insertStatement.setString(9, eday);
        insertStatement.setString(10, eyear);
        
        int rowsAffected = insertStatement.executeUpdate();
        
        if (rowsAffected > 0) {
            // Update sedan availability
            PreparedStatement updateAvailabilityStatement = connection.prepareStatement(updateAvailabilitySql);
            updateAvailabilityStatement.setString(1, brand);
            updateAvailabilityStatement.setString(2, model);
            updateAvailabilityStatement.setString(3, transmission);
            updateAvailabilityStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Rent successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Rent failed. Please try again.");
        }

    } catch (Exception e) {
        e.printStackTrace(); // Log the exception for debugging purposes
        JOptionPane.showMessageDialog(null, "Error occurred while renting the car. Please try again later.");
    }
}

    
 */
public abstract boolean checkRentedCars(); /*{
    try (Connection connection = con.connect()) {
        String sql = "SELECT * FROM rentedcars WHERE brand = ? AND model = ? AND transmission = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, brand);
        preparedStatement.setString(2, model);
        preparedStatement.setString(3, transmission);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String existingStartDate = resultSet.getString("month") + resultSet.getString("day") + resultSet.getString("year");
            String existingEndDate = resultSet.getString("endmonth") + resultSet.getString("endday") + resultSet.getString("endyear");
            String newStartDate = smonth + sday + syear;
            String newEndDate = emonth + eday + eyear;

            // Check for overlap
            if ((newStartDate.compareTo(existingEndDate) <= 0 && newStartDate.compareTo(existingStartDate) >= 0) ||
                (newEndDate.compareTo(existingEndDate) <= 0 && newEndDate.compareTo(existingStartDate) >= 0)) {
                // Overlapping rental period found, the car is already rented
                return true;
            }
        }

        // No overlapping rental period found, the car is available for rent
        return false;

    } catch (Exception e) {
        e.printStackTrace(); // Log the exception for debugging purposes
        JOptionPane.showMessageDialog(null, "Error occurred while checking the rented cars. Please try again later.");
        return false; // Return false in case of an error
    }
}

*/
   
}

