package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.business.commons.UseCaseForCommand;
import org.example.domain.registry.Registry;
import org.example.domain.registry.commands.CreateRegistryCommand;
import org.example.domain.registry.values.RegistryId;
import org.example.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateRegistryUseCase implements UseCaseForCommand<CreateRegistryCommand> {

    private final EventsRepository eventsRepository;

    public CreateRegistryUseCase(EventsRepository eventsRepository){
        this.eventsRepository = eventsRepository;
    }
    @Override
    public List<DomainEvent> apply(CreateRegistryCommand command) {
        Registry registry = new Registry(RegistryId.of(command.getRegistryId()), command.getUserId(), command.getUserName(),
                command.getUserEmail(), command.getPhoneNumber(), command.getStatus(), command.getMembershipId(), command.getMembershipType(),
                command.getPaymentId(), command.getCardNumber(), command.getExpirationDate(), command.getCardCode());

        return registry.getUncommittedChanges().stream().map(event -> eventsRepository.saveEvent(event)).toList();
    }
}
