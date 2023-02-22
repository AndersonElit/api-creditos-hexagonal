package co.com.apicreditos.usecase.vinculacion;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.command.VincularClienteCommand;
import co.com.apicreditos.model.vinculacion.entities.Asesor;
import co.com.apicreditos.model.vinculacion.entities.Cliente;
import co.com.apicreditos.model.vinculacion.entities.Oficina;
import co.com.apicreditos.model.vinculacion.events.VinculacionCreada;
import co.com.apicreditos.model.vinculacion.values.OficinaId;
import co.com.apicreditos.model.vinculacion.values.UsuarioId;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepositoryNoReactivo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class VincularClienteUseCaseNoReactivoTest {

    @Mock
    private VinculacionRepositoryNoReactivo repository;

    private VincularClienteUseCaseNoReactivo useCase;

    @BeforeEach
    void setUp() {
        useCase = new VincularClienteUseCaseNoReactivo(repository);
    }

    @Test
    void apply() {

        String ID_VINCULACION = "id-vinculacion";
        String ID_CLIENTE = "id-cliente";
        String ID_ASESOR = "id-asesor";
        String ID_OFICINA = "id-oficina";

        VincularClienteCommand command = new VincularClienteCommand(ID_VINCULACION, new Cliente(new UsuarioId(ID_CLIENTE)),
                new Asesor(new UsuarioId(ID_ASESOR)), new Oficina(new OficinaId(ID_OFICINA)));

        VinculacionCreada event = new VinculacionCreada();
        event.setAggregateRootId(ID_VINCULACION);

        Mockito.when(repository.vincularClienteNoReactivo(ArgumentMatchers.any()))
                .thenAnswer(invocationOnMock -> {
                    return  invocationOnMock.getArgument(0);
                });

        List<DomainEvent> result = useCase.apply(command);

        Assertions.assertEquals(event.aggregateRootId(), result.get(0).aggregateRootId());

    }
}