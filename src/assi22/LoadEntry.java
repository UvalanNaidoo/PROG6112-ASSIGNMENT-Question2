/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assi22;

/**
 *
 * @author lab_services_student
 */
public class LoadEntry {
    
    private String tripNumber;
    private String driverName;
    private String product;
    private double quantity;
    private String fuelLevel;

    // Constructor
    public LoadEntry(String tripNumber, String driverName, String product, double quantity, String fuelLevel) {
        this.tripNumber = tripNumber;
        this.driverName = driverName;
        this.product = product;
        this.quantity = quantity;
        this.fuelLevel = fuelLevel;
    }

    // Getters
    public String getTripNumber() {
        return tripNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getFuelLevel() {
        return fuelLevel;
    }
}
    

