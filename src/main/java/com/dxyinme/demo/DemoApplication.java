package com.dxyinme.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJms
public class DemoApplication {


    public static void main(String[] args) {
        //System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","|{}");
        SpringApplication.run(DemoApplication.class, args);
    }

}
