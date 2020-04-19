package com.dxyinme.demo.LogicAPI;

import com.dxyinme.demo.model.House;

public class generator {
    public static String getNewHouseId(Integer ownerId){
        String code = Long.toString(System.currentTimeMillis());
        code += "_" + ownerId;
        return code;
    }
}
