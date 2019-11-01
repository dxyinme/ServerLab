package com.spboot.demo.Controller;


import com.spboot.demo.User.OperatorUser;
import com.spboot.demo.User.User;
import com.spboot.demo.User.UserImpl;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {
    OperatorUser opU = dataLinker.opUser;
    @GetMapping(value = "/UserInfo/{Name}")
    public String QueryUser(@PathVariable("Name") String name) {
        User ret = opU.getUser(name);
        System.out.println(ret.toString());
        Map<String, String> mp = new HashMap<>();
        mp.put("name", ret.getName());
        mp.put("message", ret.getMessage());
        JSONObject jsString = new JSONObject(mp);
        return jsString.toString();
    }

    @PostMapping(value = "/UserOp/signupAPI")
    @ResponseBody
    public String SignUp(@RequestParam("name") String name) {
        System.out.println("success:" + name);
        boolean isSuccess = opU.SignUp(name);
        if (!isSuccess) {
            return "fuck,this name has existed";
        } else {
            return "sign up success";
        }
    }

    @PostMapping(value = "/UserOp/changeInfo")
    @ResponseBody
    public String ChangeInfo(@RequestParam("name") String name,
                             @RequestParam("message") String message) {
        System.out.println("success : " + name + "message : " + message);
        Integer Id = opU.askId(name);
        boolean isSuccess = opU.ChangeInfo(new UserImpl(name, message,Id));
        if (!isSuccess) {
            return "I can't change it!";
        } else {
            return "change information success";
        }
    }
}
