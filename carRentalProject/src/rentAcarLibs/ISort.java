/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentAcarLibs;

import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author HP
 */
public interface ISort {
     public void sortBrand(String filterBrand);
     public void sortDate(Date selectedDate);
     public boolean isCarAvailable(int carId, String selectedDay, String selectedMonth, String selectedYear) throws SQLException;
}
