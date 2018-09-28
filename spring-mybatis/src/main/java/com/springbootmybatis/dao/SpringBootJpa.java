package com.springbootmybatis.dao;

import com.springbootmybatis.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author misterWei
 * @create 2018年09月27号:19点54分
 * @mailbox mynameisweiyan@gmail.com
 */
public interface SpringBootJpa extends JpaRepository<Student,Long>,JpaSpecificationExecutor<Student> {
}
