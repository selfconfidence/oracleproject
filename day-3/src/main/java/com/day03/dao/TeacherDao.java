package com.day03.dao;

import com.day03.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author misterWei
 * @create 2018年09月26号:12点14分
 * @mailbox mynameisweiyan@gmail.com
 */
public interface TeacherDao extends JpaRepository<Teacher,Long> ,JpaSpecificationExecutor<Teacher> {
}
