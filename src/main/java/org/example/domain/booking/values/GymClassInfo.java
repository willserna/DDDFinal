package org.example.domain.booking.values;

import org.example.generic.ValueObject;

import java.sql.Time;

public class GymClassInfo implements ValueObject<GymClassInfo.Props> {

    private final String className;
    private final String instructor;
    private final Time classTime;


    public GymClassInfo(String className,
                        String instructor,
                        Time classTime) {

        this.className = className;
        this.instructor = instructor;
        this.classTime = classTime;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String className() {
                return className;
            }

            @Override
            public String instructor() {
                return instructor;
            }

            @Override
            public Time classTime() {
                return classTime;
            }
        };
    }

    interface Props{
        String className();
        String instructor();
        Time classTime();

    }
}
