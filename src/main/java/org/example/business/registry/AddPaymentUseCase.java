package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.business.commons.UseCaseForCommand;
import org.example.domain.registry.Registry;
import org.example.domain.registry.commands.AddPaymentCommand;
import org.example.domain.registry.values.RegistryId;
import org.example.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddPaymentUseCase implements UseCaseForCommand<AddPaymentCommand> {

    private final EventsRepository eventsRepository;

    public AddPaymentUseCase(EventsRepository eventsRepository){

        this.eventsRepository = eventsRepository;
    }
    @Override
    public List<DomainEvent> apply(AddPaymentCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getRegistryId());
        Registry registry = Registry.from(RegistryId.of(command.getRegistryId()), events);
        registry.addAPayment(command.getPaymentId(), command.getCardNumber(), command.getExpirationDate(), command.getCardCode());
        return registry.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
