package com.springboot.entrance.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author misterWei
 * @create 2018年09月27号:10点50分
 * @mailbox mynameisweiyan@gmail.com
 */

@Controller                //用来指定前缀,也就是自定义对象名称,
public class WelcomeSpringBootController {
@Autowired
private Environment environment;
    @RequestMapping("/quick")
    @ResponseBody
    public String welcomeSpringBoot() {
        String name = environment.getProperty("name");
        String address = environment.getProperty("address");
        return name+"---"+address;
    }
}
