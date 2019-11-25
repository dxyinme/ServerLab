package com.spboot.demo.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin // 允许外部访问
public class helloControl {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){

        return "hello hhhhh";

    }
}
