package com.shiro.service.impl;
import com.shiro.dao.ItemRepository;
import com.shiro.pojo.TbItem;
import com.shiro.service.ElasticSearchService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
/**
 * @author misterWei
 * @create 2018年09月30号:12点42分
 * @mailbox mynameisweiyan@gmail.com
 */
@Service
public class ElasticSearchImpl implements ElasticSearchService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private Client client;// 基于原生的APi
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;// spring整合之后的API

    public Map findElasticSearch(Map map) {
             Map itemMap = new HashMap();
        Page<TbItem> highLigthQuery = highLigthQuery("title",map);
        itemMap.put("pagetotal",highLigthQuery.getTotalElements());
        itemMap.put("pagenumbers",highLigthQuery.getTotalPages());
        itemMap.put("itemList",highLigthQuery.getContent());
          return itemMap;

    }

    // 高亮显示的分装
    private Page<TbItem> highLigthQuery(final String field,Map map) {
        // 设置高亮显示字段
      String  searchMessage = (String) map.get("title");
        HighlightBuilder.Field field2 = new HighlightBuilder.Field(field);
        field2.postTags("</font>");
        field2.preTags("<font color='red'>");

        // 设置分页规则
        int pagenum = (Integer) map.get("pagenum");
        int size = (Integer)map.get("size");
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.termQuery(field, searchMessage)).withHighlightFields(field2)
                .withSort(new FieldSortBuilder("id").order(SortOrder.DESC)).build()

                .setPageable(new PageRequest(pagenum, size));

        // 进行高亮操作
        Page<TbItem> queryForPage = elasticsearchTemplate.queryForPage(searchQuery, TbItem.class,
                new SearchResultMapper() {

                    public <T> Page<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
                        long totalHits = response.getHits().totalHits();
                        List<TbItem> poems = new ArrayList<TbItem>();
                        SearchHits hits = response.getHits();
                        for (SearchHit searchHit : hits) {
                            if (hits.getHits().length <= 0) {
                                return null;
                            }
                            TbItem article = new TbItem();

                            String highLightMessage = searchHit.getHighlightFields().get(field).fragments()[0]
                                    .toString();

                            article.setId((long) Integer.parseInt(searchHit.getId()));
                            article.setTitle(String.valueOf(searchHit.getSource().get("title")));
                            article.setImage(String.valueOf(searchHit.getSource().get("image")));
                            article.setPrice(new BigDecimal ((Double)searchHit.getSource().get("price")));
                            article.setBrand((String) searchHit.getSource().get("brand"));
                            article.setCreateTime(new Date((Long)searchHit.getSource().get("createTime")));
                            String setMethodName = parSetName(field);
                            Class<? extends TbItem> class1 = article.getClass();
                            try {
                                Method method = class1.getMethod(setMethodName, String.class);
                                method.invoke(article, highLightMessage);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            poems.add(article);
                        }

                        if (poems.size() > 0) {

                            PageImpl<TbItem> pageImpl = new PageImpl<TbItem>(poems, pageable, totalHits);

                            return (Page<T>) pageImpl;
                        }
                        return null;

                    }

                });

        return queryForPage;
    }

    private static String parSetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_')
            startIndex = 1;
        return "set" + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);

    }
}
