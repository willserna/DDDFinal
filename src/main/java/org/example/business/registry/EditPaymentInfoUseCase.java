package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.business.commons.UseCaseForCommand;
import org.example.domain.registry.Registry;
import org.example.domain.registry.commands.EditPaymentInfo;
import org.example.domain.registry.values.RegistryId;
import org.example.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditPaymentInfoUseCase  implements UseCaseForCommand<EditPaymentInfo> {

    private final EventsRepository eventsRepository;

    public EditPaymentInfoUseCase(EventsRepository eventsRepository){
        this.eventsRepository = eventsRepository;
    }
    @Override
    public List<DomainEvent> apply(EditPaymentInfo command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getRegistryId());
        Registry registry = Registry.from(RegistryId.of(command.getRegistryId()), events);
        registry.editPaymentInfo(command.getCardNumber(), command.getExpirationDate(), command.getCardCode());
        return registry.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
