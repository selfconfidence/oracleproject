package com.onetomony;

import com.out.dao.StudentDao;
import com.out.dao.TeacherDao;
import com.out.domain.Student;
import com.out.domain.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author misterWei
 * @create 2018年09月26号:13点46分
 * @mailbox mynameisweiyan@gmail.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class test2 {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;
    @Test
    public void deletes() {
        System.out.println("SB");
        teacherDao.delete(1l);

    }
    @Test
    @Transactional
    public void findLJZ() {
        Teacher one = teacherDao.getOne(18l);

        System.out.println("4444");
        Set<Student> students = one.getStudents();
        System.out.println(students);
    }
    @Test
    @Transactional
    public void findLJZ2() {
        Student one = studentDao.findOne(17l);
        Teacher teacher = one.getTeacher();
        System.out.println(teacher);
    }


}
