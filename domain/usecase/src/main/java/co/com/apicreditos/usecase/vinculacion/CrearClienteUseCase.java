package co.com.apicreditos.usecase.vinculacion;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.command.CrearClienteCommand;
import co.com.apicreditos.model.vinculacion.entities.Vinculacion;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;
import co.com.apicreditos.usecase.generic.UseCaseForCommandNoReactivo;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepositoryNoReactivo;

import java.util.List;

public class CrearClienteUseCase implements UseCaseForCommandNoReactivo<CrearClienteCommand> {

    private VinculacionRepositoryNoReactivo repository;

    public CrearClienteUseCase(VinculacionRepositoryNoReactivo repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(CrearClienteCommand command) {
        List<DomainEvent> events = repository.buscarPorIdNoReactivo(command.getVinculacionId());
        Vinculacion vinculacion = Vinculacion.from(VinculacionId.of(command.getVinculacionId()), events);
        vinculacion.crearCliente(command.getCliente());
        return vinculacion.getUncommittedChanges().stream().map(event -> {
            return repository.vincularClienteNoReactivo(event);
        }).toList();
    }
}
