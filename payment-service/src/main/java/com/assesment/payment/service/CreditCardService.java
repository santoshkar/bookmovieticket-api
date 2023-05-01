package com.assesment.payment.service;

import com.assesment.payment.model.PaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("creditCard")
@Slf4j
public class CreditCardService implements IPaymentService{
    @Override
    public String processPayment(PaymentRequest paymentDetails) {
        log.info("Payment request for credit card no: {}", paymentDetails.getCard().getCardNumber());
        return "Processing credit card payment: " + paymentDetails.getAmount();
    }

    @Override
    public boolean supports(PaymentMethod delimiter) {
        return delimiter.equals(PaymentMethod.CREDIT_CARD);
    }
}
