package com.assesment.payment.model;

import lombok.Data;

@Data
public class Card {
    private String cardHolderName;
    private String cardNumber;
    private int expiryMonth;
    private int expiryYear;
}
