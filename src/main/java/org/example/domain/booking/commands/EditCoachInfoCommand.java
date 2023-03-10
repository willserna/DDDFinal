package org.example.domain.booking.commands;

import org.example.generic.Command;

import java.sql.Time;

public class EditCoachInfoCommand extends Command {

    private String bookingId;
    private String coachId;
    private String coachName;
    private String coachEmail;
    private Time coachTime;

    public EditCoachInfoCommand() {
    }

    public EditCoachInfoCommand(String bookingId,
                                String coachId,
                                String coachName,
                                String coachEmail,
                                Time coachTime) {

        this.bookingId = bookingId;
        this.coachId = coachId;
        this.coachName = coachName;
        this.coachEmail = coachEmail;
        this.coachTime = coachTime;
    }

    public String getBookingId() {
        return bookingId;
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
}
