package org.example.domain.registry;

import org.example.domain.registry.values.MembershipId;
import org.example.domain.registry.values.MembershipType;
import org.example.generic.Entity;

public class Membership extends Entity<MembershipId> {

    private MembershipType membershipType;

    public Membership (MembershipId entityId, MembershipType membershipType) {
        super(entityId);
        this.membershipType = membershipType;
    }

    public void updateMembershipType (MembershipType newMembershipType) {
        membershipType = newMembershipType;
    }
}
