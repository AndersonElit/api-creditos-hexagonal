package co.com.apicreditos.usecase.vinculacion;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.command.ConsultarClienteCommand;
import co.com.apicreditos.model.vinculacion.events.ClienteConsultado;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepositoryNoReactivo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ConsultarClienteUseCaseNoReactivoTest {

    @Mock
    private VinculacionRepositoryNoReactivo repository;

    private ConsultarClienteUseCaseNoReactivo useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarClienteUseCaseNoReactivo(repository);
    }

    @Test
    void apply() {

        String VINCULACION_ID = "vinculacion_id";

        ConsultarClienteCommand command = new ConsultarClienteCommand(VINCULACION_ID);

        ClienteConsultado clienteConsultado = new ClienteConsultado();
        clienteConsultado.setAggregateRootId(VINCULACION_ID);

        Mockito.when(repository.buscarPorIdNoReactivo(VINCULACION_ID))
                .thenReturn(List.of(clienteConsultado));

        List<DomainEvent> result = useCase.apply(command);
        Assertions.assertEquals(command.getVinculacionId(), result.get(0).aggregateRootId());

    }
}