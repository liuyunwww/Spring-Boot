package com.jtxy.exception.advice;

import com.jtxy.exception.CommonException;
import com.jtxy.result.R;
import com.jtxy.result.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author ysj
 * @date 2021/6/28 17:05
 * 全局异常处理
 */
@RestControllerAdvice
@Component
@Slf4j
public class GlobalExceptionAdvice {
    @ExceptionHandler({Exception.class})
    public R handlerException(Exception e){
        log.error(e.getMessage(),e);
        return R.error().setData("errorMsg",e);
    }

    @ExceptionHandler({UnknownAccountException.class})
    public R handlerException(UnknownAccountException e){
        log.error(e.getMessage(),e);
        return R.setResult(ResponseEnum.LOGIN_MOBILE_ERROR);
    }

    @ExceptionHandler({IncorrectCredentialsException.class})
    public R handlerException(IncorrectCredentialsException e){
        log.error(e.getMessage(),e);
        return R.setResult(ResponseEnum.LOGIN_PASSWORD_ERROR);
    }

    @ExceptionHandler({BadSqlGrammarException.class})
    public R handlerException(BadSqlGrammarException e){
        log.error(e.getMessage(),e);
        return R.error().setMsg("sql语法异常");
    }

    @ExceptionHandler({CommonException.class})
    public R handlerException(CommonException e){
        log.error(e.getMessage(),e);
        return R.error().setData("errorMsg",e).setMsg(e.getMessage());
    }
    /**
     * Controller上一层相关异常
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public R handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        //SERVLET_ERROR(-102, "servlet请求异常"),
        return R.error().setMsg(ResponseEnum.SERVLET_ERROR.getMsg()).setCode(ResponseEnum.SERVLET_ERROR.getCode());
    }
}
