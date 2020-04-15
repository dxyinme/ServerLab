package com.dxyinme.demo.Controller;


import com.dxyinme.demo.HttpResponse.HttpResponse;
import com.dxyinme.demo.model.House;
import com.dxyinme.demo.model.HouseExample;
import com.dxyinme.demo.service.HouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dxyinme.demo.Const.CONSTLIST;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


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

    //以上是查询信息部分。


    @ApiOperation(value = "添加一间房子" , response = HttpResponse.class)
    @GetMapping(value = "/housesystem/addHouse")
    public HttpResponse addHouse(
            HttpServletRequest request,
            House house
    ){
        Integer userId = (Integer) request.getSession().getAttribute("id");
        if(userId == null) {
            return new HttpResponse(CONSTLIST.FAIL , "login first");
        }
        house.setOwnerid(userId);
        house.setHouseState(0); // 审核通过才是1
        houseService.insert(house);
        return new HttpResponse(CONSTLIST.OK , "add success" , house);
    }


    @ApiOperation(value = "按照id下架/上架房子 , 0 是下架， 1 是上架", response = HttpResponse.class)
    @PostMapping(value = "/housesystem/opTypeHouse")
    public HttpResponse operatorHouse(
            HttpServletRequest request,
            @RequestParam("houseId") Integer houseId,
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
