package org.example.domain.registry.events;

import org.example.generic.DomainEvent;

import java.sql.Time;


public class RegistryCreated extends DomainEvent {

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
    private String bookingId;
    private String coachId;
    private String coachName;
    private String coachEmail;
    private Time coachTime;

    public RegistryCreated(){super("serna.william.registrycreated");}

    public RegistryCreated(String userId,
                           String userName,
                           String userEmail,
                           String phoneNumber,
                           Boolean status,
                           String membershipId,
                           String membershipType,
                           String paymentId,
                           String cardNumber,
                           String expirationDate,
                           String cardCode,
                           String bookingId,
                           String coachId,
                           String coachName,
                           String coachEmail,
                           Time coachTime){

        super("serna.william.registrycreated");
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
        this.bookingId = bookingId;
        this.coachId = coachId;
        this.coachName = coachName;
        this.coachEmail = coachEmail;
        this.coachTime = coachTime;
    }

    public RegistryCreated(String userId,
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

        super("serna.william.registrycreated");
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

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public String getMembershipType() {
        return membershipType;
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

    public String getBookingId() {
        return bookingId;
    }

    public String getCoachId() {
        return coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public String getCoachEmail() {
        return coachEmail;
    }

    public Time getCoachTime() {
        return coachTime;
    }
}
