package co.com.apicreditos.usecase.vinculacion;

import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.model.vinculacion.command.ConsultarClienteCommand;
import co.com.apicreditos.model.vinculacion.events.ClienteConsultado;
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
class ConsultarClienteUseCaseTest {

    @Mock
    private VinculacionRepository repository;

    private ConsultarClienteUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarClienteUseCase(repository);
    }

    @Test
    void apply() {

        String VINCULACION_ID = "vinculacion_id";
        ConsultarClienteCommand command = new ConsultarClienteCommand(VINCULACION_ID);
        ClienteConsultado clienteConsultado = new ClienteConsultado();
        clienteConsultado.setAggregateRootId(VINCULACION_ID);

        Mockito.when(repository.findById(VINCULACION_ID))
                .thenReturn(Flux.just(clienteConsultado));

        Mockito.when(repository.saveEvent(ArgumentMatchers.any()))
                .thenAnswer(invocationOnMock -> Mono.just(invocationOnMock.getArgument(0)));

        Flux<DomainEvent> flux = useCase.apply(Mono.just(command));

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

    }
}