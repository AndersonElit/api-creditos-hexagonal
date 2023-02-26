package co.com.apicreditos.mongo.document;

import co.com.apicreditos.mongo.generic.models.StoredEvent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(value = "vinculacion")
public class EventDocument {

    @Id
    private String aggregateRootId;
    private LocalDate occurredOn;
    private String typeName;

    public EventDocument() {
    }

    public EventDocument(String aggregateRootId, LocalDate occurredOn, String typeName) {
        this.aggregateRootId = aggregateRootId;
        this.occurredOn = occurredOn;
        this.typeName = typeName;
    }

    public String getAggregateRootId() {
        return aggregateRootId;
    }

    public void setAggregateRootId(String aggregateRootId) {
        this.aggregateRootId = aggregateRootId;
    }

    public LocalDate getOccurredOn() {
        return occurredOn;
    }

    public void setOccurredOn(LocalDate occurredOn) {
        this.occurredOn = occurredOn;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
