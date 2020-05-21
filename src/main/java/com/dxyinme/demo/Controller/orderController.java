package com.dxyinme.demo.Controller;


import com.dxyinme.demo.Const.CONSTLIST;
import com.dxyinme.demo.HttpResponse.HttpResponse;
import com.dxyinme.demo.model.House;
import com.dxyinme.demo.model.HouseExample;
import com.dxyinme.demo.model.Order;
import com.dxyinme.demo.model.OrderExample;
import com.dxyinme.demo.service.HouseService;
import com.dxyinme.demo.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.ListenerNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Api(tags={"跟订单有关的接口组件"})
@RestController
public class orderController {

    @Autowired
    private HouseService houseService;

    @Autowired
    private OrderService orderService;


    @ApiOperation(value = "查询和当前用户相关的订单" , response = HttpResponse.class)
    @GetMapping("/order/getOrderByUserId")
    public HttpResponse getOrderByUserId(
            HttpServletRequest request
    ){
        Integer userId = (Integer) request.getSession().getAttribute("id");
        if(userId == null) {
            return new HttpResponse(CONSTLIST.FAIL , "login first");
        }
        HouseExample houseExp = new HouseExample();
        houseExp.or().andOwneridEqualTo(userId);
        List<House> houses = houseService.selectByExample(houseExp);
        List<String> houseIdList = new ArrayList<>();
        for (House x : houses) {
            houseIdList.add(x.getHouseId());
        }
        OrderExample orderExp = new OrderExample();
        orderExp.or().andUserIdEqualTo(userId);
        orderExp.or().andHouseIdIn(houseIdList);
        orderExp.setDistinct(true);
        List<Order> res = orderService.selectByExample(orderExp);
        return new HttpResponse(CONSTLIST.OK , "load success" , res);
    }

    @ApiOperation(value = "用户拒绝订单" , response = HttpResponse.class)
    @PostMapping("/order/refuseOrder")
    public HttpResponse refuseOrder(
            HttpServletRequest request,
            @RequestParam(value = "orderId") String orderId
    ){
        Integer userId = (Integer) request.getSession().getAttribute("id");
        if(userId == null) {
            return new HttpResponse(CONSTLIST.FAIL , "login first");
        }
        Order order = orderService.selectByPrimaryKey(orderId);
        House house = houseService.selectByPrimaryKey(order.getHouseId());
        if (!(order.getUserId().equals(userId) ||
            house.getOwnerid().equals(userId))) {
            return new HttpResponse(CONSTLIST.FAIL , "not the owner of this order");
        }
        order.setStatus(CONSTLIST.REFUSED);
        orderService.updateByPrimaryKey(order);
        return new HttpResponse(CONSTLIST.OK , "OK refused");
    }

    @ApiOperation(value = "用户同意订单" , response = HttpResponse.class)
    @PostMapping("/order/acceptOrder")
    public HttpResponse acceptOrder(
            HttpServletRequest request,
            @RequestParam(value = "orderId") String orderId
    ){
        Integer userId = (Integer) request.getSession().getAttribute("id");
        if(userId == null) {
            return new HttpResponse(CONSTLIST.FAIL , "login first");
        }
        Order order = orderService.selectByPrimaryKey(orderId);
        House house = houseService.selectByPrimaryKey(order.getHouseId());
        if (!(order.getUserId().equals(userId) ||
                house.getOwnerid().equals(userId))) {
            return new HttpResponse(CONSTLIST.FAIL , "not the owner of this order");
        }
        order.setStatus(CONSTLIST.ACCEPTED);
        orderService.updateByPrimaryKey(order);
        return new HttpResponse(CONSTLIST.OK , "OK accepted");
    }

    @ApiOperation(value = "管理员完成订单" , response = HttpResponse.class)
    @PostMapping("/order/finishedOrder")
    public HttpResponse finishedOrder(
            HttpServletRequest request,
            @RequestParam(value = "orderId") String orderId
    ){
        Integer userId = (Integer) request.getSession().getAttribute("id");
        if(userId == null) {
            return new HttpResponse(CONSTLIST.FAIL , "login first");
        }
        Order order = orderService.selectByPrimaryKey(orderId);
        if (isNotAdmin(userId)) {
            return new HttpResponse(CONSTLIST.FAIL , "not Admin");
        }
        order.setStatus(CONSTLIST.FINISHED);
        orderService.updateByPrimaryKey(order);
        return new HttpResponse(CONSTLIST.OK , "OK accepted");
    }

    private boolean isNotAdmin(Integer userId) {
        for (Integer v : CONSTLIST.AdminList){
            if (v.equals(userId)) {
                return true;
            }
        }
        return false;
    }
}
