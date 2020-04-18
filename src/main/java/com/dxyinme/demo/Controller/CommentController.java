package com.dxyinme.demo.Controller;


import com.dxyinme.demo.Const.CONSTLIST;
import com.dxyinme.demo.HttpResponse.HttpResponse;
import com.dxyinme.demo.model.Comment;
import com.dxyinme.demo.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = {"评论控件"})
@RestController
@CrossOrigin // 允许外部访问
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "按照commentId返回评论" , response = HttpResponse.class)
    @GetMapping(value = "comment/getCommentById")
    public HttpResponse getCommentById(
            @RequestParam(value = "commentId") Long commentId
    ){
        Comment comment = commentService.selectByPrimaryKey(commentId);
        if(comment == null) return new HttpResponse(CONSTLIST.FAIL , "fail");
        return new HttpResponse(CONSTLIST.OK , "ok" ,comment);
    }

}
