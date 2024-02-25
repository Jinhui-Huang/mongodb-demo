package com.myhd.mongodbdemo.dao;

import com.myhd.mongodbdemo.pojo.Comment;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;

/**
 * Description: CommentRepository
 * <br></br>
 * className: CommentRepository
 * <br></br>
 * packageName: com.myhd.mongodbdemo.dao
 *
 * @author jinhui-huang
 * @version 1.0
 * @email 2634692718@qq.com
 * @Date: 2023/11/28 18:18
 */
public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findCommentByUserid(String userid);

    Page<Comment> findByUserid(String userid, Pageable pageable);

    @Update("{'$inc': {likenum: 1}}")
    Long findAndIncrementLikeNumById(String id);

}
