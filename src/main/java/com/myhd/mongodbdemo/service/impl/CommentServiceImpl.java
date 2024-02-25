package com.myhd.mongodbdemo.service.impl;

import com.myhd.mongodbdemo.dao.CommentRepository;
import com.myhd.mongodbdemo.pojo.Comment;
import com.myhd.mongodbdemo.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * Description: CommentServiceImpl
 * <br></br>
 * className: CommentServiceImpl
 * <br></br>
 * packageName: com.myhd.mongodbdemo.service.impl
 *
 * @author jinhui-huang
 * @version 1.0
 * @email 2634692718@qq.com
 * @Date: 2023/11/28 18:20
 */
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private CommentRepository commentRepository;

    /**
     * Description: saveComment 保存文章
     *
     * @param comment
     * @return void
     * @author jinhui-huang
     * @Date 2023/11/28
     */
    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    /**
     * Description: updateComment 更新文章
     *
     * @param comment
     * @return void
     * @author jinhui-huang
     * @Date 2023/11/28
     */
    @Override
    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    /**
     * Description: deleteCommentById 根据文档id删除文档
     *
     * @param id
     * @return void
     * @author jinhui-huang
     * @Date 2023/11/28
     */
    @Override
    public void deleteCommentById(String id) {
        commentRepository.deleteById(id);
    }

    /**
     * Description: findCommentList 查询全部文档
     *
     * @return java.util.List<com.myhd.mongodbdemo.pojo.Comment>
     * @author jinhui-huang
     * @Date 2023/11/28
     */
    @Override
    public List<Comment> findCommentList() {
        return commentRepository.findAll();
    }

    /**
     * 根据id查询单个文档
     * Description: findCommentById
     *
     * @param id
     * @return com.myhd.mongodbdemo.pojo.Comment
     * @author jinhui-huang
     * @Date 2023/11/28
     */
    @Override
    public Comment findCommentById(String id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);

        return commentOptional.orElse(null);
    }

    /**
     * Description: findCommentByUserId 根据用户id查询多篇文章
     * @return java.util.List<com.myhd.mongodbdemo.pojo.Comment>
     * @author jinhui-huang
     * @Date 2023/11/28
     * */
    @Override
    public List<Comment> findCommentByUserId(String userid) {
        return commentRepository.findCommentByUserid(userid);
    }

    @Override
    public List<Comment> getCommentPages(int page, int size){
        Page<Comment> pages = commentRepository.findAll(PageRequest.of(page - 1, size));
        return showPageInfo(pages);
    }

    @Override
    public List<Comment> getCommentPages(String userid, int page, int size){
        Page<Comment> pages = commentRepository.findByUserid(userid, PageRequest.of(page - 1, size));
        return showPageInfo(pages);
    }

    private List<Comment> showPageInfo(Page<Comment> pages) {
        int totalPages = pages.getTotalPages();
        int number = pages.getNumber();
        long elements = pages.getTotalElements();
        List<Comment> content = pages.getContent();
        log.info("当前页数: {}", number + 1);
        log.info("总页数: {}", totalPages);
        log.info("总记录数: {}", elements);
        log.info("当前页数据: {}", content);
        return content;
    }

    @Override
    public Long incrementLikeNumById(String id){
        log.info("为id为 {} 的文章增加点赞数", id);
        return commentRepository.findAndIncrementLikeNumById(id);
    }

}
