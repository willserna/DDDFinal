package org.example.business.booking;

import org.example.business.commons.EventsRepository;
import org.example.business.commons.UseCaseForCommand;
import org.example.domain.booking.Booking;
import org.example.domain.booking.commands.CreateBookingCommand;
import org.example.domain.booking.values.BookingId;
import org.example.generic.DomainEvent;

import java.util.List;

public class CreateBookingUseCase implements UseCaseForCommand<CreateBookingCommand> {

    private final EventsRepository eventsRepository;

    public CreateBookingUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateBookingCommand command) {
        Booking booking = new Booking(BookingId.of(command.getBookingId()),command.getGymClasses(),
                command.getCoachId(), command.getCoachName(), command.getCoachEmail(), command.getCoachTime(),
                command.getFacilities());
        return booking.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
