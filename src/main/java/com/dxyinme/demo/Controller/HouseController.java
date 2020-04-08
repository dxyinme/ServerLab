package com.dxyinme.demo.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin // 允许外部访问
public class HouseController {




    @GetMapping(value = "/HouseInfo/location/{location}")
    public String searchHouseByLocation(@PathVariable("location") String location){
        return null;
    }

    @GetMapping(value = "/HouseInfo/type/{type}")
    public String searchHouseByType(@PathVariable("type") Integer Type){
        return null;
    }

    @GetMapping(value = "/HouseInfo/Area/{minArea}-{maxArea}")
    public String searchHouseByArea(@PathVariable("minArea") Integer minArea,
                                      @PathVariable("maxArea") Integer maxArea){
        return null;
    }

    @GetMapping(value = "/HouseInfo/Time/{minTime}-{maxTime}")
    public String searchHouseByBuildTime(@PathVariable("minTime") Integer minTime,
                                    @PathVariable("maxTime") Integer maxTime){
        return null;
    }

    @GetMapping(value = "/HouseInfo/Floor/{minFloor}-{maxFloor}")
    public String searchHouseByFloor(@PathVariable("minFloor") Integer minFloor,
                                     @PathVariable("maxFloor") Integer maxFloor){
        return null;
    }
    @GetMapping(value = "/HouseInfo/Price/{minPrice}-{maxPrice}")
    public String searchHouseByPrice(@PathVariable("minPrice") Integer minPrice,
                                     @PathVariable("maxPrice") Integer maxPrice){
        return null;
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

        return null;
    }

    @PostMapping(value = "/HouseOp/deleteHouse")
    @ResponseBody
    public String deleteHouse(@RequestParam("autoId")Integer autoId){
        return null;
    }

    @PostMapping(value="/HouseOp/restoreHouse")
    @ResponseBody
    public String restoreHouse(@RequestParam("autoId") Integer autoId){
        return null;
    }

}
