package com.jtxy.util;

import java.util.UUID;

/**
 * RandomUtil
 * TODO 随机生成6位随机数作为短信验证码
 * @author ysj
 * @date 2021/6/23 19:08
 */
public class RandomUtil {

    public static String generateCaptcha() {
        return UUID.randomUUID().toString()
                .replaceAll("-", "")
                .replaceAll("[a-z|A-Z]","")
                .substring(0, 6);
    }

}
