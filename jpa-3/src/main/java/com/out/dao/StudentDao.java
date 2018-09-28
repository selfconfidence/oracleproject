package com.out.dao;

import com.out.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author misterWei
 * @create 2018年09月26号:12点11分
 * @mailbox mynameisweiyan@gmail.com
 */
public interface StudentDao extends JpaRepository<Student,Long>,JpaSpecificationExecutor<Student>{


}
