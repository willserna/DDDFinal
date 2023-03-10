package org.example.domain.registry;

import org.example.domain.registry.events.*;
import org.example.domain.registry.values.*;
import org.example.generic.EventChange;

public class RegistryChange extends EventChange {

    public RegistryChange(Registry registry){

        apply((RegistryCreated event)-> {
            registry.user = new User(UserId.of(event.getUserId()),
                    new UserInfo(event.getUserName(),
                            event.getUserEmail(),
                            event.getPhoneNumber(),
                            event.getStatus()));

            registry.membership = new Membership(MembershipId.of(event.getMembershipId()),
                    new MembershipType(event.getMembershipType()));

            registry.payment = new Payment(PaymentId.of(event.getPaymentId()),
                    new PaymentInfo(event.getCardNumber(),
                            event.getExpirationDate(),
                            event.getCardCode()));
        });

        apply((UserAdded event)-> {
            registry.user = new User(UserId.of(event.getUserId()),
                    new UserInfo(event.getUserName(),
                            event.getUserEmail(),
                            event.getPhoneNumber(),
                            event.getStatus()));
        });

        apply((MembershipAdded event) ->{
            registry.membership = new Membership(MembershipId.of(event.getMembershipId()),
                    new MembershipType(event.getMembershipType()));
        });

        apply((PaymentAdded event) ->{
            registry.payment = new Payment(PaymentId.of(event.getPaymentId()),
                    new PaymentInfo(event.getCardNumber(),
                            event.getExpirationDate(),
                            event.getCardCode()));
        });

        apply((UserInfoEdited event) ->{
            registry.user.updateUserInfo(new UserInfo(event.getUserName(),
                    event.getUserEmail(),
                    event.getPhoneNumber(),
                    event.getStatus()));
        });

        apply((MembershipTypeEdited event) ->{
            registry.membership.updateMembershipType(new MembershipType(event.getMembershipType()));
        });

        apply((PaymentInfoEdited event) ->{
            registry.payment.updatePaymentInfo(new PaymentInfo(event.getCardNumber(),
                    event.getExpirationDate(),
                    event.getCardCode()));
        });

    }
}
