package org.da1.paymentservice;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfig {
    @Value("$(razorpay.id)")
    private String apiKey;
    @Value("$(razorpay.secret)")
    private String apiSecret;

    @Bean
    public RazorpayClient getRazorpayClient() {
        try{
            return new RazorpayClient(apiKey,apiSecret);
        }
        catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
    }
}
