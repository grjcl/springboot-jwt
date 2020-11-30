package com.jwt.springbootjwt.mapper;

import com.jwt.springbootjwt.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author : 小潘
 * @Description :
 * @Date : 2020/11/27
 */
@Mapper
@Component
public interface UserMapper {
    @Select("select id,username,password from test where username=#{username}")
    User selectByUsername(@Param("username") String username);

    @Select("select id,username,password from test where id=#{id}")
    User findUserById(@Param("id") String id);
}
