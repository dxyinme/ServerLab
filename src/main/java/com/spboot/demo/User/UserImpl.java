package com.spboot.demo.User;

public class UserImpl implements User {
    private String Name;
    private String Message;
    public UserImpl(String name,String message){
        this.Name = name;
        this.Message = message;
    }
    @Override
    public void SetName(String _Name) {
        Name = _Name;
    }

    @Override
    public String toString() {
        return Name+","+Message;
    }

    @Override
    public String getMessage() {
        return Message;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public int hashCode() {
        return Name.hashCode();
    }
}
