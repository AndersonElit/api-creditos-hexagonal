package co.com.apicreditos.model.credito.events;

import co.com.apicreditos.model.credito.enums.EstadoCredito;
import co.com.apicreditos.model.generic.DomainEvent;

public class CentralesDeRiesgoConsultadas extends DomainEvent {

    private final EstadoCredito estadoCredito;

    public CentralesDeRiesgoConsultadas(EstadoCredito estadoCredito) {
        super("CentralesDeRiesgoConsultadas");
        this.estadoCredito = estadoCredito;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

}
