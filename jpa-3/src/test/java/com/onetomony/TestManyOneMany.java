package com.onetomony;

import com.out.dao.RoleDao;
import com.out.dao.UserDao;
import com.out.domain.Role;
import com.out.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author misterWei
 * @create 2018年09月26号:19点10分
 * @mailbox mynameisweiyan@gmail.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestManyOneMany {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    @Rollback(false)
    public void saveMony(){
        Role role = new Role();
        User user = new User();
        role.setrName("机器人");
        user.setuName("张三");
        role.getUsers().add(user);
        roleDao.save(role);

        Role roles = new Role();
        User users = new User();
        roles.setrName("机器人");
        users.setuName("张三");
        roles.getUsers().add(users);
        roleDao.save(roles);


    }
    @Test
    @Transactional
    @Rollback(false)
    public void deleteMony(){
        Role one = roleDao.getOne(1l);
        roleDao.delete(one);
    }
    @Test
    @Transactional
    @Rollback(false)
    public void fondOne(){
        User one = userDao.getOne(8l);
        System.out.println("从此经过...");
        System.out.println(one.getRoles());
    }
}
