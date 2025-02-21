package org.da1.paymentservice.controller;
import org.da1.paymentservice.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.da1.paymentservice.dtos.InitiatePaymentDTO;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public String initiatePayment(@RequestParam InitiatePaymentDTO initiatePaymentDTO) {

        return paymentService.getPaymentLink(initiatePaymentDTO.getAmount(),initiatePaymentDTO.getOrderId(),initiatePaymentDTO.getPhoneNumber(),
                initiatePaymentDTO.getName(),initiatePaymentDTO.getEmail());
    }
}
