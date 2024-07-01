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
    private Map<Integer, Boolean> assinaturaCache = new HashMap<>();

    @Autowired
    public AssinaturaListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = RabbitMQConfig.REQUEST_QUEUE)
    public void handleRequest(Integer codass) {
        Boolean isInvalid = assinaturaCache.get(codass);
        if (isInvalid != null) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.RESPONSE_QUEUE, isInvalid);
        }
    }

    @RabbitListener(queues = RabbitMQConfig.UPDATE_QUEUE)
    public void handleUpdate(Object[] assinaturaStatus) {
        Integer codass = (Integer) assinaturaStatus[0];
        Boolean isInvalid = (Boolean) assinaturaStatus[1];
        assinaturaCache.put(codass, isInvalid);
    }

    @RabbitListener(queues = RabbitMQConfig.DELETE_QUEUE)
    public void handleDelete(Integer codass) {
        assinaturaCache.remove(codass);
    }
}