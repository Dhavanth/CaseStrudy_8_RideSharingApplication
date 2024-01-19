package org.example.ridesharingapplication.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User {
    private String name;
    private String gender;
    private int age;
    private Vehicle vehicle;
    private List<Ride> offeredRides;
    private List<Ride> takenRides;

    public User(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicle = null;
        this.offeredRides = new ArrayList<>();
        this.takenRides = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void addOfferedRide(Ride ride) {
        this.offeredRides.add(ride);
    }

    public void addTakenRide(Ride ride) {
        this.takenRides.add(ride);
    }




}
