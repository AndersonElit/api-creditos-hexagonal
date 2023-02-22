package co.com.apicreditos.model.credito.events;

import co.com.apicreditos.model.generic.DomainEvent;

public class CreditoCreado extends DomainEvent {

    public CreditoCreado() {
        super("CreditoCreado");
    }
}
