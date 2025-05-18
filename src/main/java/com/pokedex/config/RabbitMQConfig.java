package com.pokedex.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "treinador.fila";
    public static final String EXCHANGE_NAME = "treinador.exchange";
    public static final String ROUTING_KEY = "treinador.chave";
}
