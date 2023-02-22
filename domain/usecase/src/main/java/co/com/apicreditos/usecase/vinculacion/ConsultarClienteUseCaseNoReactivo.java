package co.com.apicreditos.usecase.vinculacion;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.command.ConsultarClienteCommand;
import co.com.apicreditos.model.vinculacion.entities.Vinculacion;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;
import co.com.apicreditos.usecase.generic.UseCaseForCommandNoReactivo;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepositoryNoReactivo;

import java.util.List;

public class ConsultarClienteUseCaseNoReactivo implements UseCaseForCommandNoReactivo<ConsultarClienteCommand> {

    private VinculacionRepositoryNoReactivo repository;

    public ConsultarClienteUseCaseNoReactivo(VinculacionRepositoryNoReactivo repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(ConsultarClienteCommand command) {
        List<DomainEvent> events = repository.buscarPorIdNoReactivo(command.getVinculacionId());
        Vinculacion vinculacion = Vinculacion.from(VinculacionId.of(command.getVinculacionId()), events);
        vinculacion.consultarCliente();
        return vinculacion.getUncommittedChanges();
    }

}
