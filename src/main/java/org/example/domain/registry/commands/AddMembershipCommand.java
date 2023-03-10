package org.example.domain.registry.commands;

import org.example.generic.Command;

public class AddMembershipCommand extends Command {

    private String registryId;
    private String membershipId;

    private String membershipType;
    private String bookingId;
    private String coachId;
    private AddMembershipCommand(){}
    public AddMembershipCommand(String registryId,
                                String membershipId,
                                String membershipType,
                                String bookingId,
                                String coachId){
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

    public void setMembershipId(String membershipId) {

        this.membershipId = membershipId;
    }

    public String getMembershipType() {

        return membershipType;
    }

    public void setMembershipType(String membershipType) {

        this.membershipType = membershipType;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getCoachId() {
        return coachId;
    }
}
