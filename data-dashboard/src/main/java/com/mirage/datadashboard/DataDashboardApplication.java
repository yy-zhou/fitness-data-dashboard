package com.mirage.datadashboard;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Main application for data dashboard.
 */
@SpringBootApplication
@EnableRabbit
@EnableDiscoveryClient
public class DataDashboardApplication {

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
                .with(Constants.ROUTING_KEY_REALTIME).noargs();
    }

    public static void main(String[] args) {
        SpringApplication.run(DataDashboardApplication.class, args);
    }
}
