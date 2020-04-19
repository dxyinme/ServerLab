package com.dxyinme.demo.Component;

import com.dxyinme.demo.model.Comment;
import com.dxyinme.demo.service.CommentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class insertComponent {

    @Autowired
    CommentService commentService;

    @JmsListener(destination = "commentInsert")
    public void commentInsert(String message){
        System.out.println("receive:"  +  message);
        Comment now = new Gson().fromJson(message,Comment.class);
        commentService.insert(now);
    }
}
