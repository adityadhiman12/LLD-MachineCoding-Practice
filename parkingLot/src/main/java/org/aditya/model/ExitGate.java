package org.aditya.model;

import org.aditya.factory.CostComputationFactory;
import org.aditya.manager.ParkingSpotManager;
import org.aditya.strategy.PricingStrategy;

public class ExitGate {
    private Ticket ticket;
    private CostComputationFactory costComputationFactory;
    private Payment payment;
    private ParkingSpotManager parkingSpotManager; // to free the parking spots
    private PricingStrategy pricingStrategy;

    public void calculatePrice() {

    }
    public void removeVehicle() {

    }

    public void initiatePayment() {

    }
}
