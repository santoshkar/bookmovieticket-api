package com.assesment.payment.service;

import com.assesment.payment.model.PaymentRequest;
import org.springframework.plugin.core.Plugin;

public interface IPaymentService extends Plugin<PaymentMethod> {
    String processPayment(PaymentRequest paymentDetails);
}