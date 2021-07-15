package com.jtxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jtxy.entity.User;
import com.jtxy.req.UserRegisterReq;
import com.jtxy.mapper.UserMapper;
import com.jtxy.req.UserLoginReq;
import com.jtxy.result.ResponseEnum;
import com.jtxy.service.UserService;
import com.jtxy.util.AssertUtils;
import com.jtxy.util.JwtUtils;
import com.jtxy.vo.UserLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ysj
 * @date 2021/6/28 16:19
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserLoginVo login(UserLoginReq user) {
        // 使用shiro将登录的手机号和密码封装成UsernamePasswordToken交给shiro校验
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getMobile(), user.getPassword());
        //登录,异常交给全局异常处理
        subject.login(usernamePasswordToken);
        //登录成功,创建vo对象,返回token给前段
        //根据用户id和密码创建token
        User userExisted = userMapper.selectByUserMobile(user.getMobile());
        String token = JwtUtils.createToken(userExisted.getId(), userExisted.getUsername());
        UserLoginVo userLoginVo = new UserLoginVo();
        userLoginVo.setUsername(userExisted.getUsername());
        userLoginVo.setId(userExisted.getId());
        userLoginVo.setToken(token);
        log.info("登录成功");
        return userLoginVo;
    }

    @Override
    public void register(UserRegisterReq userRegisterReq) {
        //根据用户输入手机号查询此手机号是否注册
        String mobile = userRegisterReq.getMobile();
        User userExisted = userMapper.selectByUserMobile(mobile);
        //断言(判断)用户不存在,如果存在则需要按照响应枚举抛出CommonException给全局异常处理
        AssertUtils.isNull(userExisted, ResponseEnum.MOBILE_EXIST_ERROR);
        //创建新用户
        User user = new User();
        String password = userRegisterReq.getPassword();
        user.setMobile(mobile);
        user.setPassword(password);
        userMapper.insert(user);

    }
}
