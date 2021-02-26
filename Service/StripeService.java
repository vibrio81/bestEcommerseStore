package com.tts.ecommerce.Service;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

import com.tts.ecommerce.Model.ChargeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

    private static final String TEST_STRIPE_SECRET_KEY = "sk_test_51IOuQGAdAlkgpo24nULPNpfIcdy3WfRTKM9lS8nQsATwerJqaeFe370ZKGEZzLl7mbN5LXtpxjDDiTqiii1TOkGS00PHMJexEh";
    String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = TEST_STRIPE_SECRET_KEY;
    }

    public Charge charge(ChargeRequest chargeRequest)
            throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        return Charge.create(chargeParams);
    }
}
