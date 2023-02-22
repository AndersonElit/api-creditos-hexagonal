package co.com.apicreditos.model.vinculacion.values;

import co.com.apicreditos.model.generic.ValueObject;
import co.com.apicreditos.model.vinculacion.enums.Banco;
import co.com.apicreditos.model.vinculacion.enums.TipoCuenta;

public class DatosBancarios implements ValueObject<DatosBancarios.Props> {
    private final Banco banco;
    private final TipoCuenta tipoCuenta;
    private final String numeroCuenta;

    public DatosBancarios(Banco banco, TipoCuenta tipoCuenta, String numeroCuenta) {
        this.banco = banco;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Banco banco() {
                return banco;
            }

            @Override
            public TipoCuenta tipoCuenta() {
                return tipoCuenta;
            }

            @Override
            public String numeroCuenta() {
                return numeroCuenta;
            }
        };
    }

    public interface Props {
        Banco banco();
        TipoCuenta tipoCuenta();
        String numeroCuenta();
    }

}
