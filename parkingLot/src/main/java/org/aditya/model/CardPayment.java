package org.aditya.model;

import org.aditya.enums.PAYMENT_TYPE;

public class CardPayment extends Payment{

    public CardPayment() {
        super(PAYMENT_TYPE.CARD);
    }
}
