package org.da1.paymentservice.paymentgateways;

import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateway implements IPaymentGateway{
    @Override
    public String createStandardPaymentLink(Double amount, String orderId, String phoneNumber, String name, String email) {
        return "";
    }
}
