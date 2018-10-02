package com.shiro.dao;

import com.shiro.pojo.TbItem;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年09月30号:10点08分
 * @mailbox mynameisweiyan@gmail.com
 */
public interface ItemMapper {

    public List<TbItem> findList(String status);
}
