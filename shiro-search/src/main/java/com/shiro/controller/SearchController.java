package com.shiro.controller;
import com.shiro.service.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
/**
 * @author misterWei
 * @create 2018年09月30号:13点57分
 * @mailbox mynameisweiyan@gmail.com
 */
@RestController
public class SearchController {
    @Autowired
    private ElasticSearchService elasticSearchService;

    @RequestMapping("/findEntry")
    public Map findEntry (@RequestBody Map map){

      return   elasticSearchService.findElasticSearch(map);

    }
}
