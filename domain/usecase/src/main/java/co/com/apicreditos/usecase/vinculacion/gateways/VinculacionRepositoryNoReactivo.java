package co.com.apicreditos.usecase.vinculacion.gateways;

import co.com.apicreditos.model.generic.DomainEvent;

import java.util.List;

public interface VinculacionRepositoryNoReactivo {
    DomainEvent vincularClienteNoReactivo(DomainEvent event);
    List<DomainEvent> buscarPorIdNoReactivo(String agregateRootId);
}
