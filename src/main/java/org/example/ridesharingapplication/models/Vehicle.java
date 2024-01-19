package org.example.ridesharingapplication.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private String ownerName;
    private String vehicleName;
    private String vehicleNumber;

    public Vehicle(String ownerName, String vehicleType, String vehicleNumber) {
        this.ownerName = ownerName;
        this.vehicleName = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }
}
