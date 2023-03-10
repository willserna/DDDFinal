package org.example.domain.booking.events;

import org.example.domain.booking.values.FacilityId;
import org.example.domain.booking.values.GymClassId;
import org.example.generic.DomainEvent;

import java.sql.Time;
import java.util.List;

public class BookingCreated extends DomainEvent {

    private String bookingId;
    private List<GymClassId> gymClasses;
    protected String coachId;
    protected String coachName;
    protected String coachEmail;
    protected Time coachTime;
    private List<FacilityId> facilities;

    public BookingCreated(){super("serna.william.bookingcreated");}
    public BookingCreated(String coachId,
                          String coachName,
                          String coachEmail,
                          Time coachTime){
        super("serna.william.bookingcreated");
        this.coachId = coachId;
        this.coachName = coachName;
        this.coachEmail = coachEmail;
        this.coachTime = coachTime;
    }
    public BookingCreated(
                          List<GymClassId> gymClasses,
                          String coachId,
                          String coachName,
                          String coachEmail,
                          Time coachTime,
                          List<FacilityId> facilities){

        super("serna.william.bookingcreated");


        this.gymClasses = gymClasses;

        this.coachId = coachId;
        this.coachName = coachName;
        this.coachEmail = coachEmail;
        this.coachTime = coachTime;
        this.facilities = facilities;
    }


    public String getBookingId() {
        return bookingId;
    }

    public List<GymClassId> getGymClasses() {
        return gymClasses;
    }

    public String getCoachId() {
        return coachId;
    }

    public List<FacilityId> getFacilities() {
        return facilities;
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
