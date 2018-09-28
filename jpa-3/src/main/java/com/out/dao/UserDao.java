package com.out.dao;

import com.out.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author misterWei
 * @create 2018年09月26号:19点02分
 * @mailbox mynameisweiyan@gmail.com
 */
public interface UserDao extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {
}
