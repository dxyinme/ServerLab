package com.dxyinme.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.dxyinme.demo.mapper.SubscribeMapper;
import java.util.List;
import com.dxyinme.demo.model.Subscribe;
import com.dxyinme.demo.model.SubscribeExample;
import com.dxyinme.demo.service.SubscribeService;
@Service
public class SubscribeServiceImpl implements SubscribeService{

    @Resource
    private SubscribeMapper subscribeMapper;

    @Override
    public long countByExample(SubscribeExample example) {
        return subscribeMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SubscribeExample example) {
        return subscribeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String subscribeId) {
        return subscribeMapper.deleteByPrimaryKey(subscribeId);
    }

    @Override
    public int insert(Subscribe record) {
        return subscribeMapper.insert(record);
    }

    @Override
    public int insertSelective(Subscribe record) {
        return subscribeMapper.insertSelective(record);
    }

    @Override
    public List<Subscribe> selectByExample(SubscribeExample example) {
        return subscribeMapper.selectByExample(example);
    }

    @Override
    public Subscribe selectByPrimaryKey(String subscribeId) {
        return subscribeMapper.selectByPrimaryKey(subscribeId);
    }

    @Override
    public int updateByExampleSelective(Subscribe record,SubscribeExample example) {
        return subscribeMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Subscribe record,SubscribeExample example) {
        return subscribeMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Subscribe record) {
        return subscribeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Subscribe record) {
        return subscribeMapper.updateByPrimaryKey(record);
    }

}
