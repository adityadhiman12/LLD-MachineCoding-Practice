package org.aditya.factory;

import org.aditya.enums.VEHICLE_TYPE;
import org.aditya.model.Ticket;
import org.aditya.strategy.CostComputationStrategy;
import org.aditya.strategy.FourWheelerCostComputationStrategy;
import org.aditya.strategy.TwoWheelCostComputationStrategy;

public class CostComputationFactory {
    public CostComputationStrategy getCostFromVehicle(Ticket ticket) {
        VEHICLE_TYPE vehicleType = ticket.getVehicleType();
        switch (vehicleType) {
            case TWO_WHEELER:
                return new TwoWheelCostComputationStrategy();
            case FOUR_WHEELER:
                return new FourWheelerCostComputationStrategy();
        }
        return null;
    }

}
