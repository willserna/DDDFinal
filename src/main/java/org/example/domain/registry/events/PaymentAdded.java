package org.example.domain.registry.events;

import org.example.generic.DomainEvent;

public class PaymentAdded extends DomainEvent {

    private String paymentId;
    private String cardNumber;
    private String expirationDate;
    private String cardCode;

    public PaymentAdded(){super("serna.william.paymentadded");}

    public PaymentAdded(String paymentId,
                        String cardNumber,
                        String expirationDate,
                        String cardCode){
        super("serna.william.paymentadded");
        this.paymentId = paymentId;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardCode = cardCode;
    }

    public String getPaymentId() {
        return paymentId;
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
