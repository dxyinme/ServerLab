package com.dxyinme.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.dxyinme.demo.model.HouseExample;
import com.dxyinme.demo.model.House;
import com.dxyinme.demo.mapper.HouseMapper;
import com.dxyinme.demo.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

    @Resource
    private HouseMapper houseMapper;

    @Override
    public long countByExample(HouseExample example) {
        return houseMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(HouseExample example) {
        return houseMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String houseId) {
        return houseMapper.deleteByPrimaryKey(houseId);
    }

    @Override
    public int insert(House record) {
        return houseMapper.insert(record);
    }

    @Override
    public List<House> selectByExample(HouseExample example) {
        return houseMapper.selectByExample(example);
    }

    @Override
    public House selectByPrimaryKey(String houseId) {
        return houseMapper.selectByPrimaryKey(houseId);
    }

    @Override
    public int updateByExampleSelective(House record, HouseExample example) {
        return houseMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(House record, HouseExample example) {
        return houseMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(House record) {
        return houseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(House record) {
        return houseMapper.updateByPrimaryKey(record);
    }

}

