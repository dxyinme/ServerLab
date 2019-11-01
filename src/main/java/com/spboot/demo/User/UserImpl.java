package com.spboot.demo.User;

public class UserImpl implements User {
    private String Name;
    private String Message;
    private Integer Id;
    public UserImpl(String name,String message,Integer id){
        this.Name = name;
        this.Message = message;
        this.Id = id;
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
    public Integer getId() {
        return Id;
    }

    @Override
    public int hashCode() {
        return Id;
    }
}
