package com.spboot.demo.Controller;

import com.spboot.demo.Const.baiduAPI;
import com.spboot.demo.House.House;
import com.spboot.demo.House.HouseFind;
import com.spboot.demo.House_service.HouseService;
import com.spboot.demo.LogicAPI.Urlcov.Urlcov;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Controller
@CrossOrigin // 允许外部访问
public class HouseInfo {
    HouseService opH = dataLinker.opHouse;
    baiduAPI bua = dataLinker.baiduapi;
    Urlcov urlcatcher = dataLinker.urlcov;

    /*
     * 调用方式
     *
     *
     * /HouseInfo/open/QueryMapImg?address=地名
     * 返回一个<img>
     * sample:
     * <img style="margin:20px" width="280" height="140" src="http://api.map.baidu.com/staticimage/v2?ak=E4805d16520de693a3fe707cdc962045&width=280&height=140&zoom=1"/>
     *
     */
    @RequestMapping(value="/HouseInfo/open/QueryMapImg")
    public String QueryMapImg(String address){
        String url = bua.getlLocationByAddress(address);
        System.out.println(url);
        Map<String,Double> loc = urlcatcher.getPosition(url);
        System.out.println(loc.get("lng") + " " + loc.get("lat"));
        System.out.println(bua.getImgByLocation(loc.get("lng") , loc.get("lat")));
        return bua.getImgByLocation(loc.get("lng") , loc.get("lat"));
    }
    /*
     * 调用方式
     *
     *
     * /HouseInfo/open/QueryMapCircle?address=地名&type=查的东西
     * 返回一个json
     *
     *
     */

    @RequestMapping(value="/HouseInfo/open/QueryMapCircle")
    public String QueryMapCircle(String address,String type , Integer Radius){
        if(Radius == null) {
            Radius = 1000;
        }
        String url = bua.getlLocationByAddress(address);
        Map<String , Double> loc = urlcatcher.getPosition(url);
        url = bua.getCircleSearch(type,loc.get("lng"),loc.get("lat"),Radius);
        List<Map<String , String>> info = urlcatcher.getSomeThing(url , new String[]{
                "address",
                "name",
                "location"
        });
        StringBuilder sb = new StringBuilder("");
        //System.out.println(info);
        for(Map<String,String> now : info){
            sb.append("<br>");
            sb.append(now.get("name"));
            sb.append("<div></div>");
            sb.append("address : " + now.get("address"));
            sb.append("</br>");

        }
        return sb.toString();
    }


    /**
     * json格式
     * /HouseInfo/open/searchFieldHouses?data=province=XXX_city=XXX_...
     * @param data
     * @return
     */
    @RequestMapping(value="/HouseInfo/open/searchFieldHouses")
    //@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
    @ResponseBody
    public List<House> searchFieldHouses(String data){
        System.err.println(data);
        //System.out.println("ddd");
        List<House> res, ret;
        Map<String , String> loc = new HashMap<>();

        try {
            data = URLDecoder.decode(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.err.println("error decode character");
            e.printStackTrace();
        }

        HouseFind hf = new HouseFind(data);
        loc.put("province",hf.getLocation1());
        loc.put("city",hf.getLocation2());
        loc.put("county",hf.getLocation3());
        loc.put("road",hf.getLocation4());
        res = opH.searchFieldHouses(loc);
        System.out.println(res);
        ret = new ArrayList<>();
        /*
        System.out.println("type:"+hf.getType());
        System.out.println("mp:"+hf.getMaxPrice());
        System.out.println("minp:"+hf.getMinPrice());
        System.out.println("ma:"+hf.getMaxPrice());
        System.out.println("mina:"+hf.getMinArea());
        */
        for(House ho : res){
            if(ho.getType() == hf.getType() &&
                hf.getMinArea() <= ho.getArea() && ho.getArea() <= hf.getMaxArea() &&
                hf.getMinPrice() <= ho.getPrice() && ho.getArea() <= hf.getMaxPrice()){
                ret.add(ho);
            }
        }
        System.out.println(ret);
        //System.out.println(ret.size());
        return ret;
    }
}
