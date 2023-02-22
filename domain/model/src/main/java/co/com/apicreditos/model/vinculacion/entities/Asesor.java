package co.com.apicreditos.model.vinculacion.entities;

import co.com.apicreditos.model.vinculacion.enums.Estado;
import co.com.apicreditos.model.vinculacion.values.*;

public class Asesor extends Usuario {

    private Contrato contrato;

    public Asesor(UsuarioId id, InformacionBasica informacionBasica, InformacionDemografica informacionDemografica, InformacionAdicional informacionAdicional,
                  Contacto contacto, Estado estado, Contrato contrato) {
        super(id, informacionBasica, informacionDemografica, informacionAdicional, contacto, estado);
        this.contrato = contrato;
    }

    public Asesor(UsuarioId id) {
        super(id);
    }

    public Contrato contrato() {
        return contrato;
    }
}
