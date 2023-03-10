package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.domain.registry.commands.EditMembershipTypeCommand;
import org.example.domain.registry.commands.EditUserInfoCommand;
import org.example.domain.registry.events.MembershipTypeEdited;
import org.example.domain.registry.events.RegistryCreated;
import org.example.domain.registry.events.UserInfoEdited;
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
class EditUserInfoUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private EditUserInfoUseCase editUserInfoUseCase;

    @BeforeEach
    void setup() {
        editUserInfoUseCase = new EditUserInfoUseCase(eventsRepository);
    }

    @Test
    void successfulScenario() {

        RegistryCreated registryCreated = new RegistryCreated();

        registryCreated.setAggregateRootId("registryTestId");

        EditUserInfoCommand editUserInfoCommand = new EditUserInfoCommand(
                "registryTestId", "userTestName", "test@email", "5566877", true);

        UserInfoEdited userInfoEdited = new UserInfoEdited("userTestName", "test@email", "5566877", true);

        Mockito.when(eventsRepository.findByAggregateRootId("registryTestId"))
                .thenReturn(List.of(registryCreated));

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocationOnMock -> {
            return invocationOnMock.getArgument(0);
        });

        List<DomainEvent> domainEventList = editUserInfoUseCase.apply(editUserInfoCommand);

        try {
            Assertions.assertEquals("test@email", domainEventList.get(0).getClass().getMethod("getUserEmail").invoke(domainEventList.get(0)).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("registryTestId", domainEventList.get(0).aggregateRootId());

    }
}