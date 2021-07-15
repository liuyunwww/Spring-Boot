package com.jtxy.config;

import com.jtxy.entity.User;
import com.jtxy.exception.CommonException;
import com.jtxy.mapper.UserMapper;
import com.jtxy.result.ResponseEnum;
import com.jtxy.util.AssertUtils;
import com.jtxy.vo.UserLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;

/**
 * @author ysj
 * @date 2021/6/28 17:28
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {
    public static ThreadLocal<UserLoginVo> userLogin = new ThreadLocal<>();

    @Resource
    private UserMapper userMapper;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //根据登录用户的账户(手机号)查询用户
        User user = userMapper.selectByUserMobile(principals.getPrimaryPrincipal().toString());
        //用户存在抛出自定义异常,交给全局异常处理器处理
        if (user==null){
            throw new CommonException(ResponseEnum.LOGIN_AUTH_ERROR);
        }
        //封装用户的角色列表,此时设计只有一次(后期可改为多角色)
        HashSet<String> roles = new HashSet<String>();
        roles.add(user.getRole());
        //创建授权信息,交给shiro进行授权处理
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        AssertUtils.isNull(token.getPrincipal(),ResponseEnum.LOGIN_AUTH_ERROR);
        log.error("principle是{}",token.getPrincipal());
        // 获取用户信息
        String mobile = token.getPrincipal().toString();
        System.out.println("mobile => " + mobile);
        User user = userMapper.selectByUserMobile(mobile);
        if (null == user) {
            //这里返回后会报出对应异常
            return null;
        }
        //这里验证authenticationToken和simpleAuthenticationInfo的信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(mobile,
                user.getPassword(), getName());
        return simpleAuthenticationInfo;
    }
}
