package co.com.apicreditos.model.vinculacion.events;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.entities.Cliente;

public class ClienteCreado extends DomainEvent {

    private final Cliente cliente;

    public ClienteCreado(Cliente cliente) {
        super("ClienteCreado");
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
