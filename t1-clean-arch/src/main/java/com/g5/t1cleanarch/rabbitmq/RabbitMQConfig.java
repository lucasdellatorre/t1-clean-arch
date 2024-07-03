package com.g5.t1cleanarch.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String RESPONSE_QUEUE = "assinatura.response.queue";
    public static final String UPDATE_FANOUT_EXCHANGE = "assinatura.update.fanout.exchange";
    public static final String REQUEST_FANOUT_EXCHANGE = "assinatura.request.fanout.exchange";
    public static final String RESPONSE_FANOUT_EXCHANGE = "assinatura.response.fanout.exchange";
    public static final String DELETE_FANOUT_EXCHANGE = "assinatura.delete.fanout.exchange";

    @Bean
    public FanoutExchange requestFanoutExchange() {
        return new FanoutExchange(REQUEST_FANOUT_EXCHANGE);
    }

    @Bean
    public FanoutExchange responseFanoutExchange() {
        return new FanoutExchange(RESPONSE_FANOUT_EXCHANGE);
    }

    @Bean
    public FanoutExchange updateFanoutExchange() {
        return new FanoutExchange(UPDATE_FANOUT_EXCHANGE);
    }

    @Bean
    public FanoutExchange deleteFanoutExchange() {
        return new FanoutExchange(DELETE_FANOUT_EXCHANGE);
    }

    @Bean
    public Queue responseQueue() {
        return new Queue(RESPONSE_QUEUE);
    }

    @Bean
    public Binding bindingResponse(Queue responseQueue, FanoutExchange responseFanoutExchange) {
        return BindingBuilder.bind(responseQueue).to(responseFanoutExchange);
    }
}