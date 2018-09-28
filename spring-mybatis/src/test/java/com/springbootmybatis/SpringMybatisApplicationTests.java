package com.springbootmybatis;

import com.springbootmybatis.dao.UserMapper;
import com.springbootmybatis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest("classpath:applicationContext.xml")
public class SpringMybatisApplicationTests {
 @Autowired
 private UserMapper userMapper;
	@Test
	public void contextLoads() {
		List<User> users = userMapper.queryUserList();
		System.out.println(users);
	}

}
