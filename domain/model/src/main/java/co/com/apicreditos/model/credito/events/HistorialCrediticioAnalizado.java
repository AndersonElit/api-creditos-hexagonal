package co.com.apicreditos.model.credito.events;

import co.com.apicreditos.model.credito.enums.EstadoCredito;
import co.com.apicreditos.model.generic.DomainEvent;

public class HistorialCrediticioAnalizado extends DomainEvent {
    private final EstadoCredito estadoCredito;

    public HistorialCrediticioAnalizado(EstadoCredito estadoCredito) {
        super("HistorialCrediticioAnalizado");
        this.estadoCredito = estadoCredito;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

}
