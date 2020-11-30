package com.jwt.springbootjwt.controller;

import com.jwt.springbootjwt.common.Result;
import com.jwt.springbootjwt.common.TokenUtil;
import com.jwt.springbootjwt.common.VerifyToken;
import com.jwt.springbootjwt.domain.User;
import com.jwt.springbootjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : 小潘
 * @Description :
 * @Date : 2020/11/30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User u = userService.findByUsername(user);
        if(u==null){
            return new Result("20001","用户不存在");
        }
        if(!u.getPassword().equals(user.getPassword())){
            return new Result("20002","密码错误");
        }
        String token = TokenUtil.getToken(u.getId(),u.getPassword());
        return new Result("10001","登录成功",token);
    }

    @VerifyToken
    @GetMapping("/getUser")
    public Result getUser(String id){
        User u = userService.findUserById(id);
        return new Result("10002","查询成功",u);
    }
}
