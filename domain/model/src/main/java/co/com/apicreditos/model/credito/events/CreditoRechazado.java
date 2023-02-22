package co.com.apicreditos.model.credito.events;

import co.com.apicreditos.model.credito.enums.EstadoCredito;
import co.com.apicreditos.model.generic.DomainEvent;

public class CreditoRechazado extends DomainEvent {
    private final EstadoCredito estadoCredito;
    private final Double score;

    public CreditoRechazado(EstadoCredito estadoCredito, Double score) {
        super("CreditoRechazado");
        this.estadoCredito = estadoCredito;
        this.score = score;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

    public Double getScore() {
        return score;
    }

}
