package org.example.domain.booking.values;

import org.example.generic.Identity;

public class CoachId extends Identity {

    private CoachId(String uuid){super(uuid);}

    public CoachId(){}

    public static CoachId of (String uuid){return new CoachId(uuid);}
}
