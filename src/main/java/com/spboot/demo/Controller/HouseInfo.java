package com.spboot.demo.Controller;

import com.spboot.demo.Const.baiduAPI;
import com.spboot.demo.House_service.HouseService;
import com.spboot.demo.LogicAPI.Urlcov.Urlcov;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HouseInfo {
    HouseService opH = dataLinker.opHouse;
    baiduAPI bua = dataLinker.baiduapi;
    Urlcov urlcatcher = dataLinker.urlcov;
    @GetMapping(value="/HouseInfo/open/QueryMapCircle/{address}")
    public String QueryMapCircle(@PathVariable("address") String address){
        String url = bua.getlLocationByAddress(address);
        System.out.println(url);
        Map<String,Double> mert = urlcatcher.getPosition(url);
        System.out.println(mert.get("lat") + " " + mert.get("lng"));

        return url;
    }
}
