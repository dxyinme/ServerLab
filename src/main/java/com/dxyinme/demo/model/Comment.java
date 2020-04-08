package com.dxyinme.demo.model;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private String comment;

    private Integer userId;

    private Integer houseId;

    /**
     * 评论发布时间
     */
    private Date timetable;

    /**
     * 是否显示
     */
    private Boolean isshow;

    public Comment(String comment, Integer userId, Integer houseId, Boolean isshow) {
        this.comment = comment;
        this.userId = userId;
        this.houseId = houseId;
        this.isshow = isshow;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public Date getTimetable() {
        return timetable;
    }

    public void setTimetable(Date timetable) {
        this.timetable = timetable;
    }

    public Boolean getIsshow() {
        return isshow;
    }

    public void setIsshow(Boolean isshow) {
        this.isshow = isshow;
    }
}