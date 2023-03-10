package org.example.business.booking;

import org.example.business.commons.EventsRepository;
import org.example.business.commons.UseCaseForCommand;
import org.example.domain.booking.Booking;
import org.example.domain.booking.commands.EditFacilityInfoCommand;
import org.example.domain.booking.values.BookingId;
import org.example.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class EditFacilityInfoUseCase implements UseCaseForCommand<EditFacilityInfoCommand> {

    private final EventsRepository eventsRepository;

    public EditFacilityInfoUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(EditFacilityInfoCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getBookingId());
        Booking booking = Booking.from(BookingId.of(command.getBookingId()), events);
        booking.editFacilityInfo(command.getFacilityId(), command.getFacilityName(), command.getFacilityTime());
        return booking.getUncommittedChanges().stream().map(eventsRepository::saveEvent).collect(Collectors.toList());
    }
}
