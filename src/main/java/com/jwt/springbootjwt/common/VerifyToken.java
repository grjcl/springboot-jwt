package com.jwt.springbootjwt.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author : 小潘
 * @Description : VerifyToken注解类：加到controller方法上表示该方法需要验证token。
 * @Date : 2020/11/27
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface VerifyToken {
    boolean required() default true;
}
