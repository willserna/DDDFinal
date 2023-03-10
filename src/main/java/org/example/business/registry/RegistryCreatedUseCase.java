package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.business.commons.UseCaseForEvent;
import org.example.domain.booking.Booking;
import org.example.domain.booking.values.BookingId;
import org.example.domain.registry.Registry;
import org.example.domain.registry.events.RegistryCreated;
import org.example.domain.registry.values.RegistryId;
import org.example.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegistryCreatedUseCase implements UseCaseForEvent<RegistryCreated> {

    private final EventsRepository eventsRepository;
    public RegistryCreatedUseCase(EventsRepository eventsRepository){
        this.eventsRepository = eventsRepository;
    }
    @Override
    public List<DomainEvent> apply(RegistryCreated event) {

        Booking booking = new Booking(BookingId.of(event.getBookingId()), event.getCoachId(),
                event.getCoachName(), event.getCoachEmail(), event.getCoachTime());

        return booking.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
