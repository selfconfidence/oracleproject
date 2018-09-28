package com.onetomony;

import com.out.dao.StudentDao;
import com.out.dao.TeacherDao;
import com.out.domain.Student;
import com.out.domain.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author misterWei
 * @create 2018年09月26号:13点46分
 * @mailbox mynameisweiyan@gmail.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class test1 {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;



    @Test
    @Transactional
    @Rollback(false)
    public   void deleteTeacherDao(){
        Teacher one = teacherDao.getOne(4l);
        System.out.println(one);
        System.out.println(one.getStudents());

    }




    @Test
    @Transactional
    @Rollback(false)
    public void saves() {
        Student student = new Student();
        Teacher teacher = new Teacher();
        student.setSname("小花同学");
        student.setGrade("0");
        student.setAge(18);
        student.setGender(1);
        teacher.setTname("王老师");
        teacher.setTage(18);
        teacher.setSex("1");
        student.setTeacher(teacher);
        studentDao.save(student);


    }



}
