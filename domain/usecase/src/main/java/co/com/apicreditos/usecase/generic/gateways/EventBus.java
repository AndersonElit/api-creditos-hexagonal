package co.com.apicreditos.usecase.generic.gateways;

import co.com.apicreditos.model.generic.DomainEvent;

public interface EventBus {
    void publish(DomainEvent event);
    void publishError(Throwable errorEvent);
}
