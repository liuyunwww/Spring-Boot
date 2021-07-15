package com.jtxy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jtxy.entity.User;
import com.jtxy.req.UserRegisterReq;
import com.jtxy.req.UserLoginReq;
import com.jtxy.vo.UserLoginVo;

/**
 * @author ysj
 * @date 2021/6/28 16:17
 */
public interface UserService extends IService<User> {

    UserLoginVo login(UserLoginReq user);

    void register(UserRegisterReq userRegisterReq);
}
