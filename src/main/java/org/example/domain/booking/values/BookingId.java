package org.example.domain.booking.values;

import org.example.generic.Identity;

public class BookingId extends Identity {

    private BookingId(String uuid){super(uuid);}

    public BookingId(){}

    public static BookingId of (String uuid){return new BookingId(uuid);}
}
