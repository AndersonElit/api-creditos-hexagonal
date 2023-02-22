package co.com.apicreditos.usecase.credito;

import co.com.apicreditos.model.credito.command.ConsultarCreditoCommand;
import co.com.apicreditos.model.credito.entities.Credito;
import co.com.apicreditos.model.credito.values.CreditoId;
import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.usecase.credito.gateways.CreditoRepositoryNoReactivo;
import co.com.apicreditos.usecase.generic.UseCaseForCommandNoReactivo;

import java.util.List;

public class ConsultarCreditoUseCaseNoReactivo implements UseCaseForCommandNoReactivo<ConsultarCreditoCommand> {

    private final CreditoRepositoryNoReactivo repository;

    public ConsultarCreditoUseCaseNoReactivo(CreditoRepositoryNoReactivo repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(ConsultarCreditoCommand command) {

        List<DomainEvent> events = repository.buscarPorIdNoReactivo(command.getCreditoId());
        Credito credito = Credito.from(CreditoId.of(command.getCreditoId()), events);
        credito.consultarCredito();
        return credito.getUncommittedChanges();

    }

}
