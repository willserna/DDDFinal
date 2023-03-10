package org.example.domain.booking.events;

import org.example.generic.DomainEvent;

public class GymClassAssigned extends DomainEvent {

    private String gymClassId;

    public GymClassAssigned(){super("serna.william.gymclassassgined");}

    public GymClassAssigned(String gymClassId){
        super("serna.william.gymclass");
        this.gymClassId = gymClassId;
    }

    public String getGymClassId() {
        return gymClassId;
    }
}
