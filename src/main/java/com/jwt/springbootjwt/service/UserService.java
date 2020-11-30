package com.jwt.springbootjwt.service;

import com.jwt.springbootjwt.domain.User;

/**
 * @Author : 小潘
 * @Description :
 * @Date : 2020/11/27
 */
public interface UserService {
    User findByUsername(User user);

    User findUserById(String id);
}
