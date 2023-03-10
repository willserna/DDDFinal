package org.example.domain.registry.values;

import org.example.generic.ValueObject;

public class PaymentInfo implements ValueObject<PaymentInfo.Props> {

    private final String cardNumber;
    private final String expirationDate;
    private final String cardCode;

    public PaymentInfo(String cardNumber,
                       String expirationDate,
                       String cardCode) {

        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardCode = cardCode;
    }

    @Override
    public Props value() {
        return new Props() {

            @Override
            public String cardNumber() {
                return cardNumber;
            }

            @Override
            public String expirationDate() {
                return expirationDate;
            }

            @Override
            public String cardCode() {
                return cardCode;
            }
        };
    }

    interface Props{
        String cardNumber();
        String expirationDate();
        String cardCode();
    }
}
