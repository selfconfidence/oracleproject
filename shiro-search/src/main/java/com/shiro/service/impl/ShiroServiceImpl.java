package com.shiro.service.impl;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author misterWei
 * @create 2018年10月01号:22点02分
 * @mailbox mynameisweiyan@gmail.com
 */
@Service
public class ShiroServiceImpl {
    @RequiresRoles({"admin","manager"})
    public void visit(){
        System.out.println(new Date().toLocaleString());
    }
}
