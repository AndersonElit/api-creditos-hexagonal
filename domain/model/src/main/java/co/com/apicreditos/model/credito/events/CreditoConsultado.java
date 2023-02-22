package co.com.apicreditos.model.credito.events;

import co.com.apicreditos.model.generic.DomainEvent;

public class CreditoConsultado extends DomainEvent {

    public CreditoConsultado() {
        super("CreditoConsultado");
    }

}
