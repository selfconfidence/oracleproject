package com.shiro.controller;

import com.shiro.service.impl.ShiroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author misterWei
 * @create 2018年10月01号:22点01分
 * @mailbox mynameisweiyan@gmail.com
 */
@Controller
@RequestMapping("/shiro")
public class ShiroController {
    @Autowired
    private ShiroServiceImpl shiroServiceImpl;


   @RequestMapping("/visit")
    public String visit(){
       shiroServiceImpl.visit();
       return "redirect:/search.html";
    }
}
