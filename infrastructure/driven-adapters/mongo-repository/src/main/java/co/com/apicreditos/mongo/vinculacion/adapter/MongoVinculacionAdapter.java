package co.com.apicreditos.mongo.vinculacion.adapter;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.mongo.generic.models.StoredEvent;
import co.com.apicreditos.mongo.vinculacion.document.VinculacionDocument;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class MongoVinculacionAdapter implements VinculacionRepository {


    //private final MongoVinculacionRepository repository;

    /*public MongoVinculacionAdapter(MongoVinculacionRepository repository) {
        this.repository = repository;
    }*/

    @Override
    public Flux<DomainEvent> findById(String aggregateId) {
        return null;
    }

    @Override
    public Mono<DomainEvent> saveEvent(DomainEvent event) {
        VinculacionDocument document = new VinculacionDocument();
        document.setAggregateRootId(event.aggregateRootId());
        document.setStoredEvent(new StoredEvent("eventBody", LocalDate.now(), "type"));
        System.out.println("Evento con id " + event.aggregateRootId() + " se guardo de forma exitosa.");
        return null;
    }

}
