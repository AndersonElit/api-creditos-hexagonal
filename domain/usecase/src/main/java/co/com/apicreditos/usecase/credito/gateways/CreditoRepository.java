package co.com.apicreditos.usecase.credito.gateways;

import co.com.apicreditos.model.generic.DomainEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditoRepository {
    Flux<DomainEvent> findById(String aggregateId);
    Mono<DomainEvent> saveEvent(DomainEvent event);
}
