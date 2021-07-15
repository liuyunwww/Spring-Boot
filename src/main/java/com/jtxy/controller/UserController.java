package com.jtxy.controller;

import com.jtxy.req.UserLoginReq;
import com.jtxy.req.UserRegisterReq;
import com.jtxy.result.R;
import com.jtxy.result.ResponseEnum;
import com.jtxy.service.UserService;
import com.jtxy.vo.UserLoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ysj
 * @date 2021/6/28 16:12
 */
@RequestMapping("user")
@RestController
@Api(tags = "用户控制器")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @GetMapping(value = "/unauth")
    @ResponseBody
    @ApiOperation("用户未登录")
    public Object unauth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "1000000");
        map.put("msg", "未登录");
        return map;
    }

    /**
     * 用户登录
     * @param user 登录用户
     * @return
     */
    @GetMapping("/login")
    @ApiOperation("用户登录")
    public R login(UserLoginReq user, HttpServletRequest request){
        System.out.println("request:"+request.getRequestURI());
        UserLoginVo userLoginVo = userService.login(user);
        return R.setResult(ResponseEnum.LOGIN_SUCCESS).setData("userLoginVo",userLoginVo);
    }

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public R register(UserRegisterReq userRegisterReq){
        userService.register(userRegisterReq);
        return R.ok().setMsg("注册成功");
    }


}
