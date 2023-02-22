package co.com.apicreditos.usecase.credito;

import co.com.apicreditos.model.credito.command.CrearNuevoCreditoCommand;
import co.com.apicreditos.model.credito.entities.Credito;
import co.com.apicreditos.model.credito.values.CreditoId;
import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;
import co.com.apicreditos.usecase.credito.gateways.CreditoRepository;
import co.com.apicreditos.usecase.generic.UseCaseForCommand;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CrearNuevoCreditoUseCase extends UseCaseForCommand<CrearNuevoCreditoCommand> {

    private final CreditoRepository repository;

    public CrearNuevoCreditoUseCase(CreditoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<CrearNuevoCreditoCommand> crearNuevoCreditoCommandMono) {

        return crearNuevoCreditoCommandMono.flatMapIterable(command -> {
            Credito credito = new Credito(
                    CreditoId.of(command.getCreditoId()),
                    VinculacionId.of(command.getVinculacionId()),
                    command.getEstadoCredito()
            );
            credito.vincularCliente(VinculacionId.of(command.getVinculacionId()));
            credito.analizarHistorialCrediticio();
            credito.capacidadEndeudamiento();
            credito.valorPatrimonio();
            credito.consultaCentralesDeRiesgo();
            credito.calcularScore();
            return credito.getUncommittedChanges();
        }).flatMap(event -> repository.saveEvent(event));

    }
}
