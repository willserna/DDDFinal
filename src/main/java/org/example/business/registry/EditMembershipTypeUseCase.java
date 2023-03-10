package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.business.commons.UseCaseForCommand;
import org.example.domain.registry.Registry;
import org.example.domain.registry.commands.EditMembershipTypeCommand;
import org.example.domain.registry.values.RegistryId;
import org.example.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EditMembershipTypeUseCase implements UseCaseForCommand<EditMembershipTypeCommand> {

    private final EventsRepository eventsRepository;

    public EditMembershipTypeUseCase(EventsRepository eventsRepository){
        this.eventsRepository = eventsRepository;
    }
    @Override
    public List<DomainEvent> apply(EditMembershipTypeCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getRegistryId());
        Registry registry = Registry.from(RegistryId.of(command.getRegistryId()), events);
        registry.editMembershipType(command.getMembershipType());

        return registry.getUncommittedChanges().stream().map(eventsRepository::saveEvent).collect(Collectors.toList());
    }
}
