package co.com.apicreditos.model.credito.entities;

import co.com.apicreditos.model.credito.enums.EstadoCredito;
import co.com.apicreditos.model.credito.events.*;
import co.com.apicreditos.model.credito.values.CreditoId;
import co.com.apicreditos.model.credito.values.InformacionCreditoAprobado;
import co.com.apicreditos.model.generic.AggregateRoot;
import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;

import java.time.LocalDate;
import java.util.List;

public class Credito extends AggregateRoot<CreditoId> {

    protected VinculacionId vinculacionId;
    protected InformacionCreditoAprobado informacionCreditoAprobado;
    protected EstadoCredito estadoCredito;
    protected LocalDate fechaCreacion;

    private Credito(CreditoId id) {
        super(id);
    }

    public static Credito from(CreditoId creditoId, List<DomainEvent> events) {
        var credito = new Credito(creditoId);
        events.forEach(credito::applyEvent);
        return credito;
    }

    public Credito(CreditoId id, VinculacionId vinculacionId, EstadoCredito estadoCredito) {
        super(id);
        subscribe(new CreditoEventChange(this));
        appendChange(new CreditoCreado()).apply();
    }

    public void vincularCliente(VinculacionId vinculacionId) {
        appendChange(new ClienteVinculado(vinculacionId, EstadoCredito.VINCULACIONCLIENTE)).apply();
    }

    public void analizarHistorialCrediticio() {
        appendChange(new HistorialCrediticioAnalizado(EstadoCredito.ENANALISIS)).apply();
    }

    public void capacidadEndeudamiento() {
        appendChange(new CapacidadEndeudamientoAnalizada(EstadoCredito.ENANALISIS)).apply();
    }

    public void valorPatrimonio() {
        appendChange(new ValorPatrimonioDeterminado(EstadoCredito.ENANALISIS)).apply();
    }

    public void consultaCentralesDeRiesgo() {
        appendChange(new CentralesDeRiesgoConsultadas(EstadoCredito.ENANALISIS)).apply();
    }

    public void calcularScore() {
        Double score = 75.0;
        if(score >= 70.0) {
            appendChange(new ScoreCalculado(EstadoCredito.APROBADO, score)).apply();
            appendChange(new CreditoAprobado(EstadoCredito.APROBADO, score, new InformacionCreditoAprobado())).apply();
        } else {
            appendChange(new ScoreCalculado(EstadoCredito.RECHAZADO, score)).apply();
            appendChange(new CreditoRechazado(EstadoCredito.RECHAZADO, score)).apply();
        }
    }

    public void consultarCredito() {
        appendChange(new CreditoConsultado()).apply();
    }

}
