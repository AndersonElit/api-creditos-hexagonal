package co.com.apicreditos.mongo.adapter;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.mongo.document.EventDocument;
import co.com.apicreditos.mongo.generic.mapper.Mapper;
import co.com.apicreditos.mongo.repository.MongoEventRepository;
import co.com.apicreditos.usecase.generic.dto.EventDocumentDto;
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
    public Mono<DomainEvent> saveEvent(EventDocumentDto dto) {
        return repository.save(Mapper.map(dto, EventDocument.class))
                .map(eventDocument -> eventDocument.getDomainEvent());
    }

}
