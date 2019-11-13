package com.spboot.demo.House;

public class HouseFind {
    private Integer autoId;
    private Integer state;
    private String location1;
    private String location2;
    private String location3;
    private String location4;
    private Integer minArea;
    private Integer maxArea;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer type;

    public HouseFind(Integer autoId, Integer state, String location1, String location2, String location3, String location4, Integer minArea, Integer maxArea, Integer minPrice, Integer maxPrice, Integer type) {
        this.autoId = autoId;
        this.state = state;
        this.location1 = location1;
        this.location2 = location2;
        this.location3 = location3;
        this.location4 = location4;
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.type = type;
    }

    public Integer getAutoId() {
        return autoId;
    }

    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getLocation1() {
        return location1;
    }

    public void setLocation1(String location1) {
        this.location1 = location1;
    }

    public String getLocation2() {
        return location2;
    }

    public void setLocation2(String location2) {
        this.location2 = location2;
    }

    public String getLocation3() {
        return location3;
    }

    public void setLocation3(String location3) {
        this.location3 = location3;
    }

    public String getLocation4() {
        return location4;
    }

    public void setLocation4(String location4) {
        this.location4 = location4;
    }

    public Integer getMinArea() {
        return minArea;
    }

    public void setMinArea(Integer minArea) {
        this.minArea = minArea;
    }

    public Integer getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(Integer maxArea) {
        this.maxArea = maxArea;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public HouseFind(){};

}
