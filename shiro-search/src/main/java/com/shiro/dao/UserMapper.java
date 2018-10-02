package com.shiro.dao;

import com.shiro.pojo.User;

/**
 * @author misterWei
 * @create 2018年10月01号:00点34分
 * @mailbox mynameisweiyan@gmail.com
 */
public interface UserMapper {
    public User findOne(String name);
}
