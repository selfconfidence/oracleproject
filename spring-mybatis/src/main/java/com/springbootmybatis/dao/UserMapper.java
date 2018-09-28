package com.springbootmybatis.dao;

import com.springbootmybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年09月27号:18点22分
 * @mailbox mynameisweiyan@gmail.com
 */
@Mapper
public interface UserMapper {
    public List<User> queryUserList();
}
