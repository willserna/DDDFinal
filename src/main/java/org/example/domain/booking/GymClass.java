package org.example.domain.booking;

import org.example.domain.booking.values.GymClassId;
import org.example.domain.booking.values.GymClassInfo;
import org.example.generic.Entity;

public class GymClass extends Entity<GymClassId> {

    private GymClassInfo gymClassInfo;

    public GymClass(GymClassId entityId, GymClassInfo gymClassInfo) {
        super(entityId);
        this.gymClassInfo = gymClassInfo;
    }

    public void updateGymClassInfo(GymClassInfo newGymClassInfo) {
        gymClassInfo = newGymClassInfo;
    }
}
