package org.example.domain.registry.events;

import org.example.generic.DomainEvent;

public class MembershipAdded extends DomainEvent {

    private String registryId;
    private String membershipId;
    private String membershipType;
    private String bookingId;
    private String coachId;

    private MembershipAdded(){super("serna.william.membershipadded");}

    public MembershipAdded(String registryId, String membershipId, String membershipType, String bookingId, String coachId){
        super("serna.william.membershipadded");
        this.registryId = registryId;
        this.membershipId = membershipId;
        this.membershipType = membershipType;
        this.bookingId = bookingId;
        this.coachId = coachId;

    }

    public String getRegistryId() {
        return registryId;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCoachId() {
        return coachId;
    }
}
