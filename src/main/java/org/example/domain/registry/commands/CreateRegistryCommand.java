package org.example.domain.registry.commands;

import org.example.generic.Command;

public class CreateRegistryCommand extends Command {

    private String registryId;
    private String userId;
    private String userName;
    private String userEmail;
    private String phoneNumber;
    private Boolean status;

    private String membershipId;
    private String membershipType;

    private String paymentId;
    private String cardNumber;
    private String expirationDate;
    private String cardCode;

    private CreateRegistryCommand(){}

    public CreateRegistryCommand(String registryId,
                                 String userId,
                                 String userName,
                                 String userEmail,
                                 String phoneNumber,
                                 Boolean status,
                                 String membershipId,
                                 String membershipType,
                                 String paymentId,
                                 String cardNumber,
                                 String expirationDate,
                                 String cardCode
                                 ){
        this.registryId = registryId;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.membershipId = membershipId;
        this.membershipType = membershipType;
        this.paymentId = paymentId;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardCode = cardCode;

    }

    public String getRegistryId() {
        return registryId;
    }

    public void setRegistryId(String registryId) {
        this.registryId = registryId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
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
