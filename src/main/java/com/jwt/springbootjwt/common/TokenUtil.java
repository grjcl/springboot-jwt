package com.jwt.springbootjwt.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * @Author : 小潘
 * @Description : TokenUtil类，用于生成token
 * @Date : 2020/11/27
 */
public class TokenUtil {

    /**
     *
     * @param id  用户id  使用JWT的规定属性aud存放用户id
     * @param sec 秘钥
     * @return
     */
    public static String getToken(String id,String sec){
        return JWT.create().withAudience(id).sign(Algorithm.HMAC256(sec));
    }
}
