package com.dxyinme.demo.Component;


import com.dxyinme.demo.model.Subscribe;
import com.dxyinme.demo.model.SubscribeExample;
import com.dxyinme.demo.service.SubscribeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class deleteComponent {
    @Autowired
    SubscribeService subscribeService;

    @JmsListener(destination = "subscribeDelete")
    public void subscribeDelete(String message){
        System.out.println("deleteComponent.subscribeDelete:"+message);
        Subscribe subscribe = new Gson().fromJson(message,Subscribe.class);
        SubscribeExample subscribeExp = new SubscribeExample();
        subscribeExp.or().andHouseIdEqualTo(subscribe.getHouseId())
                    .andUserIdEqualTo(subscribe.getUserId());
    }
}
