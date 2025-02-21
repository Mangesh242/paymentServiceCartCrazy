package org.da1.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentDTO {
       Double amount;
       String orderId;
       String phoneNumber;
       String name;
       String email;
}
