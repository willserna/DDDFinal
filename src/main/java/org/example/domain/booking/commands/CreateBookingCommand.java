package org.example.domain.booking.commands;

import org.example.domain.booking.values.FacilityId;
import org.example.domain.booking.values.GymClassId;
import org.example.generic.Command;

import java.sql.Time;
import java.util.List;

public class CreateBookingCommand extends Command {

    private String bookingId;
    private List<GymClassId> gymClasses;
    private String coachId;
    private String coachName;
    private String coachEmail;
    private Time coachTime;
    private List<FacilityId> facilities;

    public CreateBookingCommand(){}

    public CreateBookingCommand(String bookingId,
                                List<GymClassId> gymClasses,
                                String coachId,
                                String coachName,
                                String coachEmail,
                                Time coachTime,
                                List<FacilityId> facilities){

        this.bookingId = bookingId;
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

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public List<GymClassId> getGymClasses() {
        return gymClasses;
    }

    public void setGymClasses(List<GymClassId> gymClasses) {
        this.gymClasses = gymClasses;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getCoachEmail() {
        return coachEmail;
    }

    public void setCoachEmail(String coachEmail) {
        this.coachEmail = coachEmail;
    }

    public Time getCoachTime() {
        return coachTime;
    }

    public void setCoachTime(Time coachTime) {
        this.coachTime = coachTime;
    }

    public List<FacilityId> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<FacilityId> facilities) {
        this.facilities = facilities;
    }
}
