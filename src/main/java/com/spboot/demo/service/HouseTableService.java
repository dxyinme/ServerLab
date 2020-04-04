package com.spboot.demo.service;

import java.util.List;
import com.spboot.demo.model.HouseTableExample;
import com.spboot.demo.model.HouseTable;
public interface HouseTableService{


    long countByExample(HouseTableExample example);

    int deleteByExample(HouseTableExample example);

    int deleteByPrimaryKey(Integer houseId);

    int insert(HouseTable record);

    int insertSelective(HouseTable record);

    List<HouseTable> selectByExample(HouseTableExample example);

    HouseTable selectByPrimaryKey(Integer houseId);

    int updateByExampleSelective(HouseTable record,HouseTableExample example);

    int updateByExample(HouseTable record,HouseTableExample example);

    int updateByPrimaryKeySelective(HouseTable record);

    int updateByPrimaryKey(HouseTable record);

}
