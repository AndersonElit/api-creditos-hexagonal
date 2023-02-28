package co.com.apicreditos.usecase.generic.dto;

import co.com.apicreditos.model.generic.DomainEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventDocumentDto {

    private String documentoId;
    private String aggregateRootId;
    private LocalDateTime occurredOn;
    private String typeName;
    private DomainEvent domainEvent;

    public EventDocumentDto() {
    }

    public EventDocumentDto(String documentoId, String aggregateRootId, LocalDateTime occurredOn, String typeName, DomainEvent domainEvent) {
        this.documentoId = documentoId;
        this.aggregateRootId = aggregateRootId;
        this.occurredOn = occurredOn;
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

}
