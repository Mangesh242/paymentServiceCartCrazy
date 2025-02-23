package org.da1.paymentservice.paymentgateways;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class StripePaymentGateway implements IPaymentGateway{

    @Value("${stipeapikey}")
    private String stripeApiKey;


    @Override
    public String createStandardPaymentLink(Long amount, String orderId, String phoneNumber, String name, String email) {
        Stripe.apiKey = this.stripeApiKey;
        //Create price object,

        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice("price_1MoC3TLkdIwHu7ixcIbKelAC")
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();
            try{
                PaymentLink paymentLink = PaymentLink.create(params);
                return paymentLink.getUrl();
            }catch (StripeException ex){
                throw new RuntimeException(ex.getMessage());
            }
    }
    private Price getPriceObject(Long amount, String currency){
        Stripe.apiKey = this.stripeApiKey;
        PriceCreateParams params =
                PriceCreateParams.builder()
                        .setCurrency(currency)
                        .setUnitAmount(amount)
                        .setRecurring(
                                PriceCreateParams.Recurring.builder()
                                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                        .build()
                        )
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Gold Plan").build()
                        )
                        .build();
        try {
            Price price = Price.create(params);
            return price;
        }
        catch (StripeException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}
