package co.com.apicreditos.config;

import co.com.apicreditos.serializer.JSONMapper;
import co.com.apicreditos.serializer.JSONMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericConfig {
    @Bean
    public JSONMapper jsonMapper(){
        return new JSONMapperImpl();
    }
}
