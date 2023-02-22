package co.com.apicreditos.usecase.vinculacion;

import co.com.apicreditos.model.credito.events.ClienteVinculado;
import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.entities.Vinculacion;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;

public class CrearClienteEventUseCase implements Function<Mono<ClienteVinculado>, Flux<DomainEvent>> {

    private final VinculacionRepository repository;

    public CrearClienteEventUseCase(VinculacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<ClienteVinculado> clienteVinculadoMono) {
        return clienteVinculadoMono.flatMapIterable(event -> {
            Vinculacion vinculacion = Vinculacion.from(VinculacionId.of(event.getVinculacionId().value()), List.of(event));
            vinculacion.crearCliente(event.getCliente());
            return vinculacion.getUncommittedChanges();
        }).flatMap(
                domainEvent -> repository.saveEvent(domainEvent)
        );
    }
}
