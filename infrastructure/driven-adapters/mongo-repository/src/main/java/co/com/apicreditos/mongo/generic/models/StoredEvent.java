package co.com.apicreditos.mongo.generic.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class StoredEvent {

    private String eventBody;
    private LocalDate occurredOn;
    private String typeName;

    public StoredEvent() {
    }

    public StoredEvent(String eventBody, LocalDate occurredOn, String typeName) {
        this.eventBody = eventBody;
        this.occurredOn = occurredOn;
        this.typeName = typeName;
    }

    public String getEventBody() {
        return eventBody;
    }

    public void setEventBody(String eventBody) {
        this.eventBody = eventBody;
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
