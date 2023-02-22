package co.com.apicreditos.model.vinculacion.events;

import co.com.apicreditos.model.generic.DomainEvent;

public class VinculacionCreada extends DomainEvent {

    private String vinculacionId;

    public VinculacionCreada() {
        super("VinculacionCreada");
    }

    public VinculacionCreada(String vinculacionId) {
        super("VinculacionCreada");
        this.vinculacionId = vinculacionId;
    }

    public String getVinculacionId() {
        return vinculacionId;
    }

}
