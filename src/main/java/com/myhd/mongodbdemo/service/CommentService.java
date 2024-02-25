package com.myhd.mongodbdemo.service;

import com.myhd.mongodbdemo.pojo.Comment;

import java.util.List;

/**
 * Description: CommentService
 * <br></br>
 * className: CommentService
 * <br></br>
 * packageName: com.myhd.mongodbdemo.service
 *
 * @author jinhui-huang
 * @version 1.0
 * @email 2634692718@qq.com
 * @Date: 2023/11/28 18:19
 */
public interface CommentService {
    /**
     * Description: saveComment 保存文章
     * @return void
     * @author jinhui-huang
     * @Date 2023/11/28
     * */
    void saveComment(Comment comment);

    /**
     * Description: updateComment 更新文章
     * @return void
     * @author jinhui-huang
     * @Date 2023/11/28
     * */
    void updateComment(Comment comment);

    /**
     * Description: deleteCommentById 根据文档id删除文档
     * @return void
     * @author jinhui-huang
     * @Date 2023/11/28
     * */
    void deleteCommentById(String id);

    /**
     * Description: findCommentList 查询全部文档
     * @return java.util.List<com.myhd.mongodbdemo.pojo.Comment>
     * @author jinhui-huang
     * @Date 2023/11/28
     * */
    List<Comment> findCommentList();

    /** 根据id查询单个文档
     * Description: findCommentById
     * @return com.myhd.mongodbdemo.pojo.Comment
     * @author jinhui-huang
     * @Date 2023/11/28
     * */
    Comment findCommentById(String id);

    List<Comment> findCommentByUserId(String userid);

    List<Comment> getCommentPages(int page, int size);

    List<Comment> getCommentPages(String userid, int page, int size);

    Long incrementLikeNumById(String id);
}
