package com.spboot.demo.House;


import java.util.List;

public class House{
    private Integer autoId;
    private Integer state;
    private String location;
    private Integer area;
    private Integer price;
    private Integer type;
    private Integer floor;
    private Integer buildTime;
    private Integer timeLimit;
    private Integer userId;
    private String img;
    private List<Integer> commentsId;

    /*
    autoId: id of house in mysql. not expose to client.
    state: state of house : 0 means sold or deleted ,1 means not……
     */

    public House() {
    }

    public House(Integer autoId, Integer state, String location, Integer area, Integer price, Integer type, Integer floor, Integer buildTime, Integer timeLimit, Integer userId) {
        this.autoId = autoId;
        this.state = state;
        this.location = location;
        this.area = area;
        this.price = price;
        this.type = type;
        this.floor = floor;
        this.buildTime = buildTime;
        this.timeLimit = timeLimit;
        this.userId = userId;
        this.img =  "/image/"+ autoId + ".jpg";
    }

    public House(Integer autoId, Integer state, String location, Integer area, Integer price, Integer type, Integer floor, Integer buildTime, Integer timeLimit, Integer userId, List<Integer> commentsId) {
        this.autoId = autoId;
        this.state = state;
        this.location = location;
        this.area = area;
        this.price = price;
        this.type = type;
        this.floor = floor;
        this.buildTime = buildTime;
        this.timeLimit = timeLimit;
        this.userId = userId;
        this.commentsId = commentsId;
        this.img =  "/image/"+ autoId + ".jpg";
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Integer buildTime) {
        this.buildTime = buildTime;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(List<Integer> commentsId) {
        this.commentsId = commentsId;
    }

    public String getImg(){
        return this.img;
    }

    @Override
    public String toString() {
        return "House{" +
                "autoId=" + autoId +
                ", state=" + state +
                ", location='" + location + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", type=" + type +
                ", floor=" + floor +
                ", buildTime=" + buildTime +
                ", timeLimit=" + timeLimit +
                ", userId=" + userId +
                ", commentsId=" + commentsId +
                '}';
    }
}
