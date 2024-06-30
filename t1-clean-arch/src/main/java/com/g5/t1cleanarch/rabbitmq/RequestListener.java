package com.g5.t1cleanarch.rabbitmq;

import com.g5.t1cleanarch.aplicacao.casosDeUso.AssinaturaInvalidaUC;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestListener {

    private final AssinaturaInvalidaUC assinaturaInvalidaUC;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RequestListener(AssinaturaInvalidaUC assinaturaInvalidaUC, RabbitTemplate rabbitTemplate) {
        this.assinaturaInvalidaUC = assinaturaInvalidaUC;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = RabbitMQConfig.REQUEST_QUEUE)
    public void handleRequest(Integer assinaturaId) {
        boolean isInvalid = assinaturaInvalidaUC.run(assinaturaId);
        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE, "", isInvalid);
    }
}