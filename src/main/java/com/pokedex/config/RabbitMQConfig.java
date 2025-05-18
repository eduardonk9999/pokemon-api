package com.pokedex.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;


@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "treinador.fila";
    public static final String EXCHANGE_NAME = "treinador.exchange";
    public static final String ROUTING_KEY = "treinador.chave";

    @Bean
    public Queue fila() {
        return new Queue(QUEUE_NAME, true);
    }
}
