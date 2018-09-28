package com.springbootmybatis;

import com.springbootmybatis.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年09月27号:19点56分
 * @mailbox mynameisweiyan@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringMybatisApplication.class)
public class SpringBootJpa{
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private com.springbootmybatis.dao.SpringBootJpa  springBootJpa;
    @Test
    public  void  japinsert(){
        Student student = new Student();
        student.setSname("小明同学2!");
        springBootJpa.save(student);
    }

    @Test
    public void  findlist(){
        List<Student> find_studentList = (List<Student>) redisTemplate.boundValueOps("find_studentList").get();
        if (find_studentList==null){
            find_studentList = springBootJpa.findAll();
            redisTemplate.boundValueOps("find_studentList").set(find_studentList);
            System.out.println("数据库读取数据");
        }else{
            System.out.println("Redis拿取数据");
        }
        System.out.println(find_studentList);
    }
}
