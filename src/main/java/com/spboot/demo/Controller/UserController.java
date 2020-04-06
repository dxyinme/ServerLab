package com.spboot.demo.Controller;



import com.spboot.demo.Const.CONSTLIST;
import com.spboot.demo.HttpResponse.HttpResponse;
import com.spboot.demo.model.House;
import com.spboot.demo.model.User;
import com.spboot.demo.model.UserExample;
import com.spboot.demo.service.HouseService;
import com.spboot.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;


@Api(tags={"用户系统"})
@RestController
@CrossOrigin // 允许外部访问
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    HouseService houseService;



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
        houseService.insert(house);
        return new HttpResponse(CONSTLIST.OK , "load success");
    }

}
