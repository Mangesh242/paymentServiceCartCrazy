package org.da1.paymentservice.services;

public interface IPaymentService {
    String getPaymentLink(Double amount,String orderId,
                          String phoneNumber,
                          String name,
                          String email);
}
