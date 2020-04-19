package com.dxyinme.demo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Destination;


@Configuration
public class MQConfig {

    @Bean
    public Destination commentInsert() {
        return new ActiveMQQueue("commentInsert");
    }

    @Bean
    public Destination commentInsert2() {
        return new ActiveMQQueue("commentInsert2");
    }


}