package com.spboot.demo.Controller;

import com.spboot.demo.Comment.OperatorComment;
import com.spboot.demo.User.OperatorUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    OperatorComment opC = dataLinker.opComment;
    OperatorUser opU = dataLinker.opUser;
    @PostMapping(value = "/CommentOp/addcomment")
    @ResponseBody
    public String addComment(@RequestParam("comment") String comment,
                             @RequestParam("name") String user,
                             @RequestParam("house_id") String house_id){
        int suc = opC.addComment(comment , opU.askId(user) ,Integer.parseInt(house_id));
        if(suc != 0){
            return "add success";
        }
                return "can't add";
                }

@GetMapping(value = "/CommentInfo/askhouse/{house_id}")
public String addComment(@PathVariable("house_id") String house_id){
        List<String> ret = opC.askAllComment(Integer.parseInt(house_id));
        return ret.toString();
        }
        }
