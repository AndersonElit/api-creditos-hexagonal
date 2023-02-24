package co.com.apicreditos.mongo.document;

import co.com.apicreditos.mongo.generic.models.StoredEvent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vinculacion")
public class EventDocument {

    @Id
    private String aggregateRootId;

    private StoredEvent storedEvent;

    public EventDocument() {
    }

    public EventDocument(String aggregateRootId, StoredEvent storedEvent) {
        this.aggregateRootId = aggregateRootId;
        this.storedEvent = storedEvent;
    }

    public String getAggregateRootId() {
        return aggregateRootId;
    }

    public void setAggregateRootId(String aggregateRootId) {
        this.aggregateRootId = aggregateRootId;
    }

    public StoredEvent getStoredEvent() {
        return storedEvent;
    }

    public void setStoredEvent(StoredEvent storedEvent) {
        this.storedEvent = storedEvent;
    }

}
