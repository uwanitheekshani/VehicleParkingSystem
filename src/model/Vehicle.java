package model;

public class Vehicle {
    private String vehicleNum;
    private String vehicleType;
    private String maxWeight;
    private String numPassengers;

    public Vehicle() {
    }

    public Vehicle(String vehicleNum, String vehicleType, String maxWeight, String numPassengers) {
        this.vehicleNum = vehicleNum;
        this.vehicleType = vehicleType;
        this.maxWeight = maxWeight;
        this.numPassengers = numPassengers;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(String maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(String numPassengers) {
        this.numPassengers = numPassengers;
    }
}
