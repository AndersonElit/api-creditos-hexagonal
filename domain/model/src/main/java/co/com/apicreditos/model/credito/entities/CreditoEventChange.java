package co.com.apicreditos.model.credito.entities;

import co.com.apicreditos.model.credito.events.*;
import co.com.apicreditos.model.generic.EventChange;

import java.time.LocalDate;

public class CreditoEventChange extends EventChange {

    public CreditoEventChange(Credito credito) {
        apply((CreditoCreado event) -> {
            credito.fechaCreacion = LocalDate.now();
        });
        apply((ClienteVinculado event) -> {
            credito.vinculacionId = event.getVinculacionId();
        });
        apply((CapacidadEndeudamientoAnalizada event) -> {
            credito.estadoCredito = event.getEstadoCredito();
        });
        apply((CentralesDeRiesgoConsultadas event) -> {
            credito.estadoCredito = event.getEstadoCredito();
        });
        apply((HistorialCrediticioAnalizado event) -> {
            credito.estadoCredito = event.getEstadoCredito();
        });
        apply((ValorPatrimonioDeterminado event) -> {
            credito.estadoCredito = event.getEstadoCredito();
        });
        apply((ScoreCalculado event) -> {
            credito.estadoCredito = event.getEstadoCredito();
        });
        apply((CreditoAprobado event) -> {
            credito.estadoCredito = event.getEstadoCredito();
            credito.informacionCreditoAprobado = event.getInformacionCreditoAprobado();
        });
        apply((CreditoRechazado event) -> {
            credito.estadoCredito = event.getEstadoCredito();
        });
    }
}
