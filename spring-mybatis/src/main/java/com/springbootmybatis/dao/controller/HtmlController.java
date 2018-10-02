package com.springbootmybatis.dao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author misterWei
 * @create 2018年09月29号:16点51分
 * @mailbox mynameisweiyan@gmail.com
 */
@Controller
public class HtmlController{

    @RequestMapping("/findIndex")
public String findIndex(){
        return "index.html";
    }

}
