package com.spboot.demo.Controller;

import com.spboot.demo.Comment.Comment;
import com.spboot.demo.Comment.CommentFront;
import com.spboot.demo.Comment.CommentImpl;
import com.spboot.demo.Comment.OperatorComment;
import com.spboot.demo.User.OperatorUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin // 允许外部访问
public class CommentController {
    OperatorComment opC = dataLinker.opComment;
    OperatorUser opU = dataLinker.opUser;

    @PostMapping(value = "/CommentOp/addcomment")
    @ResponseBody
    public String addComment(@RequestParam("comment") String comment,
                             @RequestParam("name") String user,
                             @RequestParam("house_id") String house_id) {
        System.out.println(comment  + " _ " +  user + " _ " + house_id);
        int suc = opC.addComment(comment, opU.askId(user), Integer.parseInt(house_id));
        if (suc != 0) {
            return "add success";
        }
        return "can't add";
    }

    @GetMapping(value = "/CommentInfo/askhouse/{house_id}")
    public List<CommentFront> addComment(@PathVariable("house_id") String house_id) {
            List<CommentImpl> ret = opC.askAllComment(Integer.parseInt(house_id));
            List<CommentFront> res = new ArrayList<>();
            for(CommentImpl c : ret){
                res.add(new CommentFront(c,opU.askName(c.getUserId())));
        }
        for(CommentFront c : res){
            System.out.println(c.userName);
        }

        return res;
    }
}
