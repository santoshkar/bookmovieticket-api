package com.assesment.payment.service;

import com.assesment.payment.model.PaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("debitCard")
@Slf4j
public class DebitCardService implements IPaymentService{
    @Override
    public String processPayment(PaymentRequest paymentDetails) {
        log.info("Payment request for debit card no: {}", paymentDetails.getCard().getCardNumber());
        return "Processing credit card payment: " + paymentDetails.getAmount();
    }

    @Override
    public boolean supports(PaymentMethod delimiter) {
        return delimiter.equals(PaymentMethod.DEBIT_CARD);
    }
}
