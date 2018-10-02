package com.shiro.service;

import com.shiro.pojo.TbItem;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年09月30号:10点35分
 * @mailbox mynameisweiyan@gmail.com
 */
public interface ItemService {
    public List<TbItem> findList(String status);
}
