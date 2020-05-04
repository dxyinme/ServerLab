package com.dxyinme.demo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.security.krb5.internal.crypto.Des;

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

    @Bean
    public Destination subscribeInsert(){ return new ActiveMQQueue("subscribeInsert");}

    @Bean
    public Destination subscribeDelete(){ return new ActiveMQQueue("subscribeDelete");}

    @Bean
    public Destination houseInsert() { return new ActiveMQQueue("houseInsert");}

    @Bean
    public Destination houseInsert2() { return new ActiveMQQueue("houseInsert2");}

}