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

    /*
    private Cliente cliente;
    private Asesor asesor;
    private Oficina oficina;

    public VincularClienteCommand() {
    }

    public VincularClienteCommand(String vinculacionId, Cliente cliente, Asesor asesor, Oficina oficina) {
        this.vinculacionId = vinculacionId;
        this.cliente = cliente;
        this.asesor = asesor;
        this.oficina = oficina;
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

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }*/

}
