package org.example.domain.registry.commands;

import org.example.generic.Command;

public class AddPaymentCommand extends Command {

    private String registryId;
    private String paymentId;
    private String cardNumber;
    private String expirationDate;
    private String cardCode;

    private AddPaymentCommand(){}

    public AddPaymentCommand(String registryId,
                             String paymentId,
                             String cardNumber,
                             String expirationDate,
                             String cardCode){

        this.registryId = registryId;
        this.paymentId = paymentId;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardCode = cardCode;
    }

    public String getRegistryId() {
        return registryId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }
}
