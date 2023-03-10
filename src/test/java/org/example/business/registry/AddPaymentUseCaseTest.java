package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.domain.registry.commands.AddPaymentCommand;
import org.example.domain.registry.events.PaymentAdded;
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
class AddPaymentUseCaseTest {

    private Boolean testStatus = true;

    @Mock
    private EventsRepository eventsRepository;
    private AddPaymentUseCase addPaymentUseCase;

    @BeforeEach
    void setup(){ addPaymentUseCase = new AddPaymentUseCase(eventsRepository);}

    @Test
    void successfulScenario(){

        RegistryCreated registryCreated = new RegistryCreated();


        registryCreated.setAggregateRootId("registryTestId");

        AddPaymentCommand addPaymentCommand = new AddPaymentCommand(
                "registryTestId",
                "paymentTestId",
                "65934",
                "newTestDate",
                "6688");

        registryCreated.setAggregateRootId("registryTestId");

        PaymentAdded paymentAdded = new PaymentAdded("paymentTestId",
                "65934",
                "newTestDate",
                "6688");

        Mockito.when(eventsRepository.findByAggregateRootId("registryTestId"))
                .thenReturn(List.of(registryCreated));

        Mockito.when(eventsRepository.saveEvent(ArgumentMatchers.any())).thenAnswer(invocationOnMock -> {
            return invocationOnMock.getArgument(0);});

        List<DomainEvent> domainEventList = addPaymentUseCase.apply(addPaymentCommand);

        try {
            Assertions.assertEquals("65934", domainEventList.get(0).getClass().getMethod("getCardNumber").invoke(domainEventList.get(0)).toString());
            Assertions.assertEquals("newTestDate", domainEventList.get(0).getClass().getMethod("getExpirationDate").invoke(domainEventList.get(0)).toString());
            Assertions.assertEquals("6688", domainEventList.get(0).getClass().getMethod("getCardCode").invoke(domainEventList.get(0)).toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}