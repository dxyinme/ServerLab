package com.dxyinme.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com-dxyinme-demo-model-HouseTable")
public class HouseTable {
    /**
     * houseid
     */
    @ApiModelProperty(value = "houseid")
    private String houseId;

    @ApiModelProperty(value = "")
    private String houseLocation;

    @ApiModelProperty(value = "")
    private Integer houseArea;

    @ApiModelProperty(value = "")
    private Integer housePrice;

    @ApiModelProperty(value = "")
    private Integer houseFloor;

    @ApiModelProperty(value = "")
    private String buildTime;

    @ApiModelProperty(value = "")
    private Integer timeLimit;

    @ApiModelProperty(value = "")
    private Integer houseState;

    @ApiModelProperty(value = "")
    private Integer houseType;

    /**
     * 拥有者的用户id
     */
    @ApiModelProperty(value = "拥有者的用户id")
    private Integer ownerid;

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getHouseLocation() {
        return houseLocation;
    }

    public void setHouseLocation(String houseLocation) {
        this.houseLocation = houseLocation;
    }

    public Integer getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(Integer houseArea) {
        this.houseArea = houseArea;
    }

    public Integer getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(Integer housePrice) {
        this.housePrice = housePrice;
    }

    public Integer getHouseFloor() {
        return houseFloor;
    }

    public void setHouseFloor(Integer houseFloor) {
        this.houseFloor = houseFloor;
    }

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getHouseState() {
        return houseState;
    }

    public void setHouseState(Integer houseState) {
        this.houseState = houseState;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public Integer getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }
}