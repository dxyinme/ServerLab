package com.spboot.demo.Controller;

import com.spboot.demo.domain.HouseType;
import com.spboot.demo.service.HouseService;
import com.spboot.demo.service.HouseServiceImp;
import org.springframework.web.bind.annotation.*;

@RestController
public class HouseController {
    HouseService opH = new HouseServiceImp();

    @GetMapping(value = "/HouseInfo/AutoId/{AutoId}")
    public String searchHouseByAutoId(@PathVariable("AutoId") Integer AutoId){

        return opH.searchHouseByAutoId(AutoId).toString();
    }

    @GetMapping(value = "/HouseInfo/location/{location}")
    public String searchHouseByLocation(@PathVariable("location") String location){
        return opH.searchHouseByLocation(location).toString();
    }

    @GetMapping(value = "/HouseInfo/type/{type}")
    public String searchHouseByType(@PathVariable("type") Integer Type){
        return opH.searchHouseByType(Type).toString();
    }

    @GetMapping(value = "/HouseInfo/Area/{minArea}-{maxArea}")
    public String searchHouseByArea(@PathVariable("minArea") Integer minArea,
                                      @PathVariable("maxArea") Integer maxArea){
        return opH.searchHouseByArea(minArea,maxArea).toString();
    }

    @GetMapping(value = "/HouseInfo/Time/{minTime}-{maxTime}")
    public String searchHouseByBuildTime(@PathVariable("minTime") Integer minTime,
                                    @PathVariable("maxTime") Integer maxTime){
        return opH.searchHouseByBuildTime(minTime,maxTime).toString();
    }

    @GetMapping(value = "/HouseInfo/Floor/{minFloor}-{maxFloor}")
    public String searchHouseByFloor(@PathVariable("minFloor") Integer minFloor,
                                     @PathVariable("maxFloor") Integer maxFloor){
        return opH.searchHouseByFloor(minFloor, maxFloor).toString();
    }
    @GetMapping(value = "/HouseInfo/Price/{minPrice}-{maxPrice}")
    public String searchHouseByPrice(@PathVariable("minPrice") Integer minPrice,
                                     @PathVariable("maxPrice") Integer maxPrice){
        System.out.println(minPrice + " " + maxPrice);
        return opH.searchHouseByPrice(minPrice,maxPrice).toString();
    }

    //以上是查询信息部分。

    @PostMapping(value = "/HouseOp/addHouse")
    @ResponseBody
    public String addHouse(@RequestParam("location") String location,
                           @RequestParam("area") String Sarea,
                           @RequestParam("price") String Sprice,
                           @RequestParam("type") String Stype,
                           @RequestParam("floor") String Sfloor,
                           @RequestParam("buildTime") String SbuildTime,
                           @RequestParam("timeLimit") String StimeLimit){
        Integer house_id;
        System.out.println("ffff");
        try{
            house_id = opH.addHouse(location,
                    Integer.parseInt(Sarea),
                    Integer.parseInt(Sprice),
                    Integer.parseInt(Stype),
                    Integer.parseInt(Sfloor),
                    Integer.parseInt(SbuildTime),
                    Integer.parseInt(StimeLimit));
            return "add house" + house_id.toString() + "success";
        }catch(Exception e){
            e.printStackTrace();
            return "fuck!";
        }
    }

    @PostMapping(value = "/HouseOp/deleteHouse")
    @ResponseBody
    public String deleteHouse(@RequestParam("autoId")Integer autoId){
        Integer house_id;
        try {
            house_id = opH.deleteHouse(autoId);
            return "house" + house_id.toString() + "delete success";
        }catch(Exception e){
            e.printStackTrace();
            return "fuck!";
        }
    }

    @PostMapping(value="HouseOp/restoreHouse")
    @ResponseBody
    public String restoreHouse(@RequestParam("autoId") Integer autoId){
        Integer house_id;
        try{
            house_id = opH.restoreHouse(autoId);
            return "house " + house_id.toString() + "has been restore";
        } catch (Exception e) {
            e.printStackTrace();
            return "fuck!";
        }
    }

}
