/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentAcarLibs;


interface IRent {
    
    public boolean isCarAvailable();
    public void addRentedCar();
    public String getMonthString(int month);
    public int total();
    public int convertMonthToInt(String month);
   
}
