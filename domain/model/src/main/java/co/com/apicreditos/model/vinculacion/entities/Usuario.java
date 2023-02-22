package co.com.apicreditos.model.vinculacion.entities;

import co.com.apicreditos.model.generic.Entity;
import co.com.apicreditos.model.vinculacion.enums.Estado;
import co.com.apicreditos.model.vinculacion.values.*;

public class Usuario extends Entity<UsuarioId> {

    private InformacionBasica informacionBasica;
    private InformacionDemografica informacionDemografica;
    private InformacionAdicional informacionAdicional;
    private Contacto contacto;
    private Estado estado;

    public Usuario(UsuarioId id, InformacionBasica informacionBasica, InformacionDemografica informacionDemografica, InformacionAdicional informacionAdicional, Contacto contacto, Estado estado) {
        super(id);
        this.informacionBasica = informacionBasica;
        this.informacionDemografica = informacionDemografica;
        this.informacionAdicional = informacionAdicional;
        this.contacto = contacto;
        this.estado = estado;
    }

    public Usuario(UsuarioId id) {
        super(id);
    }

    public InformacionBasica informacionBasica() {
        return informacionBasica;
    }
    public InformacionDemografica informacionDemografica() {
        return informacionDemografica;
    }
    public InformacionAdicional informacionAdicional() {
        return informacionAdicional;
    }

    public Contacto contacto() {
        return contacto;
    }

    public void cambiarEstadoActivo() {
        this.estado = Estado.ACTIVO;
    }

    public void cambiarEstadoInactivo() {
        this.estado = Estado.INACTIVO;
    }

}
