package org.example.business.booking;

import org.example.business.commons.EventsRepository;
import org.example.domain.booking.commands.AssignFacilityCommand;
import org.example.domain.booking.commands.AssignGymClassCommand;
import org.example.domain.booking.events.BookingCreated;
import org.example.domain.booking.events.FacilityAssigned;
import org.example.domain.booking.events.GymClassAssigned;
import org.example.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AssignGymClassUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private AssignGymClassUseCase assignGymClassUseCase;

    @BeforeEach
    void setup(){ assignGymClassUseCase = new AssignGymClassUseCase(eventsRepository);}

    @Test
    void successfulScenario(){

        BookingCreated bookingCreated = new BookingCreated();

        bookingCreated.setAggregateRootId("bookingTestId");

        AssignGymClassCommand assignment = new AssignGymClassCommand(
                "bookingTestId",
                "gymClassTestId"
        );

        GymClassAssigned gymClassAssigned = new GymClassAssigned("gymClassTestId");

        Mockito.when(eventsRepository.findByAggregateRootId("bookingTestId")).thenReturn(List.of(bookingCreated));

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocationOnMock -> {
            return invocationOnMock.getArgument(0);});

        List<DomainEvent> domainEventList = assignGymClassUseCase.apply(assignment);

        Assertions.assertEquals(1, domainEventList.size());
        try {
            Assertions.assertEquals("gymClassTestId", domainEventList.get(0).getClass().getMethod("getGymClassId").invoke(domainEventList.get(0)).toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}