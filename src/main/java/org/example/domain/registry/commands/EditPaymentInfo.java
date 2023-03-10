package org.example.domain.registry.commands;

import org.example.generic.Command;

public class EditPaymentInfo extends Command {

    private String registryId;
    private String cardNumber;
    private String expirationDate;
    private String cardCode;

    public EditPaymentInfo(){}

    public EditPaymentInfo(String registryId,
                           String cardNumber,
                           String expirationDate,
                           String cardCode
                           ){
        this.registryId = registryId;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardCode = cardCode;
    }

    public String getRegistryId() {
        return registryId;
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
