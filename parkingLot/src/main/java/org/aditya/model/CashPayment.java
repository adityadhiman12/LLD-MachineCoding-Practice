package org.aditya.model;

import org.aditya.enums.PAYMENT_TYPE;

public class CashPayment extends Payment{
    public CashPayment() {
        super(PAYMENT_TYPE.CASH);
    }
}
