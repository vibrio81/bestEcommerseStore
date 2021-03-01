package com.tts.ecommerce.controller;


import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.tts.ecommerce.Model.ChargeRequest;
import com.tts.ecommerce.Service.StripeService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.smartcardio.CardException;


@Controller
public class ChargeController {

    @Autowired
    private StripeService paymentsService;

    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public String charge(ChargeRequest chargeRequest, Model model) throws StripeException, CardException {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(ChargeRequest.Currency.USD);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
}