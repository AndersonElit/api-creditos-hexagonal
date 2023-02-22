package co.com.apicreditos.model.credito.events;

import co.com.apicreditos.model.credito.enums.EstadoCredito;
import co.com.apicreditos.model.generic.DomainEvent;

public class ValorPatrimonioDeterminado extends DomainEvent {

    private final EstadoCredito estadoCredito;

    public ValorPatrimonioDeterminado(EstadoCredito estadoCredito) {
        super("ValorPatrimonioDeterminado");
        this.estadoCredito = estadoCredito;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

}
