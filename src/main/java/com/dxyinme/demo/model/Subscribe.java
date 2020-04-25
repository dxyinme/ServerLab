package com.dxyinme.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
    * 存储关注关系的表
    */
@ApiModel(value="com-dxyinme-demo-model-Subscribe")
public class Subscribe {
    /**
    * id
    */
    @ApiModelProperty(value="id")
    private String subscribeId;

    /**
    * user_id
    */
    @ApiModelProperty(value="user_id")
    private Integer userId;

    /**
    * house_id
    */
    @ApiModelProperty(value="house_id")
    private String houseId;

    /**
    * 关注时间
    */
    @ApiModelProperty(value="关注时间")
    private String timetable;

    public Subscribe(Integer userId, String houseId, String timetable) {
        this.userId = userId;
        this.houseId = houseId;
        this.timetable = timetable;
        this.subscribeId = "sid_"+userId+"_"+houseId;
    }

    public String getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(String subscribeId) {
        this.subscribeId = subscribeId;
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

    public String getTimetable() {
        return timetable;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }
}