package org.example.ridesharingapplication.strategies;

import org.example.ridesharingapplication.models.Ride;

import java.util.Collections;
import java.util.List;

public class MostVacantStrategy implements RideStrategy {

    @Override
    public Ride selectRide(List<Ride> rides, String vehicleName) {

        rides.sort((ride1, ride2) -> ride1.getSeatsAvailable() - ride2.getSeatsAvailable());
        Collections.reverse(rides);
        return rides.get(0);

//
//        return rides.stream()
//                .max((ride1, ride2) -> ride1.getSeatsAvailable() - ride2.getSeatsAvailable())
//                .orElse(null);
    }
}
