package org.example.domain.booking.commands;

import org.example.generic.Command;

public class AssignGymClassCommand extends Command {

    private String bookingId;
    private String gymClassId;

    public AssignGymClassCommand() {
    }

    public AssignGymClassCommand(String bookingId,String gymClassId) {

        this.bookingId = bookingId;
        this.gymClassId = gymClassId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getGymClassId() {
        return gymClassId;
    }

    public void setGymClassId(String gymClassId) {
        this.gymClassId = gymClassId;
    }
}
