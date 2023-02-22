package co.com.apicreditos.model.vinculacion.command;

import co.com.apicreditos.model.generic.Command;
import co.com.apicreditos.model.vinculacion.entities.Cliente;

public class CrearClienteCommand extends Command {
    private String vinculacionId;
    private Cliente cliente;

    public CrearClienteCommand() {
    }

    public CrearClienteCommand(String vinculacionId, Cliente cliente) {
        this.vinculacionId = vinculacionId;
        this.cliente = cliente;
    }

    public String getVinculacionId() {
        return vinculacionId;
    }

    public void setVinculacionId(String vinculacionId) {
        this.vinculacionId = vinculacionId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
