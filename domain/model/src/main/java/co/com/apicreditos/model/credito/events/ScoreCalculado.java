package co.com.apicreditos.model.credito.events;

import co.com.apicreditos.model.credito.enums.EstadoCredito;
import co.com.apicreditos.model.generic.DomainEvent;

public class ScoreCalculado extends DomainEvent {
    private final EstadoCredito estadoCredito;
    private final Double score;

    public ScoreCalculado(EstadoCredito estadoCredito, Double score) {
        super("ScoreCalculado");
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
