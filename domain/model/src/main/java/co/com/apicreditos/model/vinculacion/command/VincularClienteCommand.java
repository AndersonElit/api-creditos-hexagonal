package co.com.apicreditos.model.vinculacion.command;

import co.com.apicreditos.model.generic.Command;
import co.com.apicreditos.model.vinculacion.entities.Asesor;
import co.com.apicreditos.model.vinculacion.entities.Cliente;
import co.com.apicreditos.model.vinculacion.entities.Oficina;

public class VincularClienteCommand extends Command {
    private String vinculacionId;
    private String clienteId;

    public VincularClienteCommand() {
    }

    public VincularClienteCommand(String vinculacionId, String clienteId) {
        this.vinculacionId = vinculacionId;
        this.clienteId = clienteId;
    }

    public String getVinculacionId() {
        return vinculacionId;
    }

    public void setVinculacionId(String vinculacionId) {
        this.vinculacionId = vinculacionId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

}
