package com.spboot.demo.model;

import java.util.Date;

/**
    * 订单table
    */
public class Order {
    /**
    * 订单id
    */
    private String orderId;

    /**
    * 买家id
    */
    private Integer userId;

    /**
    * 房子id
    */
    private Integer houseId;

    /**
    * 订单发起时间
    */
    private Date orderTime;

    /**
    * 订单状态
    */
    private String status;

    public Order(String orderId, Integer userId, Integer houseId, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.houseId = houseId;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}