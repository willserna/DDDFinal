package org.example.domain.booking.values;

import org.example.generic.Identity;

public class FacilityId extends Identity {

    private FacilityId(String uuid){super(uuid);}

    public FacilityId(){}

    public static FacilityId of (String uuid){return new FacilityId(uuid);}
}
