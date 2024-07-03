package com.g5.ass_cache.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AssinaturaListener {

    private final RabbitTemplate rabbitTemplate;
    private Map<Long, Boolean> assinaturaCache = new HashMap<>();

    @Autowired
    public AssinaturaListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "#{requestQueue.name}")
    public void handleRequest(long codass) {
        Boolean isInvalid = assinaturaCache.get(codass);
        if (isInvalid != null) {
            System.out.println("Dado encontrado na cache enviado para a sistema");
            rabbitTemplate.convertAndSend(RabbitMQConfig.RESPONSE_QUEUE, isInvalid);
        }
    }

    @RabbitListener(queues = "#{updateQueue.name}")
    public void handleUpdate(Object[] assinaturaStatus) {
        Long codass = (Long) assinaturaStatus[0];
        Boolean isInvalid = (Boolean) assinaturaStatus[1];
        assinaturaCache.put(codass, isInvalid);
        System.out.println("Dado atualizado na cache");
        System.out.println("codass: " + codass + ", valor: " + assinaturaCache.get(codass));
    }

    @RabbitListener(queues = "#{deleteQueue.name}")
    public void handleDelete(Long codass) {
        System.out.println("pedido recebido");
        if (assinaturaCache.containsKey(codass)) {
            assinaturaCache.remove(codass);
            System.out.println("Dado removido da cache");
        }
    }
}