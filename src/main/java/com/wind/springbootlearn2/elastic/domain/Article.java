package com.wind.springbootlearn2.elastic.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Document(indexName = "blog",type = "article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String title;
    private String summary;
    private String content;
    private int pv;

}
/*
 * 学习elastic使用的实体类（文章对象）
 *
 * */

