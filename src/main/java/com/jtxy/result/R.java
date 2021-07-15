package com.jtxy.result;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ysj
 * @date 2021/6/23 19:08
 */
@Data
@Accessors(chain = true)
public class R {
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回的数据
     */
    private Map<String,Object> data = new HashMap<>();

    /**
     * 构造函数私有化,防止使用无参函数new对象,使用静态方法或者全参构造即可
     */
    private R(){}

    public R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static R ok(){
        R r = new R(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg());
        return r;
    }

    public static R error(){
        R r = new R(ResponseEnum.ERROR.getCode(),ResponseEnum.ERROR.getMsg());
        return r;
    }


    /**
     * 直接传入返回值的枚举类,封装异常参数和异常码
      */
    public static R setResult(ResponseEnum responseEnum){
        return new R(responseEnum.getCode(), responseEnum.getMsg());
    }

    public R    setData(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    /**
     *
     * @param key  返回数据的key
     * @param type  返回数据的类型  使用方法: TypeReference<T> type =  new TypeReference<T>(){} 传入该type,可以直接将数据转换成T类型取出
     * @param <T>  将返回数据按我们需要的类型参数type取出
     * @return  返回type类型的数据
     */
    public <T> T getData(String key, TypeReference<T> type){
        Object data = this.data.get(key);
        return JSON.parseObject(JSON.toJSONString(data),type.getType());
    }
}
