package com.spboot.demo.service;

import com.spboot.demo.model.User;
import java.util.List;
import com.spboot.demo.model.UserExample;

public interface UserService {


    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(User record, UserExample example);

    int updateByExample(User record, UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}

