package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.domain.registry.commands.EditPaymentInfo;
import org.example.domain.registry.events.PaymentInfoEdited;
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
class EditPaymentInfoUseCaseTest {

    @Mock
    private EventsRepository eventsRepository;
    private EditPaymentInfoUseCase editPaymentInfoUseCase;

    @BeforeEach
    void setUp() {
        editPaymentInfoUseCase = new EditPaymentInfoUseCase(eventsRepository);
    }

    @Test
    void successfulScenario() {

        RegistryCreated registryCreated = new RegistryCreated();

        registryCreated.setAggregateRootId("registryTestId");

        EditPaymentInfo editPaymentInfo = new EditPaymentInfo(
                "registryTestId",
                "55621",
                "testDate",
                "5541");

        PaymentInfoEdited paymentInfo = new PaymentInfoEdited(
                "55621",
                "testDate",
                "5541");

        Mockito.when(eventsRepository.findByAggregateRootId("registryTestId"))
                .thenReturn(List.of(registryCreated));

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocationOnMock -> {
            return invocationOnMock.getArgument(0);
        });

        List<DomainEvent> domainEventList = editPaymentInfoUseCase.apply(editPaymentInfo);

        try {
            Assertions.assertEquals("55621", domainEventList.get(0).getClass().getMethod("getCardNumber").invoke(domainEventList.get(0)).toString());
            Assertions.assertEquals("testDate", domainEventList.get(0).getClass().getMethod("getExpirationDate").invoke(domainEventList.get(0)).toString());
            Assertions.assertEquals("5541", domainEventList.get(0).getClass().getMethod("getCardCode").invoke(domainEventList.get(0)).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("registryTestId", domainEventList.get(0).aggregateRootId());

    }
}