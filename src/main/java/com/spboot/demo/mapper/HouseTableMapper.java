package com.spboot.demo.mapper;

import com.spboot.demo.model.HouseTable;
import com.spboot.demo.model.HouseTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HouseTableMapper {
    long countByExample(HouseTableExample example);

    int deleteByExample(HouseTableExample example);

    int deleteByPrimaryKey(Integer houseId);

    int insert(HouseTable record);

    int insertSelective(HouseTable record);

    List<HouseTable> selectByExample(HouseTableExample example);

    HouseTable selectByPrimaryKey(Integer houseId);

    int updateByExampleSelective(@Param("record") HouseTable record, @Param("example") HouseTableExample example);

    int updateByExample(@Param("record") HouseTable record, @Param("example") HouseTableExample example);

    int updateByPrimaryKeySelective(HouseTable record);

    int updateByPrimaryKey(HouseTable record);
}