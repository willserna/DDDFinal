package org.example.domain.booking.values;

import org.example.generic.Identity;

public class GymClassId extends Identity {

    private GymClassId(String uuid){super(uuid);}

    public GymClassId(){}

    public static GymClassId of (String uuid){return new GymClassId(uuid);}
}
