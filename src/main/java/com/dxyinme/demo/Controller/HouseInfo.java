package com.dxyinme.demo.Controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Api(tags={"房源信息组件"})
@RestController
@Controller
@CrossOrigin // 允许外部访问
public class HouseInfo {

    @ApiOperation(value = "测试")
    @GetMapping("housesystem/test")
    public String test(){
        return "test";
    }

}
