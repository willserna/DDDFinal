package org.example.domain.booking;

import org.example.domain.booking.events.*;
import org.example.domain.booking.values.*;
import org.example.generic.EventChange;

import java.util.ArrayList;

public class BookingChange extends EventChange {

    public BookingChange(Booking booking){

        apply((BookingCreated event)-> {
            booking.gymClasses = new ArrayList<>();
            booking.coach = new Coach(CoachId.of(event.getCoachId()),
                    new CoachInfo(event.getCoachName(), event.getCoachEmail(),
                            event.getCoachTime()));
            booking.facilities = new ArrayList<>();
        });

        apply((CoachInfoEdited event)-> {
            booking.coach = new Coach(CoachId.of(event.getCoachId()),
                    new CoachInfo(event.getCoachName(),event.getCoachEmail(),
                            event.getCoachTime()));

        });

        apply((FacilityAssigned event) ->{
            booking.facilities.add(FacilityId.of(event.getFacilityId()));
        });

        apply((FacilityInfoEdited event) ->{
            booking.facility.updateFacilityInfo(new FacilityInfo(event.getFacilityName(),
                    event.getFacilityTime()));
        });

        apply((GymClassAssigned event) ->{
            booking.gymClasses.add(GymClassId.of(event.getGymClassId()));
        });

        apply((GymClassInfoEdited event) ->{
            booking.gymClass.updateGymClassInfo(new GymClassInfo(event.getClassName(),
                    event.getInstructor(), event.getClassTime()));
        });
    }
}
