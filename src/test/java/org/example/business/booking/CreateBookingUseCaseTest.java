package org.example.business.booking;

import org.example.business.commons.EventsRepository;
import org.example.domain.booking.commands.CreateBookingCommand;
import org.example.domain.booking.events.BookingCreated;
import org.example.domain.booking.values.FacilityId;
import org.example.domain.booking.values.GymClassId;
import org.example.domain.registry.commands.CreateRegistryCommand;
import org.example.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateBookingUseCaseTest {

    private List<GymClassId> gymClasses;
    private Time time = new Time(12 , 30,0);
    private List<FacilityId> facilities;
    @Mock
    private EventsRepository eventsRepository;
    private CreateBookingUseCase createBookingUseCase;

    @BeforeEach
    void setUp(){ createBookingUseCase = new CreateBookingUseCase(eventsRepository);}

    @Test
    void successfulScenario(){

        CreateBookingCommand createBookingCommand = new CreateBookingCommand(
                "bookingTestId",
                gymClasses,
                "coachTestId",
                "Test coach name",
                "email@test",
                time,
                facilities

        );

        BookingCreated bookingCreated = new BookingCreated(
                gymClasses,
                "coachTestId",
                "Test coach name",
                "email@test",
                time,
                facilities
        );

        bookingCreated.setAggregateRootId("bookingTestId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = createBookingUseCase.apply(createBookingCommand);

        Assertions.assertEquals(1, domainEventList.size());
        Assertions.assertEquals("bookingTestId", domainEventList.get(0).aggregateRootId());
    }

}