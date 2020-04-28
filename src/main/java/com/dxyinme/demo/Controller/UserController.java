package com.dxyinme.demo.Controller;



import com.dxyinme.demo.Const.CONSTLIST;
import com.dxyinme.demo.HttpResponse.HttpResponse;
import com.dxyinme.demo.LogicAPI.SnowflakeIdWorker;
import com.dxyinme.demo.LogicAPI.generator;
import com.dxyinme.demo.model.*;
import com.dxyinme.demo.service.CommentService;
import com.dxyinme.demo.service.HouseService;
import com.dxyinme.demo.service.OrderService;
import com.dxyinme.demo.service.UserService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.List;


@Api(tags={"用户系统"})
@RestController
@CrossOrigin // 允许外部访问
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    HouseService houseService;

    @Autowired
    OrderService orderService;


    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name="commentInsert")
    private Destination commentInsert;

    @Resource(name="commentInsert2")
    private Destination commentInsert2;

    @Resource(name="subscribeInsert")
    private Destination subscribeInsert;

    @Resource(name="subscribeInsert2")
    private Destination subscribeInsert2;

    @Resource(name="subscribeDelete")
    private Destination subscribeDelete;

    @Resource(name="subscribeDelete2")
    private Destination subscribeDelete2;


    @ApiOperation(value = "登录" , response = HttpResponse.class)
    @PostMapping("usersystem/login")
    public HttpResponse Login(
            HttpServletRequest request,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password
    ){
        Integer userId = (Integer) request.getSession().getAttribute("id");
        if(userId != null) {
            return new HttpResponse(CONSTLIST.FAIL , "不许重复登录");
        }
        UserExample userExample = new UserExample();
        userExample.or()
                .andUserNameEqualTo(username);
        List<User> userList = userService.selectByExample(userExample);
        if(userList.size() == 0){
            return new HttpResponse(CONSTLIST.FAIL , "no such user");
        }
        User nowUser = userList.get(0);
        if(nowUser.getPassWord().equals(password)) {
            request.getSession().setAttribute("id" , nowUser.getId());
            return new HttpResponse(CONSTLIST.OK, "login success");
        }
        else{
            return new HttpResponse(CONSTLIST.FAIL , "wrong password");
        }
    }


    @ApiOperation(value = "注册" , response = HttpResponse.class)
    @PostMapping("usersystem/SignUp")
    public HttpResponse SignUp(
            HttpServletRequest request,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password
    ){
        UserExample userExample = new UserExample();
        userExample.or().andUserNameEqualTo(username);
        if(userService.countByExample(userExample) != 0) {
            return new HttpResponse(CONSTLIST.FAIL , "用户名 已经存在");
        }
        else {
            userService.insert(new User(username , password));
            return new HttpResponse(CONSTLIST.OK , "注册成功");
        }
    }


    @ApiOperation(value = "录入房源" , response = HttpResponse.class)
    @PostMapping( value = "usersystem/loadHouse" )
    public HttpResponse loadHouse(
            HttpServletRequest request,
            House house){
        Integer userId = (Integer) request.getSession().getAttribute("id");
        if(userId == null){
            return new HttpResponse(CONSTLIST.FAIL , "login first");
        }
        house.setOwnerid(userId);
        house.setHouseState(0);
        house.setHouseId(generator.getNewHouseId(userId));
        houseService.insert(house);
        return new HttpResponse(CONSTLIST.OK , "load success");
    }


    @ApiOperation(value = "发起购买请求" , response = HttpResponse.class)
    @PostMapping(value = "usersystem/orderHouse")
    public HttpResponse orderHouse(
        HttpServletRequest request,
        @RequestParam(value = "houseId") String HouseId
    ){
        Integer userId = (Integer) request.getSession().getAttribute("id");
        if(userId == null){
            return new HttpResponse(CONSTLIST.FAIL , "login first");
        }
        Long NewId = SnowflakeIdWorker.nextId();
        Order order = new Order(NewId.toString(),userId,HouseId,
                new Date(System.currentTimeMillis()),CONSTLIST.WAITING);
        orderService.insert(order);
        return new HttpResponse(CONSTLIST.OK , "order success");
    }


    @ApiOperation(value = "用户对房子发送评论" , response = HttpResponse.class)
    @PostMapping(value = "usersystem/addComment")
    public HttpResponse addComment(
            HttpServletRequest request,
            @RequestParam(value = "houseId") String houseId,
            @RequestParam(value = "comment") String commentContext
    ){
        Integer userId = (Integer) request.getSession().getAttribute("id");
        if(userId == null){
            return new HttpResponse(CONSTLIST.FAIL , "login first");
        }
        Gson gson = new Gson();
        Date now = new Date(System.currentTimeMillis());
        Comment comment = new Comment( commentContext , userId , houseId
                , true , now.toString());
        String v = gson.toJson(comment);
        jmsTemplate.convertAndSend(commentInsert,v);
        jmsTemplate.convertAndSend(commentInsert2,v);
        return new HttpResponse(CONSTLIST.OK , "add success");
    }

    @ApiOperation(value = "用户关注房子" , response = HttpResponse.class)
    @PostMapping(value = "usersystem/subscribe")
    public HttpResponse subscribe(
            HttpServletRequest request,
            @RequestParam(value = "houseId") String houseId
    ){
        Integer userId = (Integer) request.getSession().getAttribute("id");
        if(userId == null){
            return new HttpResponse(CONSTLIST.FAIL , "login first");
        }
        Subscribe subscribe = new Subscribe(userId , houseId
                , new Date(System.currentTimeMillis()).toString());
        Gson gson = new Gson(); String v = gson.toJson(subscribe);
        jmsTemplate.convertAndSend(subscribeInsert,v);
        jmsTemplate.convertAndSend(subscribeInsert2,v);
        return new HttpResponse(CONSTLIST.OK , "subscribe success");
    }


    @ApiOperation(value = "用户取消关注房子" , response = HttpResponse.class)
    @PostMapping(value = "usersystem/subscribeDelete")
    public HttpResponse subscribeDelete(
            HttpServletRequest request,
            @RequestParam(value = "houseId") String houseId
    ){
        Integer userId = (Integer) request.getSession().getAttribute("id");
        if(userId == null){
            return new HttpResponse(CONSTLIST.FAIL , "login first");
        }
        Subscribe subscribe = new Subscribe(userId , houseId
                , null);
        Gson gson = new Gson(); String v = gson.toJson(subscribe);
        jmsTemplate.convertAndSend(subscribeDelete,v);
        jmsTemplate.convertAndSend(subscribeDelete2,v);
        return new HttpResponse(CONSTLIST.OK , "subscribe success");
    }
}
