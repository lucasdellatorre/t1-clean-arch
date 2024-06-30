package com.g5.t1cleanarch.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String REQUEST_QUEUE = "assinatura.request.queue";
    public static final String UPDATE_QUEUE = "assinatura.update.queue";
    public static final String FANOUT_EXCHANGE = "assinatura.fanout.exchange";

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Queue requestQueue() {
        return new Queue(REQUEST_QUEUE);
    }

    @Bean
    public Queue updateQueue() {
        return new Queue(UPDATE_QUEUE);
    }

    @Bean
    public Binding bindingRequest(Queue requestQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(requestQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingUpdate(Queue updateQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(updateQueue).to(fanoutExchange);
    }
}