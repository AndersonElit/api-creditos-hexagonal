package co.com.apicreditos.model.credito.events;

import co.com.apicreditos.model.credito.enums.EstadoCredito;
import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.entities.Cliente;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;

public class ClienteVinculado extends DomainEvent {
    private VinculacionId vinculacionId;
    private EstadoCredito estadoCredito;
    private Cliente cliente;

    public ClienteVinculado(VinculacionId vinculacionId, EstadoCredito estadoCredito, Cliente cliente) {
        super("ClienteVinculado");
        this.vinculacionId = vinculacionId;
        this.estadoCredito = estadoCredito;
        this.cliente = cliente;
    }

    public ClienteVinculado( VinculacionId vinculacionId, EstadoCredito estadoCredito) {
        super("ClienteVinculado");
        this.vinculacionId = vinculacionId;
        this.estadoCredito = estadoCredito;
    }

    public VinculacionId getVinculacionId() {
        return vinculacionId;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
