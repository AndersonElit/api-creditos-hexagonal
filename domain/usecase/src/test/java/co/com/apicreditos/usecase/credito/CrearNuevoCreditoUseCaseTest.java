package co.com.apicreditos.usecase.credito;

import co.com.apicreditos.model.credito.command.CrearNuevoCreditoCommand;
import co.com.apicreditos.model.credito.enums.EstadoCredito;
import co.com.apicreditos.model.credito.events.CreditoCreado;
import co.com.apicreditos.model.credito.values.InformacionCreditoAprobado;
import co.com.apicreditos.model.generic.DomainEvent;
import co.com.apicreditos.usecase.credito.gateways.CreditoRepository;
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
class CrearNuevoCreditoUseCaseTest {

    @Mock
    private CreditoRepository repository;

    private CrearNuevoCreditoUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CrearNuevoCreditoUseCase(repository);
    }

    @Test
    void apply() {
        String ID_CREDITO = "id-credito";
        String ID_VINCULACION = "id-vinculacion";

        CrearNuevoCreditoCommand command = new CrearNuevoCreditoCommand(ID_CREDITO, ID_VINCULACION, new InformacionCreditoAprobado(),
                EstadoCredito.INICIO);

        CreditoCreado event = new CreditoCreado();
        event.setAggregateRootId(ID_CREDITO);

        Mockito.when(repository.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenAnswer(invocationOnMock -> Mono.just(invocationOnMock.getArgument(0)));

        Flux<DomainEvent> flux = useCase.apply(Mono.just(command));

        StepVerifier.create(flux)
                .expectNextCount(8)
                .verifyComplete();

    }
}