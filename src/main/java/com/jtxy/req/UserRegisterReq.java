package com.jtxy.req;

import lombok.Data;

/**
 * @author ysj
 * @date 2021/7/6 10:45
 */
@Data
public class UserRegisterReq {
    private String mobile;
    private String password;
}
