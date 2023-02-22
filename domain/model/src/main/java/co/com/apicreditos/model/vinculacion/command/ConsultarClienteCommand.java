package co.com.apicreditos.model.vinculacion.command;

import co.com.apicreditos.model.generic.Command;

public class ConsultarClienteCommand extends Command {
    private String vinculacionId;

    public ConsultarClienteCommand(String vinculacionId) {
        this.vinculacionId = vinculacionId;
    }

    public String getVinculacionId() {
        return vinculacionId;
    }

    public void setVinculacionId(String vinculacionId) {
        this.vinculacionId = vinculacionId;
    }

}
