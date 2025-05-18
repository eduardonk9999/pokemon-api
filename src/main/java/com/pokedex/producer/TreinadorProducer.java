package com.pokedex.producer;

import com.pokedex.config.RabbitMQConfig;
import com.pokedex.dto.TreinadorResponseDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class TreinadorProducer {
    private final RabbitTemplate rabbitTemplate;

    public TreinadorProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensagem(TreinadorResponseDTO dto) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME);
    }
}
