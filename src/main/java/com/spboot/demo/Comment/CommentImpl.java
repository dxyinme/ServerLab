package com.spboot.demo.Comment;

public class CommentImpl implements Comment{
    private String comm ;
    private Integer userId ;
    private Integer houseId;
    public CommentImpl(String comment , Integer user , Integer house){
        this.comm = comment;
        this.userId = user;
        this.houseId = house;
    }

    @Override
    public int hashCode(){
        return comm.hashCode();
    }

    @Override
    public String getComm() {
        return comm;
    }
}
