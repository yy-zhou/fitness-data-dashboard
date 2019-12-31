package com.mirage.dataconsumer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Main application for data consumer.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
public class DataConsumerApplication {
    @Bean
    public Exchange fitnessDataExchange() {
        return new TopicExchange(Constants.EXCHANGE_NAME);
    }

    @Bean
    public Queue queue() {
        return new Queue(Constants.QUEUE_NAME);
    }

    @Bean
    public Binding binding(Queue q, Exchange dataExchange) {
        return BindingBuilder
                .bind(q)
                .to(dataExchange)
                .with(Constants.ROUTING_KEY_HISTORY).noargs();
    }

    public static void main(String[] args) {
        SpringApplication.run(DataConsumerApplication.class, args);
    }
}
