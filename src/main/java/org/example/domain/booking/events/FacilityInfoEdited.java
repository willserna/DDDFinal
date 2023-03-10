package org.example.domain.booking.events;

import org.example.generic.DomainEvent;

import java.sql.Time;

public class FacilityInfoEdited extends DomainEvent {


    private String facilityId;
    private String facilityName;
    private Time facilityTime;

    public FacilityInfoEdited(){super("serna.william.facilityinfoedited");}

    public FacilityInfoEdited(String facilityId,String facilityName, Time facilityTime){
        super("serna.william.facilityinfo");
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityTime = facilityTime;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public Time getFacilityTime() {
        return facilityTime;
    }
}
