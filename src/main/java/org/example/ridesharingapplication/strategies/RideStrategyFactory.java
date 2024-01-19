package org.example.ridesharingapplication.strategies;

public class RideStrategyFactory {

    public static RideStrategy getRideStrategyByParameter(String strategyName) {
        if (strategyName.equals("Most Vacant"))
            return new MostVacantStrategy();
        else if (strategyName.startsWith("Preferred Vehicle="))
            return new PreferredVehicleStrategy();
        return null;
    }
}
