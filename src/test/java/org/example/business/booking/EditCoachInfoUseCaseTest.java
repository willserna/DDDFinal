package org.example.business.booking;

import org.example.business.commons.EventsRepository;
import org.example.domain.booking.commands.EditCoachInfoCommand;
import org.example.domain.booking.events.BookingCreated;
import org.example.domain.booking.events.CoachInfoEdited;
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
class EditCoachInfoUseCaseTest {

    private Time time = new Time(12 , 30,0);

    @Mock
    private EventsRepository eventsRepository;
    private EditCoachInfoUseCase editCoachInfoUseCase;

    @BeforeEach
    void setUp(){ editCoachInfoUseCase = new EditCoachInfoUseCase(eventsRepository);}

    @Test
    void successfulScenario(){

        BookingCreated bookingCreated = new BookingCreated();

        bookingCreated.setAggregateRootId("bookingTestId");

        EditCoachInfoCommand editCoachInfoCommand = new EditCoachInfoCommand(
                "bookingTestId",
                "coachTestId",
                "Test coach name",
                "email@test",
                time
        );

        CoachInfoEdited coachInfoEdited = new CoachInfoEdited(
                "coachTestId",
                "Test coach name",
                "email@test",
                time);

        Mockito.when(eventsRepository.findByAggregateRootId("bookingTestId"))
                .thenReturn(List.of(bookingCreated));

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocationOnMock -> {
            return invocationOnMock.getArgument(0);
        });

        List<DomainEvent> domainEventList = editCoachInfoUseCase.apply(editCoachInfoCommand);

        try {
            Assertions.assertEquals("Test coach name", domainEventList.get(0).getClass().getMethod("getCoachName").invoke(domainEventList.get(0)).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("bookingTestId", domainEventList.get(0).aggregateRootId());
    }

}