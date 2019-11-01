package com.spboot.demo.User;

public interface User {

    /**
     * set a new name of this user.
     * @param _Name the new name of User.
     *
     */
    public void SetName(String _Name);

    /**
     * toString method.
     * @return a string about all attributes of this user.
     */
    public String toString();

    /**
     *
     * @return message  of this User.
     */
    public String getMessage();

    /**
     *
     * @return name of this User.
     */
    public String getName();

    /**
     *
     * @return Id of this user.
     */
    public Integer getId();

}
