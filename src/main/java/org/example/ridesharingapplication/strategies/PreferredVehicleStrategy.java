package org.example.ridesharingapplication.strategies;

import org.example.ridesharingapplication.models.Ride;

import java.util.Comparator;
import java.util.List;

public class PreferredVehicleStrategy implements RideStrategy{

        @Override
        public Ride selectRide(List<Ride> rides, String vehicleName) {
            String preferredVehicle = vehicleName.substring("Preferred Vehicle=".length());
            Ride selectedRide = rides.stream()
                    .filter(r -> r.getDriver().getVehicle().getVehicleName().equals(preferredVehicle))
                    .max(Comparator.comparingInt(Ride::getSeatsAvailable))
                    .orElse(null);

            return selectedRide;
        }
}
