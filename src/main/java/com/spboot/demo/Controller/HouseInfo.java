package com.spboot.demo.Controller;

import com.spboot.demo.Const.baiduAPI;
import com.spboot.demo.House_service.HouseService;
import com.spboot.demo.LogicAPI.Urlcov.Urlcov;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HouseInfo {
    HouseService opH = dataLinker.opHouse;
    baiduAPI bua = dataLinker.baiduapi;
    Urlcov urlcatcher = dataLinker.urlcov;

    /*
     * 调用方式
     *
     *
     * /HouseInfo/open/QueryMapCircle?address=地名
     * 返回一个<img>
     * sample:
     * <img style="margin:20px" width="280" height="140" src="http://api.map.baidu.com/staticimage/v2?ak=E4805d16520de693a3fe707cdc962045&width=280&height=140&zoom=1"/>
     *
     */
    @RequestMapping(value="/HouseInfo/open/QueryMapCircle")
    public String QueryMapCircle(String address){
        String url = bua.getlLocationByAddress(address);
        System.out.println(url);
        Map<String,Double> mert = urlcatcher.getPosition(url);
        System.out.println(mert.get("lng") + " " + mert.get("lat"));
        System.out.println(bua.getImgByLocation(mert.get("lng") , mert.get("lat")));
        return bua.getImgByLocation(mert.get("lng") , mert.get("lat"));
    }
}
