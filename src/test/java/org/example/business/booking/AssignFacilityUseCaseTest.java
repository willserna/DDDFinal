package org.example.business.booking;

import org.example.business.commons.EventsRepository;
import org.example.domain.booking.commands.AssignFacilityCommand;
import org.example.domain.booking.events.BookingCreated;
import org.example.domain.booking.events.FacilityAssigned;
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
class AssignFacilityUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private AssignFacilityUseCase assignFacilityUseCase;

    @BeforeEach
    void setup(){ assignFacilityUseCase = new AssignFacilityUseCase(eventsRepository);}

    @Test
    void successfulScenario(){

        BookingCreated bookingCreated = new BookingCreated();

        bookingCreated.setAggregateRootId("bookingTestId");

        AssignFacilityCommand assignment = new AssignFacilityCommand(
                "bookingTestId",
                "facilityTestId"
        );

        FacilityAssigned facilityAssigned = new FacilityAssigned("facilityTestId");

        Mockito.when(eventsRepository.findByAggregateRootId("bookingTestId")).thenReturn(List.of(bookingCreated));

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocationOnMock -> {
            return invocationOnMock.getArgument(0);});

        List<DomainEvent> domainEventList = assignFacilityUseCase.apply(assignment);

        Assertions.assertEquals(1, domainEventList.size());
        try {
            Assertions.assertEquals("facilityTestId", domainEventList.get(0).getClass().getMethod("getFacilityId").invoke(domainEventList.get(0)).toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}