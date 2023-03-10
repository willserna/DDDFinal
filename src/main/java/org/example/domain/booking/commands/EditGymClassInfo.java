package org.example.domain.booking.commands;

import org.example.generic.Command;

import java.sql.Time;

public class EditGymClassInfo extends Command {

    private String bookingId;
    private String className;
    private String instructor;
    private Time classTime;

    public EditGymClassInfo() {
    }

    public EditGymClassInfo(String bookingId,String className, String instructor, Time classTime) {
        this.bookingId = bookingId;
        this.className = className;
        this.instructor = instructor;
        this.classTime = classTime;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Time getClassTime() {
        return classTime;
    }

    public void setClassTime(Time classTime) {
        this.classTime = classTime;
    }
}
