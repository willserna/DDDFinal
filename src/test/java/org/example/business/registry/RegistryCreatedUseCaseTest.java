package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.domain.booking.events.BookingCreated;
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
class RegistryCreatedUseCaseTest {

    private Time time = new Time(12 , 30,0);

    @Mock
    private EventsRepository eventsRepository;
    private RegistryCreatedUseCase registryCreatedUseCase;

    @BeforeEach
    void setup(){
        registryCreatedUseCase = new RegistryCreatedUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        RegistryCreated registryCreated = new RegistryCreated(
                "userTestId",
                "userTestName",
                "test@email",
                "556442",
                true,
                "membershipTestId",
                "silver",
                "paymentTestId",
                "329874",
                "testDate",
                "5689",
                "bookingTestId",
                "coachTestId",
                "Test coach name",
                "coach@email",
                time
        );
        registryCreated.setAggregateRootId("registryTestId");


        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocationOnMock -> {
            return invocationOnMock.getArgument(0);
        });

        List<DomainEvent> domainEventList = registryCreatedUseCase.apply(registryCreated);

        Assertions.assertEquals(1, domainEventList.size());
        Assertions.assertEquals("bookingTestId", domainEventList.get(0).aggregateRootId());
        try {
            Assertions.assertEquals("Test coach name", domainEventList.get(0).getClass().getMethod("getCoachName").invoke(domainEventList.get(0)).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}