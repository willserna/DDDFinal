package org.example.domain.booking.commands;

import org.example.generic.Command;

public class AssignFacilityCommand extends Command {

    private String bookingId;
    private String facilityId;

    public AssignFacilityCommand() { }

    public AssignFacilityCommand(String bookingId,String facilityId) {
        this.bookingId = bookingId;
        this.facilityId = facilityId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String coachId) {
        this.facilityId = facilityId;
    }
}
