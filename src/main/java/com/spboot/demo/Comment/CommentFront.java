package com.spboot.demo.Comment;

public class CommentFront extends CommentImpl{
    public String userName;

    public CommentFront(String comment, Integer user, Integer house , String username) {
        super(comment, user, house);
        userName = username;
    }

    public CommentFront(CommentImpl o , String username){
        super(o.getComm() , o.getUserId(),o.getHouseId());
        userName = username;
    }
}
