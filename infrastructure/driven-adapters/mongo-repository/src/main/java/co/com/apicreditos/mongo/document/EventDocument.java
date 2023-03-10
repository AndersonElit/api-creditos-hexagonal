package co.com.apicreditos.mongo.document;

import co.com.apicreditos.model.generic.DomainEvent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(value = "vinculacion")
public class EventDocument {

    @Id
    private String documentoId;
    private LocalDateTime occurredOn;
    private String aggregateRootId;
    private String typeName;
    private DomainEvent domainEvent;

    public EventDocument() {
    }

    public EventDocument(String documentoId, LocalDateTime occurredOn, String aggregateRootId, String typeName, DomainEvent domainEvent) {
        this.documentoId = documentoId;
        this.occurredOn = occurredOn;
        this.aggregateRootId = aggregateRootId;
        this.typeName = typeName;
        this.domainEvent = domainEvent;
    }

    public String getAggregateRootId() {
        return aggregateRootId;
    }

    public void setAggregateRootId(String aggregateRootId) {
        this.aggregateRootId = aggregateRootId;
    }

    public LocalDateTime getOccurredOn() {
        return occurredOn;
    }

    public void setOccurredOn(LocalDateTime occurredOn) {
        this.occurredOn = occurredOn;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public DomainEvent getDomainEvent() {
        return domainEvent;
    }

    public void setDomainEvent(DomainEvent domainEvent) {
        this.domainEvent = domainEvent;
    }

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }
}
