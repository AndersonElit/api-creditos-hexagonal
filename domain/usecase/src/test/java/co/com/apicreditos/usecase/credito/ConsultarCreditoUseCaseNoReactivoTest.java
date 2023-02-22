package co.com.apicreditos.usecase.credito;

import co.com.apicreditos.model.credito.command.ConsultarCreditoCommand;
import co.com.apicreditos.model.credito.events.CreditoConsultado;
import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.usecase.credito.gateways.CreditoRepositoryNoReactivo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ConsultarCreditoUseCaseNoReactivoTest {

    @Mock
    private CreditoRepositoryNoReactivo repository;

    private ConsultarCreditoUseCaseNoReactivo useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarCreditoUseCaseNoReactivo(repository);
    }

    @Test
    void apply() {

        String CREDITO_ID = "credito_id";

        ConsultarCreditoCommand command = new ConsultarCreditoCommand(CREDITO_ID);
        CreditoConsultado creditoConsultado = new CreditoConsultado();
        creditoConsultado.setAggregateRootId(CREDITO_ID);

        Mockito.when(repository.buscarPorIdNoReactivo(CREDITO_ID))
                .thenReturn(List.of(creditoConsultado));

        List<DomainEvent> result = useCase.apply(command);

        Assertions.assertEquals(command.getCreditoId(), result.get(0).aggregateRootId());

    }
}