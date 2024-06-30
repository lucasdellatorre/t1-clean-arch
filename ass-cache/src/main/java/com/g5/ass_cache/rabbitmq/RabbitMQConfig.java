package com.g5.ass_cache.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String REQUEST_QUEUE = "ass-cache-request-queue";
    public static final String RESPONSE_QUEUE = "ass-cache-response-queue";
    public static final String FANOUT_EXCHANGE_NAME = "assinatura.fanout.exchange";

    @Bean
    public Queue requestQueue() {
        return new Queue(REQUEST_QUEUE, false);
    }

    @Bean
    public Queue responseQueue() {
        return new Queue(RESPONSE_QUEUE, false);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE_NAME);
    }
    
    @Bean
    public SimpleMessageConverter simpleMessageConverter() {
        SimpleMessageConverter converter = new SimpleMessageConverter();
        converter.addAllowedListPatterns("*");
        return converter;
    }


    @Bean
    public Binding bindingRequest(Queue requestQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(requestQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingResponse(Queue responseQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(responseQueue).to(fanoutExchange);
    }
}