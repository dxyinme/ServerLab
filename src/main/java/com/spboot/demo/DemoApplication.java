package com.spboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

    @RequestMapping(value="/")
    public String forIndex(){
        return "a hello spring";
    }

    public static void main(String[] args) {
        //System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","|{}");
        SpringApplication.run(DemoApplication.class, args);
    }

}
