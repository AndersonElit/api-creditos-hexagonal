package co.com.apicreditos.model.vinculacion.values;

import co.com.apicreditos.model.generic.Identity;

public class OficinaId extends Identity {

    public OficinaId() {
    }

    public OficinaId(String id) {
        super(id);
    }

    public static OficinaId of(String id) {
        return new OficinaId(id);
    }

}
