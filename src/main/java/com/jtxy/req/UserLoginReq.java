package com.jtxy.req;

import lombok.Data;
import lombok.ToString;

/**
 * @author ysj
 * @date 2021/6/28 16:11
 */
@Data
@ToString
public class UserLoginReq {

    private String mobile;

    private String password;
}
