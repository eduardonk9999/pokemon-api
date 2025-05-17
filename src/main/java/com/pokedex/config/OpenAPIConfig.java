package com.pokedex.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Pokedex API")
                        .version("1.0.0")
                        .description("API de cadastro de treinadores e pokémons")
                        .contact(new Contact()
                                .name("Eduardo Silva")));
    }
}
