package co.com.apicreditos.model.vinculacion.entities;

import co.com.apicreditos.model.generic.EventChange;
import co.com.apicreditos.model.vinculacion.events.AsesorAsignado;
import co.com.apicreditos.model.vinculacion.events.ClienteCreado;
import co.com.apicreditos.model.vinculacion.events.OficinaAsignada;
import co.com.apicreditos.model.vinculacion.events.VinculacionCreada;

import java.time.LocalDate;

public class VinculacionEventChange extends EventChange {

    public VinculacionEventChange(Vinculacion vinculacion) {
        apply((VinculacionCreada event) -> {
            vinculacion.fechaViculacion = LocalDate.now();
        });
        apply((ClienteCreado event) -> {
            vinculacion.cliente = event.getCliente();
        });
        apply((AsesorAsignado event) -> {
            vinculacion.asesor = event.getAsesor();
        });
        apply((OficinaAsignada event) -> {
            vinculacion.oficina = event.getOficina();
        });
    }
}
