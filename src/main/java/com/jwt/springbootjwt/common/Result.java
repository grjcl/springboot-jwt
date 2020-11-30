package com.jwt.springbootjwt.common;

/**
 * @Author : 小潘
 * @Description :
 * @Date : 2020/11/27
 */
public class Result<T> {
    private String code;
    private String message;
    private T t;

    public Result() {
        super();
    }

    public Result(String code, String message, T t) {
        this.code = code;
        this.message = message;
        this.t = t;
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
