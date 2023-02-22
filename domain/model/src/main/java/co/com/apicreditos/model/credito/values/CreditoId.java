package co.com.apicreditos.model.credito.values;

import co.com.apicreditos.model.generic.Identity;

public class CreditoId extends Identity {

    public CreditoId() {
    }

    public CreditoId(String id) {
        super(id);
    }

    public static CreditoId of(String id) {
        return new CreditoId(id);
    }
}
