package com.jwt.springbootjwt.interceptor;

import com.jwt.springbootjwt.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author : 小潘
 * @Description :
 * @Date : 2020/11/30
 */
@ControllerAdvice
public class GloablExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e){
        e.printStackTrace();
        return new Result("30001",e.getMessage()!=null?e.getMessage():"服务器发生错误");
    }
}
