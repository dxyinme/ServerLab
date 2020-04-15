package com.dxyinme.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin // 允许外部访问
public class CommentController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping(value = "comment/test")
    public String test(){
        stringRedisTemplate.opsForValue().set("oo", "我");
        String name = stringRedisTemplate.opsForValue().get("oo");
        return name;
    }
}
