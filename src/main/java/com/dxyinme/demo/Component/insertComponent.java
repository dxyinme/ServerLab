package com.dxyinme.demo.Component;

import com.dxyinme.demo.model.Comment;
import com.dxyinme.demo.model.Subscribe;
import com.dxyinme.demo.service.CommentService;
import com.dxyinme.demo.service.SubscribeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class insertComponent {

    @Autowired
    CommentService commentService;

    @Autowired
    SubscribeService subscribeService;

    @JmsListener(destination = "commentInsert")
    public void commentInsert(String message){
        System.out.println("insertComponent.commentInsert:" + message);
        Comment now = new Gson().fromJson(message,Comment.class);
        commentService.insert(now);
    }

    @JmsListener(destination = "subscribeInsert")
    public void subscribeInsert(String message){
        System.out.println("insertComponent.subscribeInsert:" + message);
        subscribeService.insert(new Gson().fromJson(message, Subscribe.class));
    }

}
