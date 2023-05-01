package com.assesment.payment.service;

import com.assesment.payment.model.PaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("payPal")
@Slf4j
public class PayPalService implements IPaymentService{
    @Override
    public String processPayment(PaymentRequest paymentDetails) {
        log.info("Payment request for paypal userid: {}", paymentDetails.getUserId());
        return "Processing credit card payment: " + paymentDetails.getAmount();
    }

    @Override
    public boolean supports(PaymentMethod delimiter) {
        return delimiter.equals(PaymentMethod.PAY_PAL);
    }
}
