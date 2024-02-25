package com.myhd.mongodbdemo.controller;

import com.myhd.mongodbdemo.pojo.Comment;
import com.myhd.mongodbdemo.service.CommentService;
import com.myhd.mongodbdemo.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: CommentController
 * <br></br>
 * className: CommentController
 * <br></br>
 * packageName: com.myhd.mongodbdemo.controller
 *
 * @author jinhui-huang
 * @version 1.0
 * @email 2634692718@qq.com
 * @Date: 2023/11/28 18:50
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable String id){
        return commentService.findCommentById(id);
    }

    @GetMapping("/userid/{userid}")
    public List<Comment> getCommentByUserId(@PathVariable String userid){
        return commentService.findCommentByUserId(userid);
    }

    @GetMapping("/page/{size}/{page}")
    public List<Comment> getCommentPages(@PathVariable Integer page, @PathVariable Integer size){
        return commentService.getCommentPages(page, size);
    }

    @GetMapping("/page/{userid}/{size}/{page}")
    public List<Comment> getCommentPages(@PathVariable String userid, @PathVariable Integer page, @PathVariable Integer size){
        return commentService.getCommentPages(userid, page, size);
    }

    @GetMapping("/like/{id}")
    public Result incrementLikeNumById(@PathVariable String id){
        Result result = new Result();
        result.setCode(10000);
        result.setData(commentService.incrementLikeNumById(id));
        result.setMsg("返回点赞测试数据, data为 '1' 表示点赞一次");
        return result;
    }

}
