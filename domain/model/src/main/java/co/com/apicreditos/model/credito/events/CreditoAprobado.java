package co.com.apicreditos.model.credito.events;

import co.com.apicreditos.model.credito.enums.EstadoCredito;
import co.com.apicreditos.model.credito.values.InformacionCreditoAprobado;
import co.com.apicreditos.model.generic.DomainEvent;

public class CreditoAprobado extends DomainEvent {
    private final EstadoCredito estadoCredito;
    private final Double score;
    private final InformacionCreditoAprobado informacionCreditoAprobado;

    public CreditoAprobado(EstadoCredito estadoCredito, Double score, InformacionCreditoAprobado informacionCreditoAprobado) {
        super("CreditoAprobado");
        this.estadoCredito = estadoCredito;
        this.score = score;
        this.informacionCreditoAprobado = informacionCreditoAprobado;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

    public Double getScore() {
        return score;
    }

    public InformacionCreditoAprobado getInformacionCreditoAprobado() {
        return informacionCreditoAprobado;
    }

}
