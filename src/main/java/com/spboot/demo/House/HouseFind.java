package com.spboot.demo.House;

import com.spboot.demo.Const.const_oct;


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

    public HouseFind(String location1, String location2, String location3, String location4, Integer minArea, Integer maxArea, Integer minPrice, Integer maxPrice, Integer type) {
        this.autoId = 0;
        this.state = 1;
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

    public HouseFind(String data) {
        String[] params = data.split("_");
        this.autoId = 0;
        this.state = 1;
        this.type = 1;
        for(int i=0;i<params.length;i++){
        String[] opn = params[i].split("=");
        switch (opn[0]){
            case "province" : this.location1 = opn[1];break;
            case "city" : this.location2 = opn[1];break;
            case "county" : this.location3 = opn[1];break;
            case "road" : this.location4 = opn[1];break;
            case "minArea" : this.minArea = Integer.parseInt(opn[1]);break;
            case "maxArea" : this.maxArea = Integer.parseInt(opn[1]);break;
            case "minPrice" : this.minPrice = Integer.parseInt(opn[1]);break;
            case "type" : this.type = Integer.parseInt(opn[1]);break;
        }
    }

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
        if(minArea == null){
            return  - const_oct.INF;
        }
        return minArea;
    }

    public void setMinArea(Integer minArea) {
        this.minArea = minArea;
    }

    public Integer getMaxArea() {
        if(maxArea == null){
            return const_oct.INF;
        }
        return maxArea;
    }

    public void setMaxArea(Integer maxArea) {
        this.maxArea = maxArea;
    }

    public Integer getMinPrice() {
        if(minPrice == null){
            return  - const_oct.INF;
        }
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        if(maxPrice == null){
            return const_oct.INF;
        }
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


}
