package org.aditya.model;

import org.aditya.enums.PAYMENT_TYPE;

public class Payment {
    private int paymentId;
    private PAYMENT_TYPE paymentType;

    public Payment(PAYMENT_TYPE paymentType) {
        this.paymentType = paymentType;
    }
}
