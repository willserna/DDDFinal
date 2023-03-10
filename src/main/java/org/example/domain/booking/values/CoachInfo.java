package org.example.domain.booking.values;

import org.example.generic.ValueObject;

import java.sql.Time;

public class CoachInfo implements ValueObject<CoachInfo.Props> {

    private final String coachName;
    private final String coachEmail;
    private final Time coachTime;

    public CoachInfo(String coachName,
                     String coachEmail,
                     Time coachTime) {

        this.coachName = coachName;
        this.coachEmail = coachEmail;
        this.coachTime = coachTime;
    }

    @Override
    public CoachInfo.Props value() {
        return new Props() {
            @Override
            public String coachName() {
                return coachName;
            }

            @Override
            public String coachEmail() {
                return coachEmail;
            }

            @Override
            public Time coachTime() {
                return coachTime;
            }
        };
    }

    interface Props{
        String coachName();
        String coachEmail();
        Time coachTime();
    }
}
