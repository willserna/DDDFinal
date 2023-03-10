package org.example.domain.registry.events;

import org.example.generic.DomainEvent;

public class MembershipTypeEdited extends DomainEvent {

    private String membershipType;

    public MembershipTypeEdited(){super("serna.william.membershiptypeedited");}
    public MembershipTypeEdited(String membershipType){
        super("serna.william.membershiptypeedited");
        this.membershipType = membershipType;
    }

    public String getMembershipType() {
        return membershipType;
    }
}
