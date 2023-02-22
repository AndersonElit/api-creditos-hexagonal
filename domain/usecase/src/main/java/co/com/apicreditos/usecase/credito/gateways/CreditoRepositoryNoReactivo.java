package co.com.apicreditos.usecase.credito.gateways;

import co.com.apicreditos.model.generic.DomainEvent;

import java.util.List;

public interface CreditoRepositoryNoReactivo {
    DomainEvent crearNuevoCreditoNoReactivo(DomainEvent event);
    List<DomainEvent> buscarPorIdNoReactivo(String agregateRootId);
}
