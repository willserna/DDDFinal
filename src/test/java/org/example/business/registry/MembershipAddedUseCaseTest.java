package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.domain.booking.events.BookingCreated;
import org.example.domain.booking.events.CoachInfoEdited;
import org.example.domain.registry.commands.EditMembershipTypeCommand;
import org.example.domain.registry.events.MembershipAdded;
import org.example.domain.registry.events.RegistryCreated;
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
class MembershipAddedUseCaseTest {


    @Mock
    private EventsRepository eventsRepository;
    private MembershipAddedUseCase membershipAddedUseCase;

    @BeforeEach
    void setup(){
        membershipAddedUseCase = new MembershipAddedUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){


        BookingCreated bookingCreated = new BookingCreated();
        bookingCreated.setAggregateRootId("bookingTestId");

        CoachInfoEdited coachInfoEdited = new CoachInfoEdited(
                "coachTestId"
        );

        MembershipAdded membershipAdded = new MembershipAdded("registryTestId","membershipTestId",
                "gold", "bookingTestId", "coachTestId");


        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocationOnMock -> {
            return invocationOnMock.getArgument(0);
        });

        List<DomainEvent> domainEventList = membershipAddedUseCase.apply(membershipAdded);

        try {
            Assertions.assertEquals("coachTestId", domainEventList.get(0).getClass().getMethod("getCoachId").invoke(domainEventList.get(0)).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("bookingTestId", domainEventList.get(0).aggregateRootId());
    }

}