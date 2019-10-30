package com.spboot.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloControl {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){

        return "hello hhhhh";

    }
}
