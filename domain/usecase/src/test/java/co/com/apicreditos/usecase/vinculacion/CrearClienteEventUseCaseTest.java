package co.com.apicreditos.usecase.vinculacion;

import co.com.apicreditos.model.credito.enums.EstadoCredito;
import co.com.apicreditos.model.credito.events.ClienteVinculado;
import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.entities.Cliente;
import co.com.apicreditos.model.vinculacion.values.UsuarioId;
import co.com.apicreditos.model.vinculacion.values.VinculacionId;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class CrearClienteEventUseCaseTest {

    @Mock
    private VinculacionRepository repository;

    private CrearClienteEventUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CrearClienteEventUseCase(repository);
    }

    @Test
    void apply() {

        String ID_AGREGADO = "id-agregado";
        String ID_VINCULACION = "id-vinculacion";
        String ID_CLIENTE = "id-cliente";
        Cliente cliente = new Cliente(UsuarioId.of(ID_CLIENTE));

        ClienteVinculado event = new ClienteVinculado(VinculacionId.of(ID_VINCULACION), EstadoCredito.INICIO, cliente);

        event.setAggregateRootId(ID_AGREGADO);

        Mockito.when(repository.saveEvent(ArgumentMatchers.any()))
                .thenAnswer(invocationOnMock -> Mono.just(invocationOnMock.getArgument(0)));

        Flux<DomainEvent> result = useCase.apply(Mono.just(event));

        StepVerifier.create(result)
                .expectNextCount(2)
                .verifyComplete();

    }
}