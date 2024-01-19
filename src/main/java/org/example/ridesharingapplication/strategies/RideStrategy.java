package org.example.ridesharingapplication.strategies;

import org.example.ridesharingapplication.models.Ride;

import java.util.List;

public interface RideStrategy {

    public Ride selectRide(List<Ride> rides, String vehicleName);
}
