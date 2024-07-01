package com.g5.t1cleanarch.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ResponseListener {

    private static boolean cacheResponse;
    private static boolean responseReceived = false;

    @RabbitListener(queues = RabbitMQConfig.RESPONSE_QUEUE)
    public void handleResponse(Boolean response) {
        cacheResponse = response;
        responseReceived = true;
    }

    public static boolean isResponseReceived() {
        return responseReceived;
    }

    public static boolean getCacheResponse() {
        return cacheResponse;
    }

    public static void reset() {
        responseReceived = false;
    }
}