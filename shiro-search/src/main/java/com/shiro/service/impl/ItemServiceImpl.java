package com.shiro.service.impl;

import com.shiro.dao.ItemMapper;
import com.shiro.pojo.TbItem;
import com.shiro.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年09月30号:10点36分
 * @mailbox mynameisweiyan@gmail.com
 */
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemMapper itemMapper;

    public List<TbItem> findList(String status) {

        return itemMapper.findList(status);
    }
}
