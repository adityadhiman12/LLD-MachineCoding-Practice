package org.aditya.strategy;

import org.aditya.model.Ticket;

public interface PricingStrategy {
    public void priceStrategy(Ticket ticket);
}
