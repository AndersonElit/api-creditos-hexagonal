package co.com.apicreditos.model.vinculacion.values;

import co.com.apicreditos.model.generic.ValueObject;
import co.com.apicreditos.model.vinculacion.enums.TipoContrato;

import java.time.LocalDate;

public class Contrato implements ValueObject<Contrato.Props> {
    private TipoContrato tipoContrato;
    private LocalDate fechaIngreso;
    private String eps;

    @Override
    public Props value() {
        return new Props() {
            @Override
            public TipoContrato tipoContrato() {
                return tipoContrato;
            }

            @Override
            public LocalDate fechaIngreso() {
                return fechaIngreso;
            }

            @Override
            public String eps() {
                return eps;
            }
        };
    }

    public interface Props {
        TipoContrato tipoContrato();
        LocalDate fechaIngreso();
        String eps();
    }

}
