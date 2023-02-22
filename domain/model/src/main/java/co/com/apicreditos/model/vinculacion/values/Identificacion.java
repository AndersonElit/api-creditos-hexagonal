package co.com.apicreditos.model.vinculacion.values;

import co.com.apicreditos.model.generic.ValueObject;
import co.com.apicreditos.model.vinculacion.enums.TipoIdentificacion;

public class Identificacion implements ValueObject<Identificacion.Props> {
    private TipoIdentificacion tipoIdentificacion;
    private String numeroIdentificacion;

    @Override
    public Props value() {
        return new Props() {
            @Override
            public TipoIdentificacion tipoIdentificacion() {
                return tipoIdentificacion;
            }

            @Override
            public String numeroIdentificacion() {
                return numeroIdentificacion;
            }
        };
    }


    public interface Props {
        TipoIdentificacion tipoIdentificacion();
        String numeroIdentificacion();
    }

}
