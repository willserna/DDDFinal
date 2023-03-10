package org.example.domain.booking;

import org.example.domain.booking.values.FacilityId;
import org.example.domain.booking.values.FacilityInfo;
import org.example.generic.Entity;

public class Facility extends Entity<FacilityId> {

    private FacilityInfo facilityInfo;

    public Facility(FacilityId entityId, FacilityInfo facilityInfo) {
        super(entityId);
        this.facilityInfo = facilityInfo;
    }

    public void updateFacilityInfo(FacilityInfo newFacilityInfo) {
        facilityInfo = newFacilityInfo;
    }
}
