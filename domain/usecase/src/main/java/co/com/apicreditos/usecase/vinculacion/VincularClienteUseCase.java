package co.com.apicreditos.usecase.vinculacion;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.command.VincularClienteCommand;
import co.com.apicreditos.model.vinculacion.entities.Vinculacion;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;
import co.com.apicreditos.usecase.generic.UseCaseForCommand;
import co.com.apicreditos.usecase.generic.dto.EventDocumentDto;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;
import java.util.UUID;

public class VincularClienteUseCase extends UseCaseForCommand<VincularClienteCommand> {

    private final VinculacionRepository repository;

    public VincularClienteUseCase(VinculacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<VincularClienteCommand> vincularClienteCommandMono) {

        return vincularClienteCommandMono.flatMapIterable(command -> {
            Vinculacion vinculacion = new Vinculacion(
                    VinculacionId.of(command.getVinculacionId())
            );
            //vinculacion.crearCliente(new Cliente(UsuarioId.of(command.getClienteId())));
            //vinculacion.asignarAsesor(command.getAsesor());
            //vinculacion.asignarOficina(command.getOficina());
            return vinculacion.getUncommittedChanges();
        }).flatMap(event -> repository.saveEvent(new EventDocumentDto(
                        UUID.randomUUID().toString(),
                        event.aggregateRootId(),
                        LocalDateTime.now(),
                        event.type,
                        event
                )));
    }

}
