package com.dxyinme.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com-dxyinme-demo-model-Comment")
public class Comment {
    @ApiModelProperty(value="")
    private Long commentId;

    @ApiModelProperty(value="")
    private String comment;

    @ApiModelProperty(value="")
    private Integer userId;

    @ApiModelProperty(value="")
    private String houseId;

    /**
    * 是否显示
    */
    @ApiModelProperty(value="是否显示")
    private Boolean isshow;

    /**
    * 评论时间
    */
    @ApiModelProperty(value="评论时间")
    private String timetable;

    public Comment(String comment, Integer userId, String houseId, Boolean isshow, String timetable) {
        this.comment = comment;
        this.userId = userId;
        this.houseId = houseId;
        this.isshow = isshow;
        this.timetable = timetable;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
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

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public Boolean getIsshow() {
        return isshow;
    }

    public void setIsshow(Boolean isshow) {
        this.isshow = isshow;
    }

    public String getTimetable() {
        return timetable;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }
}