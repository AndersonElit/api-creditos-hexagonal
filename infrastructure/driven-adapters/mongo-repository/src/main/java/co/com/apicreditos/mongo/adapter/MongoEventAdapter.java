package co.com.apicreditos.mongo.adapter;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.events.VinculacionCreada;
import co.com.apicreditos.mongo.generic.models.StoredEvent;
import co.com.apicreditos.mongo.document.EventDocument;
import co.com.apicreditos.mongo.repository.MongoEventRepository;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class MongoEventAdapter implements VinculacionRepository {


    private final MongoEventRepository repository;

    public MongoEventAdapter(MongoEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> findById(String aggregateId) {
        return null;
    }

    @Override
    public Mono<DomainEvent> saveEvent(DomainEvent event) {
        EventDocument document = new EventDocument();
        document.setAggregateRootId(event.aggregateRootId());
        document.setOccurredOn(LocalDate.now());
        document.setTypeName(event.type);
        Mono<EventDocument> savedEvent = repository.save(document);
        return savedEvent.map(eventDocument -> new VinculacionCreada(eventDocument.getAggregateRootId()));
    }

}
