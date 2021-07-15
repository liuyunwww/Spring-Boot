package com.jtxy.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author ysj
 * @date 2021/6/28 16:26
 */
@Data
@ApiModel(value = "User对象",description = "系统用户")
public class User {
    //用户id
    private Integer id;
    //用户名字
    private String username;
    //手机号
    private String mobile;
    //年龄
    private Integer age;
    //密码
    private String password;
    //用户角色
    private String role;


}
