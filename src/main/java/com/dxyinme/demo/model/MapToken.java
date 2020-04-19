package com.dxyinme.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;


@ApiModel(value="com-dxyinme-demo-model-MapToken")
public class MapToken {
    @ApiModelProperty(value="")
    private Map<String , Object> map;

    public MapToken(Map<String,Object> o){
        this.map = o;
    }

    public Map<String,Object> getMap(){
        return map;
    }
}
