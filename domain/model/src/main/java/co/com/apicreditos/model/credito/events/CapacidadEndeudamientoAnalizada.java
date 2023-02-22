package co.com.apicreditos.model.credito.events;

import co.com.apicreditos.model.credito.enums.EstadoCredito;
import co.com.apicreditos.model.generic.DomainEvent;

public class CapacidadEndeudamientoAnalizada extends DomainEvent {

    private final EstadoCredito estadoCredito;

    public CapacidadEndeudamientoAnalizada(EstadoCredito estadoCredito) {
        super("CapacidadEndeudamientoAnalizada");
        this.estadoCredito = estadoCredito;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

}
