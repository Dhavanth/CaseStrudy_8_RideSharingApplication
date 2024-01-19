package org.example.ridesharingapplication.services;

import org.example.ridesharingapplication.exceptions.InvalidVehicleException;
import org.example.ridesharingapplication.exceptions.RideNotFoundException;
import org.example.ridesharingapplication.exceptions.UserNotFoundException;
import org.example.ridesharingapplication.models.Ride;
import org.example.ridesharingapplication.models.User;
import org.example.ridesharingapplication.models.Vehicle;
import org.example.ridesharingapplication.repositories.RideRepository;
import org.example.ridesharingapplication.repositories.UserRepository;
import org.example.ridesharingapplication.strategies.RideStrategy;
import org.example.ridesharingapplication.strategies.RideStrategyFactory;

import java.util.List;

public class UserService {
    private UserRepository userRepository;
    private RideRepository rideRepository;


    public void addUser(String name, String gender, int age){
        User newUser = new User(name, gender, age);
        userRepository.addUser(newUser);
        System.out.println("User added successfully");
        System.out.println();
    }

    public void addVehicle(String name, String type, String vehicleNumber){
        User vehicleOwner = userRepository.getUser(name);
        if(vehicleOwner != null){
            Vehicle newVehicle = new Vehicle(name, type, vehicleNumber);
            vehicleOwner.addVehicle(newVehicle);
            System.out.println("Vehicle added successfully");
            System.out.println();
        }else{
            throw new UserNotFoundException("User not found");
        }
    }

    public void offerRide(String driverName, String origin, String destination, String vehicleName, int seatsAvailable){
        User driver = userRepository.getUser(driverName);
        if(driver != null){
            Vehicle vehicle = driver.getVehicle();
            if(vehicle.getVehicleName().equals(vehicleName)){
                Ride newRide = new Ride(driver, origin, destination, seatsAvailable);
                driver.addOfferedRide(newRide);
                System.out.println("Ride offered successfully");
                System.out.println();
                rideRepository.addOfferedRide(newRide);

            }else{
                throw new InvalidVehicleException("Invalid vehicle");
            }
        }else{
            throw new UserNotFoundException("Driver not found");
        }
    }

    public void selectRide(String passengerName, String origin,
                           String destination, int seats, String selectionStrategy){
        User passenger = userRepository.getUser(passengerName);
        if(passenger != null){
            List<Ride> availableRides = rideRepository.filterRides(origin, destination, seats);
            RideStrategy rideStrategy = RideStrategyFactory.getRideStrategyByParameter(selectionStrategy);
            Ride selectedRide = rideStrategy.selectRide(availableRides, selectionStrategy);

            if(selectedRide != null){
                // After selecting a ride, remove that ride from the list of offered rides by that driver
                selectedRide.getDriver().getOfferedRides().remove(selectedRide);
                passenger.addTakenRide(selectedRide);
                rideRepository.addToSelectedRides(selectedRide);
                System.out.println("Ride selected successfully");
            }else{
                System.out.println("No ride found");
            }
        }else{
            throw new UserNotFoundException("Passenger not found");
        }
    }

    public void endRide(Ride ongoingRide){

        if(rideRepository.getSelectedRides().contains(ongoingRide)){
            // After ending a ride, remove that ride from the list of offered rides by that driver and taken rides of passenger
            if(ongoingRide.getDriver().getOfferedRides().contains(ongoingRide)){
                ongoingRide.getDriver().getOfferedRides().remove(ongoingRide);
            }
            ongoingRide.getDriver().getTakenRides().remove(ongoingRide);
            rideRepository.getSelectedRides().remove(ongoingRide);
        }else{
            throw new RideNotFoundException("Ride not found or Ride already ended!");
        }

    }

    public void getUserStats(){
        List<User> users = userRepository.getAllUsers();
        for(User user: users){
            System.out.println("User: " + user.getName());
            System.out.println("Offered rides: " + user.getOfferedRides().size());
            System.out.println("Taken rides: " + user.getTakenRides().size());
            System.out.println();
            System.out.println("===========================");
        }
    }


}
