package com.shiro.test;

import com.shiro.dao.ItemMapper;
import com.shiro.dao.ItemRepository;
import com.shiro.pojo.TbItem;
import org.elasticsearch.client.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年09月30号:12点57分
 * @mailbox mynameisweiyan@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class SaveIndex {
    @Autowired
    private Client client;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
   @Autowired
   private ItemMapper itemMapper;

    @Test
    public void  savaIndex(){
        //创建索引
        elasticsearchTemplate.createIndex(TbItem.class);
        elasticsearchTemplate.putMapping(TbItem.class);
    }
    @Test
    public void saveItemList(){
        List<TbItem> list = itemMapper.findList("1");
        itemRepository.save(list);
    }
    @Test
    public void deleteItemList(){
    itemRepository.deleteAll();
    }
}
