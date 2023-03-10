package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.domain.registry.commands.AddMembershipCommand;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddMembershipUseCaseTest {


    @Mock
    private EventsRepository eventsRepository;
    private AddMembershipUseCase addMembershipUseCase;

    @BeforeEach
    void setup(){ addMembershipUseCase = new AddMembershipUseCase(eventsRepository);}

    @Test
    void successfulScenario(){

        RegistryCreated registryCreated = new RegistryCreated();

        registryCreated.setAggregateRootId("registryTestId");

        AddMembershipCommand addMembershipCommand = new AddMembershipCommand(
                "registryTestId",
                "membershipTestId",
                "gold",
                "bookingTestId",
                "coachTestId");

        MembershipAdded membershipAdded = new MembershipAdded("registryTestId","membershipTestId",
                "gold", "bookingTestId", "coachTestId");

        Mockito.when(eventsRepository.findByAggregateRootId("registryTestId"))
                .thenReturn(List.of(registryCreated));

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocationOnMock -> {
            return invocationOnMock.getArgument(0);
        });

        List<DomainEvent> domainEventList = addMembershipUseCase.apply(addMembershipCommand);

        try {
            Assertions.assertEquals("gold", domainEventList.get(0).getClass().getMethod("getMembershipType").invoke(domainEventList.get(0)).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("registryTestId", domainEventList.get(0).aggregateRootId());

    }



}