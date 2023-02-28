package co.com.apicreditos.model.vinculacion.command;

import co.com.apicreditos.model.generic.Command;
import co.com.apicreditos.model.vinculacion.entities.Asesor;
import co.com.apicreditos.model.vinculacion.entities.Cliente;
import co.com.apicreditos.model.vinculacion.entities.Oficina;

public class VincularClienteCommand extends Command {
    private String vinculacionId;

    public VincularClienteCommand() {
    }

    public VincularClienteCommand(String vinculacionId) {
        this.vinculacionId = vinculacionId;
    }

    public String getVinculacionId() {
        return vinculacionId;
    }

    public void setVinculacionId(String vinculacionId) {
        this.vinculacionId = vinculacionId;
    }

}
