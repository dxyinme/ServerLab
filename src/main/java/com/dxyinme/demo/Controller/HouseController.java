package com.dxyinme.demo.Controller;


import com.dxyinme.demo.Const.baiduAPI;
import com.dxyinme.demo.HttpResponse.HttpResponse;
import com.dxyinme.demo.LogicAPI.Urlcov;
import com.dxyinme.demo.model.House;
import com.dxyinme.demo.model.HouseExample;
import com.dxyinme.demo.service.HouseService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dxyinme.demo.Const.CONSTLIST;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(tags = {"房源接口"})
@RestController
@CrossOrigin // 允许外部访问
public class HouseController {

    @Autowired
    HouseService houseService;


    @ApiOperation(value = "按照地址查询" , response = HttpResponse.class)
    @GetMapping(value = "/housesystem/location/{location}")
    public HttpResponse searchHouseByLocation(
            @PathVariable("location") String location
    ){
        HouseExample houseExp = new HouseExample();
        location = "%" + location + "%";
        houseExp.or().andHouseLocationLike(location);
        List<House> res = houseService.selectByExample(houseExp);
        if(res.size() == 0){
            return new HttpResponse(CONSTLIST.FAIL , "no result");
        }
        return new HttpResponse(CONSTLIST.OK , "load success" , res);
    }


    @ApiOperation(value = "按照户型查询" , response = HttpResponse.class)
    @GetMapping(value = "/housesystem/type/{type}")
    public HttpResponse searchHouseByType(
            @PathVariable("type") Integer Type
    ){
        HouseExample houseExp = new HouseExample();
        houseExp.or().andHouseTypeEqualTo(Type);
        List<House> res = houseService.selectByExample(houseExp);
        if(res.size() == 0){
            return new HttpResponse(CONSTLIST.FAIL , "no result");
        }
        return new HttpResponse(CONSTLIST.OK , "load success" , res);
    }


    @ApiOperation(value = "按照面积查询" , response = HttpResponse.class)
    @GetMapping(value = "/housesystem/Area/{minArea}-{maxArea}")
    public HttpResponse searchHouseByArea(
            @PathVariable("minArea") Integer minArea,
            @PathVariable("maxArea") Integer maxArea
    ){
        HouseExample houseExp = new HouseExample();
        houseExp.or().andHouseAreaBetween(minArea , maxArea);
        List<House> res = houseService.selectByExample(houseExp);
        if(res.size() == 0){
            return new HttpResponse(CONSTLIST.FAIL , "no result");
        }
        return new HttpResponse(CONSTLIST.OK , "load success" , res);
    }

    @ApiOperation(value = "按照楼层查询" , response = HttpResponse.class)
    @GetMapping(value = "/housesystem/Floor/{minFloor}-{maxFloor}")
    public HttpResponse searchHouseByFloor(
            @PathVariable("minFloor") Integer minFloor,
            @PathVariable("maxFloor") Integer maxFloor){
        HouseExample houseExp = new HouseExample();
        houseExp.or().andHouseFloorBetween(minFloor, maxFloor);
        List<House> res = houseService.selectByExample(houseExp);
        if(res.size() == 0){
            return new HttpResponse(CONSTLIST.FAIL , "no result");
        }
        return new HttpResponse(CONSTLIST.OK , "load success" , res);
    }


    @ApiOperation(value = "按照价格查询" , response = HttpResponse.class)
    @GetMapping(value = "/housesystem/Price/{minPrice}-{maxPrice}")
    public HttpResponse searchHouseByPrice(
            @PathVariable("minPrice") Integer minPrice,
            @PathVariable("maxPrice") Integer maxPrice){
        HouseExample houseExp = new HouseExample();
        houseExp.or().andHousePriceBetween(minPrice, maxPrice);
        List<House> res = houseService.selectByExample(houseExp);
        if(res.size() == 0){
            return new HttpResponse(CONSTLIST.FAIL , "no result");
        }
        return new HttpResponse(CONSTLIST.OK , "load success" , res);
    }




    @ApiOperation(value = "按照houseId查询" , response = HttpResponse.class)
    @GetMapping(value = "/housesystem/getHouseById")
    public HttpResponse getHouseById(
            @RequestParam(value = "houseId") String houseId
    ){
        House house = houseService.selectByPrimaryKey(houseId);
        if(house == null) {
            return new HttpResponse(CONSTLIST.FAIL , "no result");
        }
        Gson gson = new Gson();
        String o = gson.toJson(house);
        Map<String , Object> oMap = gson.fromJson(o, HashMap.class);
        String url = baiduAPI.getLocationByAddress(house.getHouseLocation());
        Map pos = Urlcov.getPosition(url);
        System.err.println( " " + pos.get("lat") + " " + pos.get("lng"));
        oMap.put("position" , pos);
        return new HttpResponse(CONSTLIST.OK , "load success" , oMap);
    }

    //以上是查询信息部分。

    @ApiOperation(value = "按照id下架/上架房子 , 0 是下架， 1 是上架", response = HttpResponse.class)
    @PostMapping(value = "/housesystem/opTypeHouse")
    public HttpResponse operatorHouse(
            HttpServletRequest request,
            @RequestParam("houseId") String houseId,
            @RequestParam("opType") Integer opType
            ){
        Integer userId = (Integer) request.getSession().getAttribute("id");
        if(userId == null) {
            return new HttpResponse(CONSTLIST.FAIL , "login first");
        }
        House house = houseService.selectByPrimaryKey(houseId);
        if(!house.getOwnerid().equals(userId)){
            return new HttpResponse(CONSTLIST.FAIL , "you are not the owner");
        }
        house.setHouseState(opType);
        houseService.updateByPrimaryKey(house);
        return new HttpResponse(CONSTLIST.OK , "operate Success");
    }


}
