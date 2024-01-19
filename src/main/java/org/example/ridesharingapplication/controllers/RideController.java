package org.example.ridesharingapplication.controllers;

import org.example.ridesharingapplication.services.UserService;

public class RideController {

    private UserService userService;

    public RideController(UserService userService) {
        this.userService = userService;
    }


    public void addUser(String name, String gender, int age){
        userService.addUser(name,gender,age);
    }

    public void addVehicle(String ownerName, String type, String vehicleNumber){
        userService.addVehicle(ownerName,type,vehicleNumber);
    }

    public void offerRide(String driverName, String origin, String destination, String vehicleName, int seatsAvailable){
        userService.offerRide(driverName, origin, destination, vehicleName, seatsAvailable);
    }

    public void selectRide(String passengerName, String origin,
                           String destination, int seats, String selectionStrategy){
        userService.selectRide(passengerName, origin, destination, seats, selectionStrategy);
    }

    public void getAllUserStats(){
        userService.getUserStats();
    }


}
