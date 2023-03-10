package org.example.domain.booking.events;

import org.example.generic.DomainEvent;

public class FacilityAssigned extends DomainEvent {

    private String facilityId;

    public FacilityAssigned(){super("serna.william.facilityassigned");}
    public FacilityAssigned(String facilityId){
        super("serna.william.facilityassigned");
        this.facilityId = facilityId;
    }

    public String getFacilityId() {
        return facilityId;
    }
}
