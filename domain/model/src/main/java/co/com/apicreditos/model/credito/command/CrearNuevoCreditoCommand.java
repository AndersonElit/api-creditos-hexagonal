package co.com.apicreditos.model.credito.command;

import co.com.apicreditos.model.credito.enums.EstadoCredito;
import co.com.apicreditos.model.credito.values.InformacionCreditoAprobado;
import co.com.apicreditos.model.generic.Command;

public class CrearNuevoCreditoCommand extends Command {

    private String creditoId;
    private String vinculacionId;
    private InformacionCreditoAprobado informacionCreditoAprobado;
    private EstadoCredito estadoCredito;

    public CrearNuevoCreditoCommand() {
    }

    public CrearNuevoCreditoCommand(String creditoId, String vinculacionId, InformacionCreditoAprobado informacionCreditoAprobado, EstadoCredito estadoCredito) {
        this.creditoId = creditoId;
        this.vinculacionId = vinculacionId;
        this.informacionCreditoAprobado = informacionCreditoAprobado;
        this.estadoCredito = estadoCredito;
    }

    public String getCreditoId() {
        return creditoId;
    }

    public void setCreditoId(String creditoId) {
        this.creditoId = creditoId;
    }

    public String getVinculacionId() {
        return vinculacionId;
    }

    public void setVinculacionId(String vinculacionId) {
        this.vinculacionId = vinculacionId;
    }

    public InformacionCreditoAprobado getInformacionCreditoAprobado() {
        return informacionCreditoAprobado;
    }

    public void setInformacionCreditoAprobado(InformacionCreditoAprobado informacionCreditoAprobado) {
        this.informacionCreditoAprobado = informacionCreditoAprobado;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

    public void setEstadoCredito(EstadoCredito estadoCredito) {
        this.estadoCredito = estadoCredito;
    }
}
