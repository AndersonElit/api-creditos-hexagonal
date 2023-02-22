package co.com.apicreditos.model.vinculacion.values;

import co.com.apicreditos.model.generic.Identity;

public class VinculacionId extends Identity {

    public VinculacionId(String id) {
        super(id);
    }

    public VinculacionId() {
    }

    public static VinculacionId of(String id) {
        return new VinculacionId(id);
    }


}
