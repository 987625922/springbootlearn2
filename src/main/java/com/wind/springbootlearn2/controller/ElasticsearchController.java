package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.domain.JsonData;
import com.wind.springbootlearn2.domain.Article;
import com.wind.springbootlearn2.repository.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * elasticsearch学习使用的controller
 *
 * 主要有添加数据到elasticsearch
 */
@RestController
@RequestMapping("/api/elastic")
public class ElasticsearchController {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 把数据保存到elasticsearch中提供搜索
     *
     */
    @GetMapping("save")
    public Object save() {
        Article article = new Article();
        article.setId(1l);
        article.setPv(888);
        article.setContent("这是内容");
        article.setTitle("这是标题");
        article.setSummary("概要搜索");
        articleRepository.save(article);
        return new JsonData(200, "", "elastic保存成功！");
    }

    /**
     * 搜索elasticsearch中的内容
     *
     * @param title 要搜索的标题内容
     */
    @GetMapping("search")
    public Object search(String title){
//        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("title",title);
        Iterable<Article> list = articleRepository.search(queryBuilder);
        return new JsonData(200,list,"elastic搜索成功");
    }
}
