/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminlibs;

import carrentalproject.addNow;

/**
 *
 * @author HP
 */
interface IControl {
    
    public void updateType(addNow ac);
    public void deleteCar(String type);
    public void updateBrands(addNow ac);
}
