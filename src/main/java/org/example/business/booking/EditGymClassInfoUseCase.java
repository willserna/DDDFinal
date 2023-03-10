package org.example.business.booking;

import org.example.business.commons.EventsRepository;
import org.example.business.commons.UseCaseForCommand;
import org.example.domain.booking.Booking;
import org.example.domain.booking.commands.EditGymClassInfo;
import org.example.domain.booking.values.BookingId;
import org.example.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class EditGymClassInfoUseCase implements UseCaseForCommand<EditGymClassInfo> {

    private final EventsRepository eventsRepository;

    public EditGymClassInfoUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(EditGymClassInfo command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getBookingId());
        Booking booking = Booking.from(BookingId.of(command.getBookingId()), events);
        booking.editGymClassInfo(command.getClassName(), command.getInstructor(), command.getClassTime());
        return booking.getUncommittedChanges().stream().map(eventsRepository::saveEvent).collect(Collectors.toList());
    }
}
