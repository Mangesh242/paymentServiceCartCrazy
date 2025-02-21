package org.da1.paymentservice.paymentgateways;

import org.springframework.stereotype.Component;

@Component
public interface IPaymentGateway {

    String createStandardPaymentLink(Double amount,String orderId,
                                     String phoneNumber,
                                     String name,
                                     String email);
}
