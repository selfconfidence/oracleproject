package com.shiro.controller;

import com.shiro.pojo.TbItem;
import com.shiro.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年09月30号:10点38分
 * @mailbox mynameisweiyan@gmail.com
 */
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/find")
    public List<TbItem> findItemList(){
        return itemService.findList("1");
    }
}
