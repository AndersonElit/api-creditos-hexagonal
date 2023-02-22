package co.com.apicreditos.usecase.generic;

import co.com.apicreditos.model.generic.Command;
import co.com.apicreditos.model.generic.DomainEvent;

import java.util.List;

public interface UseCaseForCommandNoReactivo<R extends Command> {
    List<DomainEvent> apply(R command);
}
