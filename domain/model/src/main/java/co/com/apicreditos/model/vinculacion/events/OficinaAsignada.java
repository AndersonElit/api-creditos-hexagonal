package co.com.apicreditos.model.vinculacion.events;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.entities.Oficina;

public class OficinaAsignada extends DomainEvent {

    private final Oficina oficina;

    public OficinaAsignada(Oficina oficina) {
        super("OficinaAsignada");
        this.oficina = oficina;
    }

    public Oficina getOficina() {
        return oficina;
    }

}
