package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.business.commons.UseCaseForCommand;
import org.example.domain.registry.Registry;
import org.example.domain.registry.commands.EditUserInfoCommand;
import org.example.domain.registry.values.RegistryId;
import org.example.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditUserInfoUseCase implements UseCaseForCommand<EditUserInfoCommand> {

    private final EventsRepository eventsRepository;

    public EditUserInfoUseCase(EventsRepository eventsRepository){
        this.eventsRepository = eventsRepository;
    }
    @Override
    public List<DomainEvent> apply(EditUserInfoCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getRegistryId());
        Registry registry = Registry.from(RegistryId.of(command.getRegistryId()), events);
        registry.editUserInfo(command.getUserName(), command.getUserEmail(), command.getPhoneNumber(), command.getStatus());
        return registry.getUncommittedChanges().stream().map(eventsRepository::saveEvent).toList();
    }
}
