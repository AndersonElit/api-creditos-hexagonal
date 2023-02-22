package co.com.apicreditos.usecase.credito;

import co.com.apicreditos.model.credito.command.ConsultarCreditoCommand;
import co.com.apicreditos.model.credito.entities.Credito;
import co.com.apicreditos.model.credito.values.CreditoId;
import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.usecase.credito.gateways.CreditoRepository;
import co.com.apicreditos.usecase.generic.UseCaseForCommand;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ConsultarCreditoUseCase extends UseCaseForCommand<ConsultarCreditoCommand> {

    private final CreditoRepository repository;

    public ConsultarCreditoUseCase(CreditoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<ConsultarCreditoCommand> consultarCreditoCommandMono) {

        return consultarCreditoCommandMono.flatMapMany(command -> repository.findById(command.getCreditoId())
                .collectList()
                .flatMapIterable(events -> {
                    Credito credito = Credito.from(CreditoId.of(command.getCreditoId()), events);
                    credito.consultarCredito();
                    return credito.getUncommittedChanges();
                }).flatMap(event -> repository.saveEvent(event))
        );

    }

}
