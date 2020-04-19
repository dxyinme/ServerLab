package com.dxyinme.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
    * 订单table
    */
@ApiModel(value="com-dxyinme-demo-model-Order")
public class Order {
    /**
    * 订单id
    */
    @ApiModelProperty(value="订单id")
    private String orderId;

    /**
    * 买家id
    */
    @ApiModelProperty(value="买家id")
    private Integer userId;

    /**
    * 房子id
    */
    @ApiModelProperty(value="房子id")
    private String houseId;

    /**
    * 订单发起时间
    */
    @ApiModelProperty(value="订单发起时间")
    private Date orderTime;

    /**
    * 订单状态
    */
    @ApiModelProperty(value="订单状态")
    private String status;

    public Order(String orderId, Integer userId, String houseId, Date orderTime, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.houseId = houseId;
        this.orderTime = orderTime;
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

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
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