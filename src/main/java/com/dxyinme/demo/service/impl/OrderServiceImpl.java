package com.dxyinme.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.dxyinme.demo.model.OrderExample;
import com.dxyinme.demo.mapper.OrderMapper;
import com.dxyinme.demo.model.Order;
import com.dxyinme.demo.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{

    @Resource
    private OrderMapper orderMapper;

    @Override
    public long countByExample(OrderExample example) {
        return orderMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderExample example) {
        return orderMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public List<Order> selectByExample(OrderExample example) {
        return orderMapper.selectByExample(example);
    }

    @Override
    public Order selectByPrimaryKey(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByExampleSelective(Order record,OrderExample example) {
        return orderMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Order record,OrderExample example) {
        return orderMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

}
