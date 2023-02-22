package co.com.apicreditos.model.vinculacion.values;

import co.com.apicreditos.model.generic.Identity;

public class UsuarioId extends Identity {

    public UsuarioId() {
    }

    public UsuarioId(String id) {
        super(id);
    }

    public static UsuarioId of(String id) {
        return new UsuarioId(id);
    }

}
