package com.day03.dao;

import com.day03.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年09月28号:20点25分
 * @mailbox mynameisweiyan@gmail.com
 */
public interface UserDao extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {

    public List<User> findByUName(String uName);
}
