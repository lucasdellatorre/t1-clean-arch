package com.g5.ass_cache.service;

import com.g5.ass_cache.rabbitmq.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AssCacheService {
    private final Map<Integer, Boolean> cache = new HashMap<>();
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public AssCacheService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = RabbitMQConfig.RESPONSE_QUEUE)
    public void handleAssinaturaUpdate(Boolean isInvalid) {
        // Atualiza o cache com base na mensagem recebida
        // Por exemplo:
        // cache.put(assinaturaId, isInvalid);
    }

    public boolean checkAssinatura(int assinaturaId) {
        if (cache.containsKey(assinaturaId)) {
            return cache.get(assinaturaId);
        } else {
            boolean response = (Boolean) rabbitTemplate.convertSendAndReceive(RabbitMQConfig.REQUEST_QUEUE, assinaturaId);
            cache.put(assinaturaId, response);
            return response;
        }
    }

    public void updateAssinatura(int assinaturaId) {
        // Ao pagar uma assinatura, por exemplo, remove a entrada do cache
        cache.remove(assinaturaId);
    }
}