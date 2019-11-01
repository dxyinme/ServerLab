package com.spboot.demo.Comment;

import java.util.List;

public interface OperatorComment {

    /**
     * add a comment about house 'houseId' , commit by user 'userId'.
     * @param Comment context
     * @param userId the id of user
     * @param houseId the id of house
     * @return 1 for success add , 0 for could not apply.
     */
    public int addComment(String Comment , Integer userId , Integer houseId);

    /**
     * return a list of all the comments of house 'houseId'
     * @param houseId the id of house
     * @return List<String> for all the comments , not a null.
     */
    public List<String> askAllComment(Integer houseId);
}
