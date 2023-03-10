package org.example.business.registry;

import org.example.business.commons.EventsRepository;
import org.example.business.commons.UseCaseForCommand;
import org.example.domain.registry.Registry;
import org.example.domain.registry.commands.AddMembershipCommand;
import org.example.domain.registry.values.RegistryId;
import org.example.generic.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddMembershipUseCase implements UseCaseForCommand<AddMembershipCommand> {

    private final EventsRepository eventsRepository;

    public AddMembershipUseCase(EventsRepository eventsRepository){
        this.eventsRepository = eventsRepository;
    }
    @Override
    public List<DomainEvent> apply(AddMembershipCommand command) {
        List<DomainEvent> events = eventsRepository.findByAggregateRootId(command.getRegistryId());
        Registry registry = Registry.from(RegistryId.of(command.getRegistryId()), events);
        registry.addAMembership(command.getRegistryId(), command.getMembershipId(), command.getMembershipType(), command.getBookingId(), command.getCoachId());

        return registry.getUncommittedChanges().stream().map(eventsRepository::saveEvent).collect(Collectors.toList());
    }
}
