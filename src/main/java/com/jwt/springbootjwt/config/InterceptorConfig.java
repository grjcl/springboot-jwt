package com.jwt.springbootjwt.config;

import com.jwt.springbootjwt.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author : 小潘
 * @Description :
 * @Date : 2020/11/30
 */
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
//        拦截所有请求
        registry.addInterceptor(authInterceptor()).addPathPatterns("/**");
    }
    @Bean
    public AuthInterceptor authInterceptor(){
        return new AuthInterceptor();
    }
}
