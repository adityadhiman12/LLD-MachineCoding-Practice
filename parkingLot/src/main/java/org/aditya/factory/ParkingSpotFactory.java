package org.aditya.factory;

import org.aditya.enums.VEHICLE_TYPE;
import org.aditya.manager.FourWheelerManager;
import org.aditya.manager.ParkingSpotManager;
import org.aditya.manager.TwoWheelerManager;

public class ParkingSpotFactory {
    public ParkingSpotManager getParkingManager(VEHICLE_TYPE vehicleType) {
        switch(vehicleType) {
            case TWO_WHEELER:
                return new TwoWheelerManager();
            case FOUR_WHEELER:
                return new FourWheelerManager();
        }
        return null;
    }

}
