package com.shiro.dao;

import com.shiro.pojo.TbItem;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @author misterWei
 * @create 2018年09月30号:12点41分
 * @mailbox mynameisweiyan@gmail.com
 */
public interface ItemRepository extends ElasticsearchCrudRepository<TbItem,Long> {
}
