package com.myhd.mongodbdemo.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Description: Comment
 * <br></br>
 * className: Comment
 * <br></br>
 * packageName: com.myhd.mongodbdemo.pojo
 *
 * @author jinhui-huang
 * @version 1.0
 * @email 2634692718@qq.com
 * @Date: 2023/11/28 18:08
 */
@Document(collection = "comment")
@CompoundIndex(def = "{'userid':1, 'nickname': -1}")
@Data
public class Comment implements Serializable {
    @Id
    private String id;
    @Field("articleid")
    private String articleId;
    @Field("content")
    private String content;
    @Indexed
    private String userid;
    private String nickname;
    @Field("createdatatime")
    private LocalDateTime createDataTime;
    @Field("likenum")
    private Integer likeNum;
    private String state;

}
