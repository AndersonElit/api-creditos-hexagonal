package co.com.apicreditos.usecase.vinculacion;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.command.VincularClienteCommand;
import co.com.apicreditos.model.vinculacion.entities.Vinculacion;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;
import co.com.apicreditos.usecase.generic.UseCaseForCommand;
import co.com.apicreditos.usecase.generic.dto.EventDocumentDto;
import co.com.apicreditos.usecase.generic.gateways.EventBus;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;
import java.util.UUID;

public class VincularClienteUseCase extends UseCaseForCommand<VincularClienteCommand> {

    private final VinculacionRepository repository;
    private final EventBus bus;

    public VincularClienteUseCase(VinculacionRepository repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<VincularClienteCommand> vincularClienteCommandMono) {

        return vincularClienteCommandMono.flatMapIterable(command -> {
            Vinculacion vinculacion = new Vinculacion(
                    VinculacionId.of(command.getVinculacionId())
            );
            return vinculacion.getUncommittedChanges();
        }).flatMap(event -> repository.saveEvent(new EventDocumentDto(
                        UUID.randomUUID().toString(),
                        event.aggregateRootId(),
                        LocalDateTime.now(),
                        event.type,
                        event
                ))).map(event -> {
                    bus.publish(event);
                    return event;
        });
    }

}
