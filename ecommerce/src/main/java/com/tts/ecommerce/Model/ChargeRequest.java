package com.tts.ecommerce.Model;

import lombok.Data;

@Data
public class ChargeRequest {

    public enum Currency {
        EUR, USD;
    }
    private String Description;
    private int Amount; // cents
    private Currency Currency;
    private String StripeEmail;
    private String StripeToken;
//    public String getDescription() {
//        return description;
//    }
//    public int getAmount() {
//        return amount;
//    }
//    public Currency getCurrency() {
//        return currency;
//    }
//    public String getStripeEmail() {
//        return stripeEmail;
//    }
//    public String getStripeToken() {
//        return stripeToken;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    public void setCurrency(Currency currency) {
//        this.currency = currency;
//    }


}
