package com.dxyinme.demo.service;

import java.util.List;
import com.dxyinme.demo.model.HouseExample;
import com.dxyinme.demo.model.House;
public interface HouseService{


    long countByExample(HouseExample example);

    int deleteByExample(HouseExample example);

    int deleteByPrimaryKey(Integer houseId);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(Integer houseId);

    int updateByExampleSelective(House record,HouseExample example);

    int updateByExample(House record,HouseExample example);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

}
