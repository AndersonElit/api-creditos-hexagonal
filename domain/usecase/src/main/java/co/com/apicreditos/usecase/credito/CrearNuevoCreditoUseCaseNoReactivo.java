package co.com.apicreditos.usecase.credito;

import co.com.apicreditos.model.credito.command.CrearNuevoCreditoCommand;
import co.com.apicreditos.model.credito.entities.Credito;
import co.com.apicreditos.model.credito.values.CreditoId;
import co.com.apicreditos.model.generic.Command;
import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;
import co.com.apicreditos.usecase.credito.gateways.CreditoRepositoryNoReactivo;
import co.com.apicreditos.usecase.generic.UseCaseForCommandNoReactivo;

import java.util.List;

public class CrearNuevoCreditoUseCaseNoReactivo implements UseCaseForCommandNoReactivo {

    private final CreditoRepositoryNoReactivo repository;

    public CrearNuevoCreditoUseCaseNoReactivo(CreditoRepositoryNoReactivo repository) {
        this.repository = repository;
    }


    @Override
    public List<DomainEvent> apply(Command command) {
        CrearNuevoCreditoCommand crearNuevoCredito = (CrearNuevoCreditoCommand) command;
        Credito credito = new Credito(
                CreditoId.of(crearNuevoCredito.getCreditoId()),
                VinculacionId.of(crearNuevoCredito.getVinculacionId()),
                crearNuevoCredito.getEstadoCredito()
        );
        credito.vincularCliente(VinculacionId.of(crearNuevoCredito.getVinculacionId()));
        credito.analizarHistorialCrediticio();
        credito.capacidadEndeudamiento();
        credito.valorPatrimonio();
        credito.consultaCentralesDeRiesgo();
        credito.calcularScore();
        return credito.getUncommittedChanges().stream().map(event -> {
            return repository.crearNuevoCreditoNoReactivo(event);
        }).toList();
    }

}
