package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.domain.registry.commands.CreateRegistryCommand;
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
class CreateRegistryUseCaseTest {

    private Boolean testStatus = true;

    @Mock
    private EventsRepository eventsRepository;
    private CreateRegistryUseCase createRegistryUseCase;

    @BeforeEach
    void setup(){
        createRegistryUseCase = new CreateRegistryUseCase(eventsRepository);
    }

    @Test
    void successfulScenario(){

        CreateRegistryCommand createRegistryCommand = new CreateRegistryCommand(
                "registryTestId",
                "userTestId",
                "userTestName",
                "test@email",
                "556442",
                this.testStatus,
                "membershipTestId",
                "silver",
                "paymentTestId",
                "329874",
                "testDate",
                "5689"
        );

        RegistryCreated registryCreated = new RegistryCreated(
                "userTestId",
                "userTestName",
                "test@email",
                "556442",
                this.testStatus,
                "membershipTestId",
                "silver",
                "paymentTestId",
                "329874",
                "testDate",
                "5689"
        );

        registryCreated.setAggregateRootId("registryTestId");

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> domainEventList = createRegistryUseCase.apply(createRegistryCommand);

        Assertions.assertEquals(1, domainEventList.size());
        Assertions.assertEquals("registryTestId", domainEventList.get(0).aggregateRootId());
    }

}