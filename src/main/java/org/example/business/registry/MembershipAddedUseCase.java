package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.business.commons.UseCaseForEvent;
import org.example.domain.booking.Booking;
import org.example.domain.booking.values.BookingId;
import org.example.domain.registry.Registry;
import org.example.domain.registry.events.MembershipAdded;
import org.example.domain.registry.values.RegistryId;
import org.example.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MembershipAddedUseCase implements UseCaseForEvent<MembershipAdded> {

    private final EventsRepository eventsRepository;
    public MembershipAddedUseCase(EventsRepository eventsRepository){
        this.eventsRepository = eventsRepository;
    }
    @Override
    public List<DomainEvent> apply(MembershipAdded event) {

        List<DomainEvent> eventsBooking = eventsRepository.findByAggregateRootId(event.getBookingId());
        Booking booking = Booking.from(BookingId.of(event.getBookingId()), eventsBooking);
        booking.editCoachInfoEvent(event.getCoachId());
        return booking.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
