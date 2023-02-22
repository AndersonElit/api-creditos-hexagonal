package co.com.apicreditos.model.vinculacion.entities;

import co.com.apicreditos.model.generic.AggregateEvent;
import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.events.*;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;

import java.time.LocalDate;
import java.util.List;

public class Vinculacion extends AggregateEvent<VinculacionId> {
    protected Cliente cliente;
    protected Asesor asesor;
    protected Oficina oficina;
    protected LocalDate fechaViculacion;

    public Vinculacion(VinculacionId id) {
        super(id);
        subscribe(new VinculacionEventChange(this));
        appendChange(new VinculacionCreada()).apply();
    }

    public static Vinculacion from(VinculacionId vinculacionId, List<DomainEvent> events) {
        var vinculacion = new Vinculacion(vinculacionId);
        events.forEach(vinculacion::applyEvent);
        return vinculacion;
    }

    public void crearCliente(Cliente cliente) {
        appendChange(new ClienteCreado(cliente)).apply();
    }

    public void asignarAsesor(Asesor asesor) {
        appendChange(new AsesorAsignado(asesor)).apply();
    }

    public void asignarOficina(Oficina oficina) {
        appendChange(new OficinaAsignada(oficina)).apply();
    }

    public void consultarCliente() {
        appendChange(new ClienteConsultado()).apply();
    }

}
