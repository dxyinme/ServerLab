package com.spboot.demo.User;

import java.sql.SQLException;

public interface OperatorUser {
    /**
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
}
