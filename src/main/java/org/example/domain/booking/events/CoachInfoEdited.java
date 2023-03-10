package org.example.domain.booking.events;

import org.example.generic.DomainEvent;

import java.sql.Time;

public class CoachInfoEdited extends DomainEvent {


    private String coachId;
    private String coachName;
    private String coachEmail;
    private Time coachTime;

    public CoachInfoEdited(String coachId){
        super("serna.william.coachinfoedited");
        this.coachId = coachId;
    }
    public CoachInfoEdited(String coachId,
                           String coachName,
                           String coachEmail,
                           Time coachTime) {
        super("serna.william.coachinfoedited");
        this.coachId = coachId;
        this.coachName = coachName;
        this.coachEmail = coachEmail;
        this.coachTime = coachTime;
    }


    public String getCoachId() {
        return coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public String getCoachEmail() {
        return coachEmail;
    }

    public Time getCoachTime() {
        return coachTime;
    }
}
