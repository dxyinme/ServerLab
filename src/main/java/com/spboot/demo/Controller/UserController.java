package com.spboot.demo.Controller;



import com.spboot.demo.Const.CONSTLIST;
import com.spboot.demo.HttpResponse.HttpResponse;
import com.spboot.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;


@Api(tags={"用户系统"})
@RestController
@CrossOrigin // 允许外部访问
public class UserController {

    @Autowired
    UserService userService;



    @ApiOperation(value = "登录" , response = HttpResponse.class)
    @PostMapping("usersystem/login")
    public HttpResponse Login(
            HttpServletRequest request,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password
    ){
        System.err.println(username + " " + password);
        return new HttpResponse(CONSTLIST.OK , "login success");
    }

}
