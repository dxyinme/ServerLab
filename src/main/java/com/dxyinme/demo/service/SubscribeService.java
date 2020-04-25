package com.dxyinme.demo.service;

import java.util.List;
import com.dxyinme.demo.model.Subscribe;
import com.dxyinme.demo.model.SubscribeExample;
public interface SubscribeService{


    long countByExample(SubscribeExample example);

    int deleteByExample(SubscribeExample example);

    int deleteByPrimaryKey(String subscribeId);

    int insert(Subscribe record);

    int insertSelective(Subscribe record);

    List<Subscribe> selectByExample(SubscribeExample example);

    Subscribe selectByPrimaryKey(String subscribeId);

    int updateByExampleSelective(Subscribe record,SubscribeExample example);

    int updateByExample(Subscribe record,SubscribeExample example);

    int updateByPrimaryKeySelective(Subscribe record);

    int updateByPrimaryKey(Subscribe record);

}
