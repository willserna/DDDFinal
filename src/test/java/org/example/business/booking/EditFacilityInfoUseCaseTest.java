package org.example.business.booking;

import org.example.business.commons.EventsRepository;
import org.example.domain.booking.commands.EditFacilityInfoCommand;
import org.example.domain.booking.events.BookingCreated;
import org.example.domain.booking.events.FacilityInfoEdited;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EditFacilityInfoUseCaseTest {

    private Time time = new Time(12 , 30,0);

    @Mock
    private EventsRepository eventsRepository;
    private EditFacilityInfoUseCase editFacilityInfoUseCase;

    @BeforeEach
    void setup(){ editFacilityInfoUseCase = new EditFacilityInfoUseCase(eventsRepository); }

    @Test
    void successfulScenario(){

        BookingCreated bookingCreated = new BookingCreated();

        bookingCreated.setAggregateRootId("bookingTestId");

        EditFacilityInfoCommand editFacilityInfoCommand = new EditFacilityInfoCommand(
                "bookingTestId",
                "facilityTestId",
                "Test facility name",
                time
        );

        FacilityInfoEdited facilityInfoEdited = new FacilityInfoEdited(
                "facilityTestId",
                "Test facility name",
                time
        );

        Mockito.when(eventsRepository.findByAggregateRootId("bookingTestId"))
                .thenReturn(List.of(bookingCreated));

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocationOnMock -> {
            return invocationOnMock.getArgument(0);
        });

        List<DomainEvent> domainEventList = editFacilityInfoUseCase.apply(editFacilityInfoCommand);

        try {
            Assertions.assertEquals("Test facility name", domainEventList.get(0).getClass().getMethod("getFacilityName").invoke(domainEventList.get(0)).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("bookingTestId", domainEventList.get(0).aggregateRootId());
    }

}