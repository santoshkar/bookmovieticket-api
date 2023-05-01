package com.assesment.payment.model;

import com.assesment.payment.service.PaymentMethod;
import lombok.Data;

@Data
public class PaymentRequest {
    private PaymentMethod paymentMethod;
    private double amount;
    private Card card;
    private String userId;
    private String userSecret;
}
