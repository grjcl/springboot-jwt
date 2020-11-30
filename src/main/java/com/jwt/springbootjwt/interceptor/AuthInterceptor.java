package com.jwt.springbootjwt.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.jwt.springbootjwt.common.VerifyToken;
import com.jwt.springbootjwt.domain.User;
import com.jwt.springbootjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author : 小潘
 * @Description :
 * @Date : 2020/11/30
 */
public class AuthInterceptor  implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object object){
//        从http请求头中取出token
        String token = httpServletRequest.getHeader("token");
        System.out.println("token==="+token);
//        如果不是映射带Controller方法中直接放行
        System.out.println("object====="+object);
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)object;
        Method method = handlerMethod.getMethod();
//        检查需不需要验证token
        if(method.isAnnotationPresent(VerifyToken.class)){

            VerifyToken userLoginToken = method.getAnnotation(VerifyToken.class);
            if(userLoginToken.required()){
                if(token == null){
                    throw new RuntimeException("该请求没有token!请先获取token");
                }
//                获取token中的userId
                String userId;
                try{
                    userId = JWT.decode(token).getAudience().get(0);
                }catch(JWTDecodeException e){
                    throw new RuntimeException("token非法,没有userId");
                }
                User user = userService.findUserById(userId);
                if(user==null){
                    throw new RuntimeException("用户不存在");
                }

//                验证token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    jwtVerifier.verify(token);

                }catch (JWTVerificationException e){
                    throw new RuntimeException("效验token发生异常");
                }
                return true;
            }
        }
        return true;
    }


    @Override
    public void postHandle( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object object, ModelAndView modelAndView){

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,Object object,Exception e) throws Exception{

    }
}
