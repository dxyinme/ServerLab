package com.dxyinme.demo.mapper;

import com.dxyinme.demo.model.Subscribe;
import com.dxyinme.demo.model.SubscribeExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SubscribeMapper {
    long countByExample(SubscribeExample example);

    int deleteByExample(SubscribeExample example);

    int deleteByPrimaryKey(String subscribeId);

    int insert(Subscribe record);

    int insertSelective(Subscribe record);

    List<Subscribe> selectByExample(SubscribeExample example);

    Subscribe selectByPrimaryKey(String subscribeId);

    int updateByExampleSelective(@Param("record") Subscribe record, @Param("example") SubscribeExample example);

    int updateByExample(@Param("record") Subscribe record, @Param("example") SubscribeExample example);

    int updateByPrimaryKeySelective(Subscribe record);

    int updateByPrimaryKey(Subscribe record);
}