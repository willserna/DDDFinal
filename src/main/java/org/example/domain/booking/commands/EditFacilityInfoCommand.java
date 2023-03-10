package org.example.domain.booking.commands;

import org.example.generic.Command;

import java.sql.Time;

public class EditFacilityInfoCommand extends Command {

    private String bookingId;
    private String facilityId;
    private String facilityName;
    private Time facilityTime;

    public EditFacilityInfoCommand() {
    }

    public EditFacilityInfoCommand(String bookingId,
                                   String facilityId,
                                   String facilityName,
                                   Time facilityTime) {
        this.bookingId = bookingId;
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityTime = facilityTime;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Time getFacilityTime() {
        return facilityTime;
    }

    public void setFacilityTime(Time facilityTime) {
        this.facilityTime = facilityTime;
    }
}
