package co.com.apicreditos.usecase.vinculacion;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.command.VincularClienteCommand;
import co.com.apicreditos.model.vinculacion.entities.Vinculacion;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;
import co.com.apicreditos.usecase.generic.UseCaseForCommand;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
            vinculacion.crearCliente(command.getCliente());
            vinculacion.asignarAsesor(command.getAsesor());
            vinculacion.asignarOficina(command.getOficina());
            return vinculacion.getUncommittedChanges();
        }).flatMap(
                event -> repository.saveEvent(event));
    }

}
