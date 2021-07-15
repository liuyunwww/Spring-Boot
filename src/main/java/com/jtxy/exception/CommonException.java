package com.jtxy.exception;

import com.jtxy.result.ResponseEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ysj
 * @date 2021/6/28 16:59
 */
@Data
@NoArgsConstructor
public class CommonException extends RuntimeException{
    //状态码
    private Integer code;

    //错误消息
    private String message;

    public CommonException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    /**
     *
     * @param resultCodeEnum 接收枚举类型
     */
    public CommonException(ResponseEnum resultCodeEnum) {
        this.message = resultCodeEnum.getMsg();
        this.code = resultCodeEnum.getCode();
    }

    /**
     *
     * @param resultCodeEnum 接收枚举类型
     * @param cause 原始异常对象
     */
    public CommonException(ResponseEnum resultCodeEnum, Throwable cause) {
        super(cause);
        this.message = resultCodeEnum.getMsg();
        this.code = resultCodeEnum.getCode();
    }
}
