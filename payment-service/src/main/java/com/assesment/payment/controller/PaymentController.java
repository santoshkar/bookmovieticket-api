package com.assesment.payment.controller;

import com.assesment.payment.model.PaymentRequest;
import com.assesment.payment.service.IPaymentService;
import com.assesment.payment.service.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PluginRegistry<IPaymentService, PaymentMethod> pluginRegistry;

    @PostMapping
    public ResponseEntity<String> pay(@RequestBody PaymentRequest paymentRequest) {
        IPaymentService paymentService = pluginRegistry.getPluginFor(paymentRequest.getPaymentMethod())
                .orElseThrow(() -> new RuntimeException("Payment method not supported"));

        return ResponseEntity.ok(paymentService.processPayment(paymentRequest));
    }
}
