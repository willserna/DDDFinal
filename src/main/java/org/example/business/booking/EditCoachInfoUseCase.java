package org.example.business.booking;

import org.example.business.commons.EventsRepository;
import org.example.business.commons.UseCaseForCommand;
import org.example.domain.booking.Booking;
import org.example.domain.booking.commands.EditCoachInfoCommand;
import org.example.domain.booking.values.BookingId;
import org.example.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class EditCoachInfoUseCase implements UseCaseForCommand<EditCoachInfoCommand> {

    private final EventsRepository eventsRepository;

    public EditCoachInfoUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(EditCoachInfoCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getBookingId());
        Booking booking = Booking.from(BookingId.of(command.getBookingId()), events);
        booking.editCoachInfo(command.getCoachId(), command.getCoachName(), command.getCoachEmail(),command.getCoachTime());
        return booking.getUncommittedChanges().stream().map(eventsRepository::saveEvent).collect(Collectors.toList());
    }
}
