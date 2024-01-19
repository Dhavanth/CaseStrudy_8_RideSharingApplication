package org.example.ridesharingapplication.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ride {
    private User driver;
    private String origin;
    private String destination;
    private int seatsAvailable;

    public Ride(User driver, String origin, String destination, int seatsAvailable) {
        this.driver = driver;
        this.origin = origin;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
    }
}
