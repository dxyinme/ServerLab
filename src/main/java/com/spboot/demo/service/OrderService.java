package com.spboot.demo.service;

import java.util.List;
import com.spboot.demo.model.OrderExample;
import com.spboot.demo.model.Order;
public interface OrderService{


    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(Order record,OrderExample example);

    int updateByExample(Order record,OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

}
