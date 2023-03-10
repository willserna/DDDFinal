package org.example.domain.booking;

import org.example.domain.booking.values.CoachId;
import org.example.domain.booking.values.CoachInfo;
import org.example.generic.Entity;

import java.sql.Time;

public class Coach extends Entity<CoachId> {

    private CoachInfo coachInfo;

    public Coach(CoachId entityId, CoachInfo coachInfo) {
        super(entityId);
        this.coachInfo = coachInfo;
    }

    public CoachInfo coachInfo() {
        return coachInfo;
    }

    public void updateCoachInfo(CoachInfo newCoachInfo) {
        coachInfo = newCoachInfo;

    }
}
