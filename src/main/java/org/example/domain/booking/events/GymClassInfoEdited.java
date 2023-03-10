package org.example.domain.booking.events;

import org.example.generic.DomainEvent;

import java.sql.Time;

public class GymClassInfoEdited extends DomainEvent {

    private String className;
    private String instructor;
    private Time classTime;


    public GymClassInfoEdited(){super("serna.william.gymclassinfoedited");}
    public GymClassInfoEdited(String className,
                              String instructor,
                              Time classTime){
        super("serna.william.gymclassinfoedited");
        this.className = className;
        this.instructor = instructor;
        this.classTime = classTime;

    }

    public String getClassName() {
        return className;
    }

    public String getInstructor() {
        return instructor;
    }

    public Time getClassTime() {
        return classTime;
    }
}
