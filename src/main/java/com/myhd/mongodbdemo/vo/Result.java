package com.myhd.mongodbdemo.vo;

import lombok.Data;

/**
 * Description: result
 * <br></br>
 * className: result
 * <br></br>
 * packageName: com.myhd.mongodbdemo.dto
 *
 * @author jinhui-huang
 * @version 1.0
 * @email 2634692718@qq.com
 * @Date: 2023/11/28 21:27
 */
@Data
public class Result {
    private Integer code;
    private Object data;
    private String msg;
}
