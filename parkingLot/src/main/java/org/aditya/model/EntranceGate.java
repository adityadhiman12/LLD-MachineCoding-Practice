package org.aditya.model;

import org.aditya.enums.VEHICLE_TYPE;
import org.aditya.factory.ParkingSpotFactory;
import org.aditya.manager.ParkingSpotManager;

public class EntranceGate {
    private int gateNo;
    private ParkingSpotFactory parkingSpotFactory;
    private ParkingSpotManager parkingSpotManager;
    private Ticket ticket;

    public void findSpace(VEHICLE_TYPE vehicleType, int entranceGateNo) {

    }

    public void bookSpot(Vehicle vehicle) {

    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        return new Ticket();
    }
}
