package org.example.ridesharingapplication.repositories;

import lombok.Getter;
import lombok.Setter;
import org.example.ridesharingapplication.models.Ride;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RideRepository {

    private List<Ride> offeredRides;
    private List<Ride> selectedRides;

    public RideRepository() {
        this.offeredRides = new ArrayList<>();
        this.selectedRides = new ArrayList<>();
    }

    public void addOfferedRide(Ride ride) {
        offeredRides.add(ride);
    }

    public void addToSelectedRides(Ride ride){
        selectedRides.add(ride);
    }

    public List<Ride> filterRides(String origin, String destination, int seatsAvailable) {
        List<Ride> availableRides = new ArrayList<>();
        for (Ride ride : offeredRides) {
            if (ride.getOrigin().equals(origin) &&
                    ride.getDestination().equals(destination) &&
                    ride.getSeatsAvailable() >= seatsAvailable) {
                availableRides.add(ride);
            }
        }

        return availableRides;

//        return rides.stream()
//                .filter(ride -> ride.getOrigin().equals(origin))
//                .filter(ride -> ride.getDestination().equals(destination))
//                .filter(ride -> ride.getSeatsAvailable() >= seatsAvailable)
//                .toList();
    }
}
