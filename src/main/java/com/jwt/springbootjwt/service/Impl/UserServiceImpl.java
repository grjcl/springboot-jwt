package com.jwt.springbootjwt.service.Impl;

import com.jwt.springbootjwt.domain.User;
import com.jwt.springbootjwt.mapper.UserMapper;
import com.jwt.springbootjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : 小潘
 * @Description :
 * @Date : 2020/11/27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(User user) {
        return userMapper.selectByUsername(user.getUsername());
    }

    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }
}
