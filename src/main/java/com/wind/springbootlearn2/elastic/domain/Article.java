package com.wind.springbootlearn2.elastic.domain;

import lombok.Data;

import java.io.Serializable;

/*
 * 学习elastic使用的实体类（文章对象）
 *
 * */
//@Document(indexName = "blog",type = "article")
@Data
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String title;
    private String summary;
    private String content;
    private int pv;

}

