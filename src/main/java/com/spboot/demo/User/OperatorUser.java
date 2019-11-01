package com.spboot.demo.User;

import java.sql.SQLException;

public interface OperatorUser {
    /**
     *  登录方法
     *  - 暂时还没用到....
     *
     * @param Name the name of user who want to Log in.
     * @return true for success Logged in.
     */
    public boolean Login(String Name) throws SQLException;


    /**
     *
     * @param Name the name of user who want to sign up.
     * @return true for success Signed Up.
     */
    public boolean SignUp(String Name);

    /**
     * a method to get a User Object whose name is Name.
     * @param Name get the User's information whose name is Name.
     * @return a User Object.
     */
    public User getUser(String Name);

    /**
     * change the information of this User(consider by Name).
     * @param user the user.
     * @return true for success ,
     */
    public boolean ChangeInfo(User user) ;


    //  use in Data interaction.

    /**
     * ask the id of user whose name is 'Name'
     * @param Name the name of user.
     * @return a Integer stand the id of this 'Name' , null for there is no this user.
     */
    public Integer askId(String Name) ;
}
