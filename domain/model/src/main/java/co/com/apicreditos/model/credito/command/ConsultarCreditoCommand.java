package co.com.apicreditos.model.credito.command;

import co.com.apicreditos.model.generic.Command;

public class ConsultarCreditoCommand extends Command {
    private String creditoId;

    public ConsultarCreditoCommand(String creditoId) {
        this.creditoId = creditoId;
    }

    public String getCreditoId() {
        return creditoId;
    }

    public void setCreditoId(String creditoId) {
        this.creditoId = creditoId;
    }

}
