package co.com.apicreditos.model.vinculacion.events;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.entities.Asesor;

public class AsesorAsignado extends DomainEvent {
    private final Asesor asesor;

    public AsesorAsignado(Asesor asesor) {
        super("AsesorAsignado");
        this.asesor = asesor;
    }

    public Asesor getAsesor() {
        return asesor;
    }

}
