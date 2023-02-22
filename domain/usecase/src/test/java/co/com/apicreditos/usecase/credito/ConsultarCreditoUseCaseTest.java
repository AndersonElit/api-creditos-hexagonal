package co.com.apicreditos.usecase.credito;

import co.com.apicreditos.model.credito.command.ConsultarCreditoCommand;
import co.com.apicreditos.model.credito.events.CreditoConsultado;
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
class ConsultarCreditoUseCaseTest {

    @Mock
    private CreditoRepository repository;

    private ConsultarCreditoUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarCreditoUseCase(repository);
    }

    @Test
    void apply() {

        String CREDITO_ID = "credito_id";
        ConsultarCreditoCommand command = new ConsultarCreditoCommand(CREDITO_ID);
        CreditoConsultado creditoConsultado = new CreditoConsultado();
        creditoConsultado.setAggregateRootId(CREDITO_ID);

        Mockito.when(repository.findById(CREDITO_ID))
                .thenReturn(Flux.just(creditoConsultado));

        Mockito.when(repository.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenAnswer(invocationOnMock -> Mono.just(invocationOnMock.getArgument(0)));

        Flux<DomainEvent> flux = useCase.apply(Mono.just(command));

        StepVerifier.create(flux)
                .expectNextCount(1)
                .verifyComplete();

    }
}