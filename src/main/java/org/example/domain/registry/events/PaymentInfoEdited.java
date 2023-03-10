package org.example.domain.registry.events;

import org.example.generic.DomainEvent;

public class PaymentInfoEdited extends DomainEvent {

    private String cardNumber;
    private String expirationDate;
    private String cardCode;

    public PaymentInfoEdited(){super("serna.william.paymentadded");}

    public PaymentInfoEdited(String cardNumber,
                        String expirationDate,
                        String cardCode){
        super("serna.william.paymentadded");
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardCode = cardCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCardCode() {
        return cardCode;
    }
}
