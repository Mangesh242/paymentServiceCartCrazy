package org.da1.paymentservice.services;

import org.da1.paymentservice.paymentgateways.IPaymentGateway;
import org.da1.paymentservice.paymentgateways.PaymentGatewayChooserStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    @Override
    public String getPaymentLink(Long amount, String orderId, String phoneNumber, String name, String email) {
        IPaymentGateway iPaymentGateway= paymentGatewayChooserStrategy.getPaymentGateway(100);

        return iPaymentGateway.createStandardPaymentLink(amount, orderId, phoneNumber, name, email);
    }
}
