package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.domain.JsonData;
import com.wind.springbootlearn2.domain.Article;
import com.wind.springbootlearn2.repository.ArticleRepository;
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

    @GetMapping("save")
    public Object save() {
        Article article = new Article();
        article.setId(System.currentTimeMillis());
        article.setPv(888);
        article.setContent("这是内容");
        article.setTitle("这是标题");
        article.setSummary("概要搜索");
        articleRepository.save(article);
        return new JsonData(200, "", "elastic保存成功！");
    }
}
