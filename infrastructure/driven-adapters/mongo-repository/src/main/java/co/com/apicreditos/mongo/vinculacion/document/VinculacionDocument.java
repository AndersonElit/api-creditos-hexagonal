package co.com.apicreditos.mongo.vinculacion.document;

import co.com.apicreditos.mongo.generic.models.StoredEvent;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "vinculaciones")
public class VinculacionDocument {

    @Id
    private String aggregateRootId;

    private StoredEvent storedEvent;

    public VinculacionDocument() {
    }

    public VinculacionDocument(String aggregateRootId, StoredEvent storedEvent) {
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
