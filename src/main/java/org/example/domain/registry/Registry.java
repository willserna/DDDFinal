package org.example.domain.registry;

import org.example.domain.registry.events.*;
import org.example.domain.registry.values.MembershipId;
import org.example.domain.registry.values.PaymentId;
import org.example.domain.registry.values.RegistryId;
import org.example.domain.registry.values.UserId;
import org.example.generic.AggregateRoot;
import org.example.generic.DomainEvent;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.sql.Time;
import java.util.List;
import java.util.Objects;

public class Registry extends AggregateRoot<RegistryId> {

    protected User user;
    protected String userId;
    protected String userName;
    protected String userEmail;
    protected String phoneNumber;
    protected Boolean status;

    protected Membership membership;
    protected String membershipId;
    protected String membershipType;

    protected Payment payment;
    protected String paymentId;
    protected String cardNumber;
    protected String expirationDate;
    protected String cardCode;

    public Registry(RegistryId entityId,
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
                    /*String bookingId,
                    String coachId,
                    String coachName,
                    String coachEmail,
                    Time coachTime*/){
        super(entityId);
        subscribe(new RegistryChange(this));
        appendChange(new RegistryCreated(
                userId,
                userName,
                userEmail,
                phoneNumber,
                status,
                membershipId,
                membershipType,
                paymentId,
                cardNumber,
                expirationDate,
                cardCode
                /*bookingId,
                coachId,
                coachName,
                coachEmail,
                coachTime*/
        ));
    }

    private Registry (RegistryId id){
        super(id);
        subscribe(new RegistryChange(this));
    }

    public static Registry from (RegistryId id, List<DomainEvent> events){
        Registry registry = new Registry(id);
        events.forEach(registry::applyEvent);
        return registry;
    }

    public void addAnUser(String userId,
                          String userName,
                          String userEmail,
                          String phoneNumber){
        Objects.requireNonNull(userId);
        Objects.requireNonNull(userName);
        Objects.requireNonNull(userEmail);
        Objects.requireNonNull(phoneNumber);
        appendChange(new UserAdded(userId, userName, userEmail, phoneNumber)).apply();
    }

    public void addAMembership(String registryId,
                               String membershipId,
                               String membershipType,
                               String bookingId,
                               String coachId){
        Objects.requireNonNull(registryId);
        Objects.requireNonNull(membershipId);
        Objects.requireNonNull(membershipType);
        Objects.requireNonNull(bookingId);
        Objects.requireNonNull(coachId);
        appendChange(new MembershipAdded(registryId,membershipId, membershipType, bookingId, coachId)).apply();
    }

    public void addAPayment(String paymentId,
                            String cardNumber,
                            String expirationDate,
                            String cardCode){
        Objects.requireNonNull(paymentId);
        Objects.requireNonNull(cardNumber);
        Objects.requireNonNull(expirationDate);
        Objects.requireNonNull(cardCode);
        appendChange(new PaymentAdded(paymentId,cardNumber,expirationDate,cardCode)).apply();
    }

    public void editUserInfo(String userName,
                             String userEmail,
                             String phoneNumber,
                             Boolean status){
        Objects.requireNonNull(userName);
        Objects.requireNonNull(userEmail);
        Objects.requireNonNull(phoneNumber);
        Objects.requireNonNull(status);
        appendChange(new UserInfoEdited(userName,userEmail,phoneNumber,status)).apply();
    }

    public void editMembershipType(String membershipType){
        Objects.requireNonNull(membershipType);
        appendChange(new MembershipTypeEdited(membershipType)).apply();
    }

    public void editPaymentInfo(String cardNumber,
                                String expirationDate,
                                String cardCode){
        Objects.requireNonNull(cardNumber);
        Objects.requireNonNull(expirationDate);
        Objects.requireNonNull(cardCode);
        appendChange(new PaymentInfoEdited(cardNumber, expirationDate, cardCode)).apply();
    }



}
