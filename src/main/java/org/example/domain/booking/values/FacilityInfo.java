package org.example.domain.booking.values;

import org.example.generic.ValueObject;

import java.sql.Time;

public class FacilityInfo implements ValueObject<FacilityInfo.Props> {

    private final String facilityName;
    private final Time facilityTime;

    public FacilityInfo(String facilityName,
                        Time facilityTime) {
        this.facilityName = facilityName;
        this.facilityTime = facilityTime;
    }

    @Override
    public FacilityInfo.Props value() {
        return new Props() {
            @Override
            public String facilityName() {
                return facilityName;
            }

            @Override
            public Time facilityTime() {
                return facilityTime;
            }
        };
    }

    interface Props{
        String facilityName();
        Time facilityTime();
    }
}
