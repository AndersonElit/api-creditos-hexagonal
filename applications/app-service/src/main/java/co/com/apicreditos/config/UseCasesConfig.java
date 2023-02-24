package co.com.apicreditos.config;

import co.com.apicreditos.usecase.credito.ConsultarCreditoUseCase;
import co.com.apicreditos.usecase.credito.ConsultarCreditoUseCaseNoReactivo;
import co.com.apicreditos.usecase.credito.CrearNuevoCreditoUseCase;
import co.com.apicreditos.usecase.credito.CrearNuevoCreditoUseCaseNoReactivo;
import co.com.apicreditos.usecase.credito.gateways.CreditoRepository;
import co.com.apicreditos.usecase.credito.gateways.CreditoRepositoryNoReactivo;
import co.com.apicreditos.usecase.vinculacion.*;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepository;
import co.com.apicreditos.usecase.vinculacion.gateways.VinculacionRepositoryNoReactivo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/*@ComponentScan(basePackages = "co.com.apicreditos.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)*/
public class UseCasesConfig {

        @Bean
        public ConsultarCreditoUseCase consultarCreditoUseCase(CreditoRepository repository) {
                return new ConsultarCreditoUseCase(repository);
        }

        @Bean
        public ConsultarCreditoUseCaseNoReactivo consultarCreditoUseCaseNoReactivo(CreditoRepositoryNoReactivo repository) {
                return new ConsultarCreditoUseCaseNoReactivo(repository);
        }

        @Bean
        public CrearNuevoCreditoUseCase crearNuevoCreditoUseCase(CreditoRepository repository) {
                return new CrearNuevoCreditoUseCase(repository);
        }

        @Bean
        public CrearNuevoCreditoUseCaseNoReactivo crearNuevoCreditoUseCaseNoReactivo(CreditoRepositoryNoReactivo repository) {
                return new CrearNuevoCreditoUseCaseNoReactivo(repository);
        }

        @Bean
        public ConsultarClienteUseCase consultarClienteUseCase(VinculacionRepository repository) {
                return new ConsultarClienteUseCase(repository);
        }

        @Bean
        public ConsultarClienteUseCaseNoReactivo consultarClienteUseCaseNoReactivo(VinculacionRepositoryNoReactivo repository) {
                return new ConsultarClienteUseCaseNoReactivo(repository);
        }

        @Bean
        public CrearClienteEventUseCase crearClienteEventUseCase(VinculacionRepository repository) {
                return new CrearClienteEventUseCase(repository);
        }

        @Bean
        public CrearClienteUseCase crearClienteUseCase(VinculacionRepositoryNoReactivo repository) {
                return new CrearClienteUseCase(repository);
        }

        @Bean
        public VincularClienteUseCase vincularClienteUseCase(VinculacionRepository repository) {
                return new VincularClienteUseCase(repository);
        }

        @Bean
        public VincularClienteUseCaseNoReactivo vincularClienteUseCaseNoReactivo(VinculacionRepositoryNoReactivo repository) {
                return new VincularClienteUseCaseNoReactivo(repository);
        }

}
