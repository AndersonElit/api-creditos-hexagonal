package co.com.apicreditos.usecase.vinculacion;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.command.ConsultarClienteCommand;
import co.com.apicreditos.model.vinculacion.entities.Vinculacion;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;
import co.com.apicreditos.usecase.generic.UseCaseForCommand;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ConsultarClienteUseCase extends UseCaseForCommand<ConsultarClienteCommand> {

    private final VinculacionRepository repository;

    public ConsultarClienteUseCase(VinculacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<ConsultarClienteCommand> consultarClienteCommandMono) {

        return consultarClienteCommandMono.flatMapMany(command -> repository.findById(command.getVinculacionId())
                .collectList()
                .flatMapIterable(events -> {
                    Vinculacion vinculacion = Vinculacion.from(VinculacionId.of(command.getVinculacionId()), events);
                    vinculacion.consultarCliente();
                    return vinculacion.getUncommittedChanges();
                }).flatMap(event -> repository.saveEvent(event)));

    }

}
