package com.springbootmybatis.dao.controller;

import com.springbootmybatis.dao.UserMapper;
import com.springbootmybatis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年09月27号:18点31分
 * @mailbox mynameisweiyan@gmail.com
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/findList")
    public List<User> findList(){
        return userMapper.queryUserList();
    }
}
