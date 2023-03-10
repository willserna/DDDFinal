package org.example.domain.booking;

import org.example.domain.booking.events.*;
import org.example.domain.booking.values.BookingId;
import org.example.domain.booking.values.FacilityId;
import org.example.domain.booking.values.GymClassId;
import org.example.domain.booking.values.GymClassInfo;
import org.example.generic.AggregateRoot;
import org.example.generic.DomainEvent;

import java.sql.Time;
import java.util.List;
import java.util.Objects;

public class Booking extends AggregateRoot<BookingId> {

    protected List<GymClassId> gymClasses;
    protected GymClass gymClass;

    protected Coach coach;

    protected List<FacilityId> facilities;
    protected Facility facility;


    public Booking(BookingId entityId,
                   List<GymClassId> gymClasses,
                   String coachId,
                   String coachName,
                   String coachEmail,
                   Time coachTime,
                   List<FacilityId> facilities) {
        super(entityId);
        subscribe(new BookingChange(this));
        appendChange(new BookingCreated(
                gymClasses,
                coachId,
                coachName,
                coachEmail,
                coachTime,
                facilities));
    }

    public Booking(BookingId entityId,
                   String coachId,
                   String coachName,
                   String coachEmail,
                   Time coachTime){
        super(entityId);
        subscribe(new BookingChange(this));
        appendChange(new BookingCreated(
                coachId,
                coachName,
                coachEmail,
                coachTime));
    }

    private Booking (BookingId id){
        super(id);
        subscribe(new BookingChange(this));
    }

    public static Booking from (BookingId id, List<DomainEvent> events) {
        Booking booking = new Booking(id);
        events.forEach(booking::applyEvent);
        return booking;
    }

    public void editCoachInfo(String coachId,
                              String coachName,
                              String coachEmail,
                              Time coachTime){
        Objects.requireNonNull(coachId);
        Objects.requireNonNull(coachName);
        Objects.requireNonNull(coachEmail);
        Objects.requireNonNull(coachTime);
        appendChange(new CoachInfoEdited(coachId, coachName, coachEmail, coachTime));
    }

    public void editCoachInfoEvent(String coachId){
        Objects.requireNonNull(coachId);
        appendChange(new CoachInfoEdited(coachId));
    }

    public void AssignAFacility(String facilityId){
        Objects.requireNonNull(facilityId);
        appendChange(new FacilityAssigned(facilityId));
    }

    public void editFacilityInfo(String facilityId,
                                 String facilityName,
                                 Time facilityTime){
        Objects.requireNonNull(facilityId);
        Objects.requireNonNull(facilityName);
        Objects.requireNonNull(facilityTime);
        appendChange(new FacilityInfoEdited(facilityId, facilityName, facilityTime));
    }

    public void AssignAGymClass(String gymClassId){
        Objects.requireNonNull(gymClassId);
        appendChange(new GymClassAssigned(gymClassId));
    }

    public void editGymClassInfo(String className,
                                 String instructor,
                                 Time classTime){
        Objects.requireNonNull(className);
        Objects.requireNonNull(instructor);
        Objects.requireNonNull(classTime);
        appendChange(new GymClassInfoEdited(className, instructor, classTime));

    }
}
