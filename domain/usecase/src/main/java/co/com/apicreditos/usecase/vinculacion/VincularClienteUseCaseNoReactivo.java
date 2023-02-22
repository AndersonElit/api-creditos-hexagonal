package co.com.apicreditos.usecase.vinculacion;

import co.com.apicreditos.model.generic.Command;
import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.command.VincularClienteCommand;
import co.com.apicreditos.model.vinculacion.entities.Vinculacion;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;
import co.com.apicreditos.usecase.generic.UseCaseForCommandNoReactivo;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepositoryNoReactivo;

import java.util.List;

public class VincularClienteUseCaseNoReactivo implements UseCaseForCommandNoReactivo {

    private VinculacionRepositoryNoReactivo repository;

    public VincularClienteUseCaseNoReactivo(VinculacionRepositoryNoReactivo repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(Command command) {
        VincularClienteCommand vincularCliente = (VincularClienteCommand) command;
        Vinculacion vinculacion = new Vinculacion(
                VinculacionId.of(vincularCliente.getVinculacionId())
        );
        vinculacion.crearCliente(vincularCliente.getCliente());
        vinculacion.asignarAsesor(vincularCliente.getAsesor());
        vinculacion.asignarOficina(vincularCliente.getOficina());
        return vinculacion.getUncommittedChanges().stream().map(event -> {
            return repository.vincularClienteNoReactivo(event);
        }).toList();
    }

}
